package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.PaymentReason

interface PaymentReasonRepository extends CrudRepository<PaymentReason, Integer> {
}
