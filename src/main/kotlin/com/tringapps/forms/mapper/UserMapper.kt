package com.tringapps.forms.mapper

import com.tringapps.forms.dto.UserDTO
import com.tringapps.forms.model.User


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 07/07/22
 **/
class UserMapper:Mapper<UserDTO,User> {
    override fun fromEntity(entity: User): UserDTO {
        return UserDTO(
            entity.userId,
            entity.firstName,
            entity.lastName,
            entity.emailId,
            entity.password,
            entity.role
        )
    }

    override fun toEntity(domain: UserDTO): User {
        return User(
            domain.userId,
            domain.firstName,
            domain.lastName,
            domain.emailId,
            domain.password,
            domain.role
        )
    }
}