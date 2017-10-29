package com.toricor.training.user

import com.toricor.training.user.dao.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun findAll(): List<User> = userRepository.findAll()

    fun findOne(id: Int): User = userRepository.findOne(id)

    fun findByName(name: String): List<User> = userRepository.findByName(name)

    fun create(user: User){
        userRepository.insert(user)
    }

    fun update(user: User){
        userRepository.update(user)
    }

    fun delete(id: Int) {
        userRepository.delete(id)
    }

}