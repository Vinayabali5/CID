package uk.ac.reigate.repositories.exams.edi


import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog

interface EdiAuditFileLogRepository extends CrudRepository<EdiAuditFileLog, Integer> {
}
