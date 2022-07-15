package com.tringapps.forms.service

import com.tringapps.forms.database.FormDataSource
import com.tringapps.forms.model.Form
import org.springframework.stereotype.Service


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 04/07/22
 **/

@Service
class FormService(val dataSource: FormDataSource) {
    fun createForm(form:Form):String = dataSource.createForm(form)
    fun updateForm(form:Form):String = dataSource.updateForm(form)
    fun deleteForm(formId:Int):String = dataSource.deleteForm(formId)
    fun assignForm(users:List<Int>,formId: Int):String = dataSource.assignForm(users,formId)
    fun getAllForms():Collection<Form> = dataSource.getAllForms()
    fun getAllUserForms(userId:Int):Collection<Form> = dataSource.getAllUserForms()
    fun removeUserForm(userId:Int,formId:Int):String = dataSource.removeUserForm(userId,formId)
}