package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.EntryQualificationType


interface EntryQualificationTypeRepository extends CrudRepository<EntryQualificationType, Integer> {
}
