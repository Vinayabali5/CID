package uk.ac.reigate.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.NoteType;

interface NoteTypeRepository extends CrudRepository<NoteType, Integer> {
    
    NoteType findByCode(String code)
}
