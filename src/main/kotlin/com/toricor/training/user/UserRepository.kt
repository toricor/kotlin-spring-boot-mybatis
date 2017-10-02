package com.toricor.training.user

import org.apache.ibatis.annotations.*

@Mapper
interface UserRepository {

    @Select("SELECT * FROM user")
    fun findAll(): List<User>

    @Select("SELECT * FROM user WHERE id = #{id}")
    fun findOne(@Param("id") id: Int): User

    @Insert("INSERT INTO user(name) VALUES(#{name})")
    @SelectKey(statement = arrayOf("call identity()"), keyProperty = "id", before = false, resultType = Int::class)
    fun insert(user: User)

    @Update("UPDATE user SET name = #{name} WHERE id = #{id}")
    fun update(user: User)

    @Delete("DELETE FROM user WHERE id = #{id}")
    fun delete(@Param("id") id: Int)

    @Select("""
        SELECT
            *
        FROM
            user
        WHERE
            name LIKE #{name}
        ORDER BY id
    """)
    fun findByName(@Param("name") name: String): List<User>

    @Delete("DELETE FROM user")
    fun deleteAll()
}