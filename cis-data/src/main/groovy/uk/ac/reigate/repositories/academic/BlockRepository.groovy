package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Block

interface BlockRepository extends CrudRepository<Block, Integer> {
    Block findByCode(String code)
}
