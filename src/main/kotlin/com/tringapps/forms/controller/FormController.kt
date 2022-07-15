package com.tringapps.forms.controller

import com.tringapps.forms.model.Form
import com.tringapps.forms.service.FormService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 04/07/22
 **/

@RestController
@RequestMapping("api/form")
class FormController(val service: FormService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @PostMapping("/createForm")
    fun createForm(@RequestBody form:Form):String = service.createForm(form)

    @PostMapping("/updateForm")
    fun updateForm(@RequestBody form:Form):String = service.updateForm(form)

    @PostMapping("/deleteForm")
    fun deleteForm(@RequestBody formId:Int):String = service.deleteForm(formId)

    @PostMapping("/assignForm")
    fun assignForm(@RequestBody users:List<Int>,formId: Int):String = service.assignForm(users,formId)

    @GetMapping("/getAllForms")
    fun getAllForms():Collection<Form> = service.getAllForms()

    @PostMapping("/getUserForms")
    fun getAllUserForms(@RequestBody userId:Int):Collection<Form> = service.getAllUserForms(userId)

    @PostMapping("/removeUserForm")
    fun removeUserForm(@RequestBody userId:Int,formId:Int):String = service.removeUserForm(userId,formId)
}