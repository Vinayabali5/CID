package uk.ac.reigate.repositories.exams.basedata

import javax.transaction.Transactional

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.OptionComponentPk


@Transactional
public interface OptionComponentRepository extends CrudRepository<OptionComponent, OptionComponentPk> {
}
