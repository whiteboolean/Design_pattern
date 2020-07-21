package com.frame.design_pattern.principle.unit02_open_close_principle.version1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit02_open_close_principle.version1
 * @ClassName: DiskCache
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 10:56 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 10:56 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
const val cacheDir = "sdcard/cache/"

class DiskCache {


    //从缓存中获取图片
    //将文件转化为 ---> Bitmap
    fun get(url: String): Bitmap {
        return BitmapFactory.decodeFile(cacheDir + url)
    }

    //将图片缓存到内存中
    fun put(url: String, bitmap: Bitmap) {
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream("$url$bitmap")
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }


}