package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear

interface AcademicYearRepository extends CrudRepository<AcademicYear, Integer> {
    
    AcademicYear findByCode(String code)
    
    @Query(value="SELECT * FROM [dbo].[academic_year] AS [ay] WHERE [ay].[academic_year_id] = [Data].[GetCurrentAcademicYearId]()", nativeQuery = true)
    AcademicYear findCurrent()
    
    @Query(value="SELECT * FROM [dbo].[academic_year] AS [ay] WHERE [ay].[academic_year_id] = [Data].[GetNextAcademicYearId]()", nativeQuery = true)
    AcademicYear findNext()
    
    @Query(value="SELECT * FROM [dbo].[academic_year] AS [ay] WHERE [ay].[academic_year_id] = [Data].[GetPreviousAcademicYearId]()", nativeQuery = true)
    AcademicYear findPrevious()
    
    @Query(value="SELECT * FROM [dbo].[academic_year] AS [ay] WHERE :date BETWEEN [ay].[start_date] AND [ay].[end_date]", nativeQuery = true)
    AcademicYear findByDate(@Param(value = "date") Date date)
}
