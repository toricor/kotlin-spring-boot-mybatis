package com.toricor.training.reservation

import com.toricor.training.reservation.dao.Reservation
import com.toricor.training.reservation.dao.ReservationWithUserNameAndEventName
import com.toricor.training.user.dao.User
import org.apache.ibatis.annotations.*

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

    @Insert("INSERT INTO reservation(user_id, event_id) VALUES(#{user_id}, #{event_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(reservation: Reservation)

    @Update("UPDATE reservation SET user_id = #{user_id}, event_id = #{event_id} WHERE id = #{id}")
    fun update(reservation: Reservation)

    @Delete("DELETE FROM reservation WHERE id = #{id}")
    fun delete(@Param("id") id: Int)

    @Delete("DELETE FROM user")
    fun deleteAll()
}