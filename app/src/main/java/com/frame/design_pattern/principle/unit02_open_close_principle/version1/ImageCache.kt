package com.frame.design_pattern.principle.unit02_open_close_principle.version1

import android.graphics.Bitmap
import android.util.LruCache

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit01_single_responsibility_principle.version2
 * @ClassName: ImageCache
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 10:13 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 10:13 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ImageCache {

    //图片LRU缓存

    lateinit var mImageCache:LruCache<String,Bitmap>

    init {
        initImageCache()
    }

    private fun initImageCache() {
        //计算可使用的最大内存
        val  maxMemory = (Runtime.getRuntime().maxMemory()).toInt()
        val cacheSize = maxMemory/ 4
        mImageCache = object:LruCache<String,Bitmap>(cacheSize){
            override fun sizeOf(key: String, value: Bitmap): Int {
                return value.rowBytes * value.height/1024
            }
        }
    }


    fun put(url:String,bitmap:Bitmap){
        mImageCache.put(url,bitmap)
    }

    fun get(url:String):Bitmap?{
        return mImageCache.get(url)
    }

}