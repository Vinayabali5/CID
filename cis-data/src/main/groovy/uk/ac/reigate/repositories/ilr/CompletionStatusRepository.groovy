package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.CompletionStatus;

interface CompletionStatusRepository extends CrudRepository<CompletionStatus, Integer> {
}
