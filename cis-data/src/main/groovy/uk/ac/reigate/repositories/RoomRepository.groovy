package uk.ac.reigate.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.Room

interface RoomRepository extends CrudRepository<Room, Integer> {
    
    Room findByCode(String code)
}
