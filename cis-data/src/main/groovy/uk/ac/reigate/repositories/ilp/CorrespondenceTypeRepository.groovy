package uk.ac.reigate.repositories.ilp

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilp.CorrespondenceType


interface CorrespondenceTypeRepository extends CrudRepository<CorrespondenceType, Integer> {
}
