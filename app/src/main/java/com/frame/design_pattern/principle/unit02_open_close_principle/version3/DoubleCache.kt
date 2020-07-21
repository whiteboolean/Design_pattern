package com.frame.design_pattern.principle.unit02_open_close_principle.version3

import android.graphics.Bitmap
import com.frame.design_pattern.principle.unit02_open_close_principle.version1.DiskCache

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit02_open_close_principle.version3
 * @ClassName: DoubleCache
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 11:29 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 11:29 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class DoubleCache :ImageCache {
    val mMemoryCache = com.frame.design_pattern.principle.unit01_single_responsibility_principle.version2.ImageCache()
    val mDiskCache = DiskCache()

    //先从内存中获取，如果没有，再从SD卡中获取
    override fun get(url: String): Bitmap {
        return mMemoryCache.get(url) ?: mDiskCache.get(url)
    }

    //将图片缓存到内存和SD卡中
    override fun  put(url:String,bitmap: Bitmap){
        mDiskCache.put(url,bitmap)
        mMemoryCache.put(url,bitmap)
    }
}