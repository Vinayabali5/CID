package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.learning_support.ReferralReason

interface ReferralReasonRepository extends CrudRepository<ReferralReason, Integer> {
}
