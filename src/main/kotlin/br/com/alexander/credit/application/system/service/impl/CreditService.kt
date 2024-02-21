package br.com.alexander.credit.application.system.service.impl

import br.com.alexander.credit.application.system.entity.Credit
import br.com.alexander.credit.application.system.exception.BusinessException
import br.com.alexander.credit.application.system.repository.CreditRepository
import br.com.alexander.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService,
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return if (checkCreditRequest(credit)) this.creditRepository.save(credit)
        else throw IllegalArgumentException("Invalid credit application requirements")
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomer(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Creditcode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
    }

    private fun checkCreditRequest(credit: Credit): Boolean {
        return credit.numberOfInstallments <= 48 &&
                LocalDate.now().until(credit.dayFirstOfInstallment, ChronoUnit.MONTHS) <= 3
    }
}
