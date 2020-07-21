package com.frame.design_pattern.principle.unit03_liskov_substitution_principle.version1

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit03_liskov_substitution_principle.version1
 * @ClassName: View
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 11:53 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 11:53 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class View {
    abstract fun draw()
    fun measure(width:Int,height:Int){

    }
}