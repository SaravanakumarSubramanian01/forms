package com.tringapps.forms.controller

import com.tringapps.forms.database.mock.MockUserDataSource
import com.tringapps.forms.model.User
import com.tringapps.forms.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
class UserController(val service: UserService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException):ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException):ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/users")
    fun getAllUsers():Collection<User> = service.getUsers()

    @GetMapping("/{userId}")
    fun getAllUserById(@PathVariable userId:Int):User = service.getUserById( userId )

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user:User): User = service.createUser(user)

    @PatchMapping("/updateUser")
    fun updateUser(@RequestBody user: User) = service.updateUser(user)

    @DeleteMapping("/deleteUser/{userId}")
    fun deleteUser(@PathVariable userId: Int) = service.deleteUser(userId)
}