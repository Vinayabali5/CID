package uk.ac.reigate.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.RoomType

interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {
}
