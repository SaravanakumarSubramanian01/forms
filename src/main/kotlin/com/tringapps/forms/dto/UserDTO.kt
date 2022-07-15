package com.tringapps.forms.dto

import com.tringapps.forms.model.Role


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 07/07/22
 **/
data class UserDTO(
    var userId:Int,
    var firstName:String,
    var lastName:String,
    var emailId:String,
    var password:String,
    var role: Role
)
