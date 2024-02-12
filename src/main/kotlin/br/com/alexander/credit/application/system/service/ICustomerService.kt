package br.com.alexander.credit.application.system.service

import br.com.alexander.credit.application.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)

}