package com.frame.design_pattern.principle.unit01_single_responsibility_principle.version1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.collection.LruCache
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit01_single_responsibility_principle
 * @ClassName: ImageLoader
 * @Description: 单一职责原则 - 图片加载类
 * @Author: Jett
 * @CreateDate: 2020/7/21 9:21 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 9:21 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ImageLoader() {

    //图片缓存
    lateinit var mImageCache: LruCache<String, Bitmap>

    //线程池，线程数量为cpu的数量
    val mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    //ui Handler
    val handler = Handler(Looper.getMainLooper())

    init {
        initImageCache()
    }

    private fun initImageCache() {
        //计算可使用的最大内存
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        //取四分之一的可用内存作为缓存
        val cacheSize = maxMemory / 4

        mImageCache = object : LruCache<String, Bitmap>(cacheSize) {

            //计算缓存对象的大小，单位为kb和上面保持一致
            override fun sizeOf(key: String, value: Bitmap): Int {
                return value.rowBytes * value.height / 1024
            }
        }
    }


    fun displayImage(url: String, imageView: ImageView) {
        imageView.tag = url
        mExecutorService.submit {
            var bitmap = mImageCache.get(url)
            if (bitmap == null) {
                bitmap = downLoadImage(url) ?: return@submit
            }
            if (imageView.tag == url) {
                updateImageView(imageView, bitmap)
            }
            mImageCache.put(url, bitmap)
        }
    }

    private fun updateImageView(imageView: ImageView, bitmap: Bitmap) {
        handler.post {
            imageView.setImageBitmap(bitmap)
        }
    }


    private fun downLoadImage(strUrl: String): Bitmap? {
        var bitMap: Bitmap? = null
        try {
            val url = URL(strUrl)
            val conn = url.openConnection() as HttpURLConnection
            bitMap = BitmapFactory.decodeStream(conn.inputStream)
            conn.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitMap
    }
}



