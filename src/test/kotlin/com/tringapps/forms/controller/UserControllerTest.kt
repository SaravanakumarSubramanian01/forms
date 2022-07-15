package com.tringapps.forms.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.tringapps.forms.model.Role
import com.tringapps.forms.model.User
import com.tringapps.forms.utils.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*


@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
){

    @Nested
    @DisplayName("GET/ GetUsers")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class  GetUsers{

        @Test
        @DirtiesContext
        fun `should return all users`(){
            // given
            mockMvc.get(GET_USERS)
                .andDo { print() }
                .andExpect {
                    status {isOk()}
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

            // when


            // then

        }

    }

    @Nested
    @DisplayName("GET/ GetUser")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class  GetUser {
        @Test
        @DirtiesContext
        fun `should  return the user by userId`(){
            val userId = 2
            // given
            mockMvc.get("${GET_USER_BY_ID}${userId}")
                .andDo { print() }
                .andExpect {
                    status {isOk()}
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.userId"){value("2")}
                }

            // when


            // then

        }

        @Test
        @DirtiesContext
        fun `should return not found if user not exist`(){
            // given
            val userId = -1

            // when
            mockMvc.get("${GET_USER_BY_ID}${userId}")
                .andDo { print() }
                .andExpect {
                    status {isNotFound()}
                }


            // then

        }


    }

    @Nested
    @DisplayName("POST/ Create User")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class  CreateUser{
        @Test
        @DirtiesContext
        fun `should create new user`(){

            // given
            val givenUser = User(
                100,
                "TestUser",
                "S",
                "testuser.s@tringapps.com",
                "",
                 Role(100,"Senior software engineer")
            )

            val givenRole = objectMapper.writeValueAsString(
                Role(100,"Senior software engineer")
            )
            
            // when
            val performCreate = mockMvc.post(REGISTER_USER){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(givenUser)
            }
            
            // then
            performCreate
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(givenUser))
                    }
                    jsonPath("$.userId"){value(100)}
                    jsonPath("$.firstName"){value("TestUser")}
                    jsonPath("$.lastName"){value("S")}
                    jsonPath("$.emailId"){value("testuser.s@tringapps.com")}
                    jsonPath("$.password"){value("")}
                }
        }

        @Test
        @DirtiesContext
        fun `should return BAD Request`(){
            // given
            val invalidUser = User(
                -1,
                "TestUser",
                "S",
                "testuser.s@tringapps.com",
                "",
                Role(-1,"Senior software engineer")
            )

            // when
            val performCreate = mockMvc.post(REGISTER_USER){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidUser)
            }

            // then
            performCreate
                .andDo { print() }
                .andExpect {
                    status { isBadRequest() }
                }

        }

    }

    @Nested
    @DisplayName("PATCH/ update user")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class UpdateExistingUser{
        @Test
        @DirtiesContext
        fun `should update an existing user`(){
            // given
            val updatedUser = User(
                1,
                "Saravanakumar",
                "S",
                "saravanakumar.s@tringapps.com",
                "",
                Role(1,"Senior software engineer")
            )


            // when
            val performPatch = mockMvc.patch(UPDATE_USER){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedUser)
            }


            // then
            performPatch
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        json(objectMapper.writeValueAsString(updatedUser))
                    }

                }

        }

        @Test
        @DirtiesContext
        fun `should return BAD Request`(){
            // given
            val invalidUser = User(
                -1,
                "TestUser",
                "Doesnotexits",
                "Doesnotexits",
                "",
                Role(-1,"Senior software engineer")
            )

            // when
            val performPatch = mockMvc.patch(UPDATE_USER){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidUser)
            }

            // then
            performPatch
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
        }

    }

    @Nested
    @DisplayName("DELETE/ delete user")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class DeleteUser {
        @Test
        @DirtiesContext
        fun `should delete an existing user`(){
            // given
            val deleteUser = "User deleted successfully"
            val userId = 1
            // when
            val performDelete = mockMvc.delete("${DELETE_USER}${userId}"){
                contentType = MediaType.TEXT_PLAIN
                content = objectMapper.writeValueAsString(deleteUser)
            }

            // then
            performDelete
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                       "User deleted successfully"
                    }
                }
        }

        @Test
        @DirtiesContext
        fun `should return BAD Request`(){
            // given
            val deleteUser = "Invalid userId"
            val invalidUserId =  -1

            // when
            val performDelete = mockMvc.delete("${DELETE_USER}${invalidUserId}"){
                contentType = MediaType.TEXT_PLAIN
                content = objectMapper.writeValueAsString(deleteUser)
            }

            // then
            performDelete
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                    content {
                        "Invalid userId"
                    }
                }
        }


    }

}