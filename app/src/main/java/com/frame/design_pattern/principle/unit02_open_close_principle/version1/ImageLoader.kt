package com.frame.design_pattern.principle.unit02_open_close_principle.version1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit01_single_responsibility_principle.version2
 * @ClassName: ImageLoader
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 10:05 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 10:05 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ImageLoader {
    //内存缓存
    val mImageCache = ImageCache()

    //SD卡缓存
    val mDiskCache = DiskCache()

    //是否使用SD卡缓存
    var isUseDiskCache = false

    //线程池，线程数量为CPU的数量
    val mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    //UI handler
    val mUiHandler = Handler(Looper.getMainLooper())

    fun updateImageView(imageView: ImageView, bitmap: Bitmap) {
        mUiHandler.post {
            imageView.setImageBitmap(bitmap)
        }
    }

    fun useDiskCache(useDiskCache: Boolean) {
        this.isUseDiskCache = useDiskCache
    }

    //加载图片
    fun displayImage(url: String, imageView: ImageView) {
        val bitmap = if (isUseDiskCache) mDiskCache.get(url) else mImageCache.get(url)
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
            return
        }
        imageView.tag = url
        mExecutorService.submit {
            val bitmapDownload = downloadImage(url) ?: return@submit
            if (imageView.tag == url) {
                updateImageView(imageView, bitmapDownload)
            }
            mImageCache.put(url, bitmapDownload)
        }

    }

    private fun downloadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val url = URL(imageUrl)
            val httpURLConnection = url.openConnection() as HttpURLConnection
            bitmap = BitmapFactory.decodeStream(httpURLConnection.inputStream)
            httpURLConnection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }


}