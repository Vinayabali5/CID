package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.InsetCourse

interface InsetCourseRepository extends CrudRepository<InsetCourse, Integer> {
}
