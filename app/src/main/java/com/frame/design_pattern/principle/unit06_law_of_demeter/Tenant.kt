package com.frame.design_pattern.principle.unit06_law_of_demeter

/**
 *
 * @ProjectName: Design_pattern
 * @Package: com.frame.design_pattern.principle.unit06_law_of_demeter
 * @ClassName: Tenant
 * @Description: java类作用描述
 * @Author: Jett
 * @CreateDate: 2020/7/21 2:42 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/21 2:42 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 租户
 */
class Tenant {


    fun rentRoom(roomArea: Float, roomPrice: Float, mediator: Mediator) {
        val rooms = mediator.getAllRooms()
        for (room in rooms) {
            if (isSuitable(roomArea,roomPrice,room)){
                println("租到房子拉！$room")
                break
            }
        }
    }


    fun isSuitable(roomArea: Float, roomPrice: Float, room: Room) :Boolean {
        return room.price <= roomPrice && room.area >= roomArea
    }







}