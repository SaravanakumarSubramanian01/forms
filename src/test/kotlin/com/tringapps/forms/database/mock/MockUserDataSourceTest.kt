package com.tringapps.forms.database.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockUserDataSourceTest{
    private val mockUsersDataSource = MockUserDataSource()
    @Test
    fun `should provide collection of USERS`(){
        // given


        // when
        val users = mockUsersDataSource.getUsers()

        // then
        assertThat(users).isNotEmpty

    }

    @Test
    fun `should provide user`(){
        // given


        // when
        val users = mockUsersDataSource.getUserById(1)

        // then
        assertThat(users).matches{it.firstName == "SaravanaKumar"}

    }

}