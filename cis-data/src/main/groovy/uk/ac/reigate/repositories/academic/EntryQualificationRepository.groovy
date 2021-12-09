package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.EntryQualification


interface EntryQualificationRepository extends CrudRepository<EntryQualification, Integer> {
}
