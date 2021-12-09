package uk.ac.reigate.model.search

import java.util.Date;

class CourseGroupSearchParams extends AcademicYearSearchParams {
    
    /**
     * The reference date to use for the search
     */
    Date referenceDate = new Date()
    
    /**
     * The course group mask to use for searching (default: '%')
     */
    String courseGroupMask = '%'
}
