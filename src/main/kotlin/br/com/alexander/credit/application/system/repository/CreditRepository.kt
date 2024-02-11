package br.com.alexander.credit.application.system.repository

import br.com.alexander.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository: JpaRepository<Credit, Long>