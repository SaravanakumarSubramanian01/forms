package com.tringapps.forms.database.mock

import com.tringapps.forms.database.FormDataSource
import com.tringapps.forms.model.Form
import com.tringapps.forms.model.Role
import com.tringapps.forms.model.User
import org.springframework.stereotype.Repository


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 06/07/22
 **/

@Repository
class MockFormDataSource: FormDataSource{

    val forms = mutableListOf<Form>()

    override fun createForm(form: Form): String {
        if(forms.any{ it.formId == form.formId}){
            throw IllegalArgumentException("Form not created" )
        }
        forms.add(form)
        return "Form created successfully"
    }

    override fun updateForm(form: Form): String {
        val currentForm = forms.firstOrNull {it.formId == form.formId }
            ?:throw NoSuchElementException("Form not found")
        forms.remove(currentForm)
        forms.add(form)

        return "Form updated successfully"
    }

    override fun deleteForm(formId: Int): String {
        val currentForm = forms.firstOrNull {it.formId == formId }
            ?:throw NoSuchElementException("Form not found")
        forms.remove(currentForm)

        return "Form deleted successfully"
    }

    override fun assignForm(users: List<Int>, formId: Int): String {
        TODO("Not yet implemented")
    }

    override fun getAllForms(): Collection<Form> = forms

    override fun getAllUserForms(): Collection<Form> {
        TODO("Not yet implemented")
    }

    override fun removeUserForm(userId: Int, formId: Int): String {
        TODO("Not yet implemented")
    }
}