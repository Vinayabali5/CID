package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.admissions.CollegeFundPaid


interface CollegeFundPaidRepository extends CrudRepository<CollegeFundPaid, Integer>{
}
