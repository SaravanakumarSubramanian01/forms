package com.tringapps.forms.service

import com.tringapps.forms.database.UserDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UserServiceTest{
    private val dataSource:UserDataSource = mockk(relaxed = true)
    private val userService = UserService(dataSource)

    @Test
    fun `should call its data source`(){
        // given


        // when
        val users = userService.getUsers()

        // then
        verify(exactly = 1) { dataSource.getUsers() }

    }

    @Test
    fun `should call its data source with userId`(){
        // given


        // when
        val users = userService.getUserById(2)

        // then
        verify(exactly = 1) { dataSource.getUserById(2) }
    }
}