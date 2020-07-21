package com.frame.design_pattern.principle.unit03_liskov_substitution_principle.version1


/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit03_liskov_substitution_principle.version1
 * @ClassName: Window
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 11:51 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 11:51 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 里氏替换原则：
 *  所有引用基类的地方必须能透明地使用其子类
 *
 *  里氏替换原则依赖于： 继承和多态两大特性
 */
class Window {
    fun show(child: View){
        child.draw()
    }
}