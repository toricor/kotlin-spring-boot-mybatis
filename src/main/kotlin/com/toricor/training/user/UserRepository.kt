package com.toricor.training.user

import org.apache.ibatis.annotations.*

@Mapper
interface UserRepository {

    @Select("SELECT * FROM Users ORDER BY id")
    fun findAll(): List<User>

    @Select("SELECT * FROM Users WHERE id = #{id}")
    fun findOne(@Param("id") id: Int): User

    @Insert("INSERT INTO Users(first_name, last_name, address) VALUES(#{firstName}, #{lastName}, #{address})")
    @SelectKey(statement = arrayOf("call identity()"), keyProperty = "id", before = false, resultType = Int::class)
    fun insert(user: User)

    @Update("UPDATE Users SET first_name = #{firstName}, last_name = #{lastName}, address = #{address} WHERE id = #{id}")
    fun update(user: User)

    @Delete("DELETE FROM Users WHERE id = #{id}")
    fun delete(@Param("id") id: Int)

    @Select("""
        SELECT
            *
        FROM
            Users
        WHERE
            first_name LIKE #{firstName}
        ORDER BY id
    """)
    fun findByFirstName(@Param("firstName") firstName: String): List<User>

    @Delete("DELETE FROM Users")
    fun deleteAll()
}