package com.tringapps.forms.mapper


/**
 * @Author: Saravanakumar Subramanian
 * @Organization: Tringapps research labs pvt ltd
 * @Date: 07/07/22
 **/
interface Mapper<D,E> {
    fun fromEntity(entity: E):D
    fun toEntity(domain: D):E
}