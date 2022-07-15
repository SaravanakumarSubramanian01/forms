package com.tringapps.forms.model


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 04/07/22
 **/
data class Form(val formId:Int, val createdOn: String, val modifiedOn: String, val createdBy:String,
                val formTitle:String, val formDescription:String, val formData: Any)
