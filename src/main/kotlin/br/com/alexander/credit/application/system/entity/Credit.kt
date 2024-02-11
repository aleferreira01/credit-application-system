package br.com.alexander.credit.application.system.entity

import br.com.alexander.credit.application.system.enumerations.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
//@Table(name = "Credit")
data class Credit (
    @Column(nullable = false) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null

)