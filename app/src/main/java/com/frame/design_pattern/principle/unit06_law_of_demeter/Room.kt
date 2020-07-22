package com.frame.design_pattern.principle.unit06_law_of_demeter

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit06_law_of_demeter
 * @ClassName: Room
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 1:40 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 1:40 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 房间
 */
class Room {
    var area: Float = 0f
    var price: Float = 0f

    constructor(area:Float,price:Float){
        this.area = area
        this.price = price
    }

    override fun toString(): String {
        return "Room(area=$area, price=$price)"
    }


}