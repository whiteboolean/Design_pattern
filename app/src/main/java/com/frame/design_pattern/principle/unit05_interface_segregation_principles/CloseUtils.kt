package com.frame.design_pattern.principle.unit05_interface_segregation_principles

import java.io.Closeable
import java.io.IOException

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit05_interface_segregation_principles
 * @ClassName: CloseUtils
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 12:10 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 12:10 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

class CloseUtils{

    private constructor(){

    }

    companion object{
        fun closeQuietly(closeable: Closeable){
            try {
                closeable.close()
            } catch (e:IOException){
                e.printStackTrace()
            }
        }
    }
}