package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.admissions.Request

interface RequestRepository extends CrudRepository<Request, Integer>{
    
    List<Request> findByStudent_Id(Integer id)
    
    Request findByStudent_IdAndRequest(Integer id, String request)
    
    Request findByStudent_IdAndRequestAndAcademicYear(Integer id,String request, AcademicYear academicYear)
    
    List <Request> findByAcademicYear(AcademicYear academicYear);
    
    List <Request> findByStudent_IdAndAcademicYear_Id(Integer studentId,Integer AcademicYearId)
    
    List <Request>  findByAcademicYear_IdAndStudent_Id(@Param(value = "academicYearId") Integer academicYearId, @Param(value = "studentId") Integer studentId)
}
