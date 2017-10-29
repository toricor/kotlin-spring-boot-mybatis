package com.toricor.training.user

import com.toricor.training.user.dao.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getUsers(): List<User> =
            userService.findAll()

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Int): User =
            userService.findOne(id)

    @GetMapping("/search")
    fun getUsersByName(@RequestParam name: String): List<User> =
            userService.findByName(name)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User) =
            userService.create(user)

    @PostMapping("{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User) {
        userService.update(user)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Int) {
        userService.delete(id)
    }
}