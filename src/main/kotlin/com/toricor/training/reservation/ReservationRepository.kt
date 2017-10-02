package com.toricor.training.reservation

import com.toricor.training.reservation.dao.Reservation
import com.toricor.training.reservation.dao.ReservationWithUserNameAndEventName
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface ReservationRepository {

    @Select("SELECT * FROM reservation")
    fun findAll(): List<Reservation>

    @Select("SELECT * FROM reservation WHERE id = #{id}")
    fun findOne(@Param("id") id: Int): Reservation

    @Select("""
        SELECT
            reservation.id, user.name, event.title
        FROM
            reservation
        INNER JOIN
            user
        ON
            user.id = reservation.user_id
        INNER JOIN
            event
        ON
            event.id = reservation.event_id
    """)
    fun findAllWithUserNameAndEventName(): List<ReservationWithUserNameAndEventName>
}