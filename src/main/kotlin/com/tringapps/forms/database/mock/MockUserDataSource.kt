package com.tringapps.forms.database.mock

import com.tringapps.forms.database.UserDataSource
import com.tringapps.forms.model.Role
import com.tringapps.forms.model.User
import org.springframework.stereotype.Repository

@Repository
class MockUserDataSource :UserDataSource{

    val users = mutableListOf<User>(
        User(
            1,
            "SaravanaKumar",
            "subramanian",
            "saravanakumar.s@tringapps.com",
            "",
            Role(1,"Senior software engineer")
        ),
        User(
            2,
            "Ajithkumar",
            "S",
            "ajithkumar.s@tringapps.com",
            "",
            Role(2,"Senior software engineer")
        ),
    )
    override fun getUsers(): Collection<User>  = users

    override fun getUserById( userId:Int ): User =
        users.firstOrNull(){ it.userId==userId }
        ?: throw NoSuchElementException("userId $userId not found ")

    override fun createUser(user: User): User {
        if(users.any{ it.emailId == user.emailId}){
            throw IllegalArgumentException("User with emailId ${user.emailId} already exist" )
        }
        users.add(user)
        return user

    }

    override fun updateUser(user: User): User {
        val currentUser = users.firstOrNull {it.emailId == user.emailId }
            ?:throw NoSuchElementException("User not found")
        users.remove(currentUser)
        users.add(user)

        return user
    }

    override fun deleteUser(userId: Int): String {
        val currentUser = users.firstOrNull {it.userId == userId }
            ?:throw NoSuchElementException("User not found")
        users.remove(currentUser)

        return "User deleted successfully"
    }


}