package uk.ac.reigate.repositories.ilp

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilp.StatementBank


interface StatementBankRepository extends CrudRepository<StatementBank, Integer> {
    
    List<StatementBank> findByInUseTrue()
    
    List<StatementBank> findByInUseTrueAndStatementBankTypeId(Integer iLPStatementBankTypeId)
    
    List<StatementBank> findByUseForMassLettersTrueAndInUseTrue()
    
    List<StatementBank> findByUseForPraiseEmailTrueAndInUseTrue()
}
