package com.toricor.training.event

import org.apache.ibatis.annotations.*

@Mapper
interface EventRepository {

    @Select("SELECT * FROM event")
    fun findAll(): List<Event>

    @Select("SELECT * FROM event WHERE id = #{id}")
    fun findOne(@Param("id") id: Int): Event

    @Insert("INSERT INTO event(title) VALUES(#{title})")
    @SelectKey(statement = arrayOf("call identity()"), keyProperty = "id", before = false, resultType = Int::class)
    fun insert(event: Event)

    @Update("UPDATE event SET title = #{title} WHERE id = #{id}")
    fun update(event: Event)

    @Delete("DELETE FROM event WHERE id = #{id}")
    fun delete(@Param("id") id: Int)

    @Select("""
        SELECT
            *
        FROM
            event
        WHERE
            title LIKE #{title}
        ORDER BY id
    """)
    fun findByTitle(@Param("title") title: String): List<Event>

    @Delete("DELETE FROM event")
    fun deleteAll()
}