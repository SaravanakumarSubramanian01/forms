package com.tringapps.forms.database

import com.tringapps.forms.model.Form


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 04/07/22
 **/
interface FormDataSource {

    fun createForm(form: Form):String
    fun updateForm(form: Form):String
    fun deleteForm(formId: Int):String
    fun assignForm(users:List<Int>,formId:Int):String
    fun getAllForms():Collection<Form>
    fun getAllUserForms():Collection<Form>
    fun removeUserForm(userId:Int,formId: Int):String
}