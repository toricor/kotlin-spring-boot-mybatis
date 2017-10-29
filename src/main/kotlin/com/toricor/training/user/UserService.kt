package com.toricor.training.user

import com.toricor.training.user.dao.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var UserRepository: UserRepository

    fun findAll(): List<User> =
            UserRepository.findAll()


    fun findOne(id: Int): User =
            UserRepository.findOne(id)


    fun findByName(name: String): List<User> =
            UserRepository.findByName(name)


    fun create(user: User){
        UserRepository.insert(user)
    }

    fun update(user: User){
        UserRepository.update(user)
    }

    fun delete(id: Int) {
        UserRepository.delete(id)
    }

}