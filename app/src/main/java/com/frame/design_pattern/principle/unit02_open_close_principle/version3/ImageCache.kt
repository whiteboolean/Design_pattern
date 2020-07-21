package com.frame.design_pattern.principle.unit02_open_close_principle.version3

import android.graphics.Bitmap

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit02_open_close_principle.version3
 * @ClassName: ImageCache1
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 11:28 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 11:28 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface ImageCache {
    fun get(url: String): Bitmap?
    fun put(url: String, bitmap: Bitmap)
}