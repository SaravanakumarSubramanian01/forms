package com.tringapps.forms.database

import com.tringapps.forms.model.User

interface UserDataSource {
    fun getUsers():Collection<User>
    fun getUserById( userId:Int ):User
    fun createUser(user: User):User
    fun updateUser(user: User):User
    fun deleteUser(userId: Int): String
}