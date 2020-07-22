package com.frame.design_pattern.principle.unit05_interface_segregation_principles

import android.graphics.Bitmap
import com.frame.design_pattern.principle.unit02_open_close_principle.version1.cacheDir
import java.io.Closeable
import java.io.FileOutputStream
import java.io.IOException

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit05_interface_segregation_principles
 * @ClassName: Princeple
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 12:06 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 12:06 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 接口隔离原则：
 * 两种定义：
 * 1.客户端不应该依赖它不需要的即可欧
 * 2.类间的依赖关系应该建立在最小的接口上面。
 * 接口隔离原则将非常庞大，臃肿的接口拆分为更小和更具体的接口。
 *
 *
 */
class Princeple {



    fun  put (url:String,bitmap: Bitmap){
        var fileOutputStream:FileOutputStream ? = null
        try {
            fileOutputStream = FileOutputStream(cacheDir + url)
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream .close()
                } catch (e:IOException){
                    e.printStackTrace()
                }
            }
        }


    }

    //改进版
    fun  putUpdate (url:String,bitmap: Bitmap){
        var fileOutputStream:FileOutputStream ? = null
        try {
            fileOutputStream = FileOutputStream(cacheDir + url)
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
          CloseUtils.closeQuietly(fileOutputStream as Closeable)
        }


    }


    /**
     *
     * Bob大叔 (Robert C Martin)在21世纪早期，将单一职责，开闭原则，里氏替换原则，接口隔离原则，依赖倒置原则
     * SOLID、
     * 作为面向对象编程的5个基本原则
     */
}