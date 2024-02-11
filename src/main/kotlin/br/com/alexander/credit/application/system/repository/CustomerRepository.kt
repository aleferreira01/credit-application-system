package br.com.alexander.credit.application.system.repository

import br.com.alexander.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long>