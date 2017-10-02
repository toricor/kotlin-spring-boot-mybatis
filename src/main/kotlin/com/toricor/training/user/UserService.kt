package com.toricor.training.user

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


    fun findByFirstName(firstName: String): List<User> =
            UserRepository.findByFirstName(firstName)


    fun create(user: User): User {
        UserRepository.insert(user)
        return user
    }

    fun update(user: User): User {
        UserRepository.update(user)
        return user
    }

    fun delete(id: Int) {
        UserRepository.delete(id)
    }

}