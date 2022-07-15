package com.tringapps.forms.service

import com.tringapps.forms.database.UserDataSource
import com.tringapps.forms.model.User
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class UserService( private val dataSource: UserDataSource) {
    fun getUsers():Collection<User> = dataSource.getUsers()
    fun getUserById( userId:Int):User = dataSource.getUserById( userId )
    fun createUser(user: User):User = dataSource.createUser(user)
    fun updateUser(user: User):User = dataSource.updateUser(user)
    fun deleteUser(userId: Int):String = dataSource.deleteUser(userId)
}