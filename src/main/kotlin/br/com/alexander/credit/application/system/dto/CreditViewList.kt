package br.com.alexander.credit.application.system.dto

import br.com.alexander.credit.application.system.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList (
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int
) {
    constructor(credit: Credit) : this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}
