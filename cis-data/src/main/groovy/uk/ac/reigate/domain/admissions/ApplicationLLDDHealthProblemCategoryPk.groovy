package uk.ac.reigate.domain.admissions

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory


@Embeddable
class ApplicationLLDDHealthProblemCategoryPk implements Serializable {
    
    @OneToOne
    @JoinColumn(name="student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name="lldd_health_problem_category_id")
    LLDDHealthProblemCategory llddHealthProblemCategory
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((student == null) ? 0 : student.hashCode());
        result = prime * result + ((llddHealthProblemCategory == null) ? 0 : llddHealthProblemCategory.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApplicationLLDDHealthProblemCategoryPk other = (ApplicationLLDDHealthProblemCategoryPk) obj;
        if (student == null) {
            if (other.student != null)
                return false;
        } else if (!student.equals(other.student))
            return false;
        if (llddHealthProblemCategory == null) {
            if (other.llddHealthProblemCategory != null)
                return false;
        } else if (!llddHealthProblemCategory.equals(other.llddHealthProblemCategory))
            return false;
        return true;
    }
}

