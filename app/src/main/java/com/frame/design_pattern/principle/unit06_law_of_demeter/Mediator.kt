package com.frame.design_pattern.principle.unit06_law_of_demeter

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit06_law_of_demeter
 * @ClassName: Mediator
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 2:39 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 2:39 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class Mediator {

    val mRooms = ArrayList<Room>()

    init {
        for (i in 0 until 5) {
            mRooms.add(Room((14 + i).toFloat(), (14 + i) * 150.toFloat()))
        }
    }

    fun getAllRooms(): List<Room> {
        return mRooms
    }


    fun rentOut(area: Float, price: Float): Room? {
        for (mRoom in mRooms) {
            if (isSuitable(area, price, mRoom)) {
                return mRoom
            }
        }
        return null
    }


    fun isSuitable(area: Float, price: Float, room: Room): Boolean {
        return room.price <= price && room.area >= area
    }


}