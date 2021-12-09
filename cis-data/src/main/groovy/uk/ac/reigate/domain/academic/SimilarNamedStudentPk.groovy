package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includeFields=true)
class SimilarNamedStudentPk implements Serializable {
    
    Integer student
    
    Integer academicYear
    
    SimilarNamedStudentPk() {}
    
    SimilarNamedStudentPk(Integer student, Integer academicYear){
        this.student = student
        this.academicYear = academicYear
    }
    
    SimilarNamedStudentPk(Student student, AcademicYear academicYear){
        this.student = student.id
        this.academicYear = academicYear.id
    }
    
    SimilarNamedStudentPk(SimilarNamedStudent similarNamedStudent){
        this.student = similarNamedStudent.student.id
        this.academicYear = similarNamedStudent.academicYear.id
    }
}
