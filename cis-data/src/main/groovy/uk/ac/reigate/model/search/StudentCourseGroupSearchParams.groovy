package uk.ac.reigate.model.search

/**
 * The StudentCourseGroupSearchParams is used to collection the HTTP request params 
 * to be processed by the StudentCourseGroupSearchService.
 *  
 * @author Michael Horgan
 *
 */
class StudentCourseGroupSearchParams extends StudentSearchParams {
    
    /**
     * The course group mask to use for searching (default: '%')
     */
    String courseGroupMask = '%'
    
    /**
     * Default NoArgs constructor
     */
    StudentCourseGroupSearchParams() {}
    
    @Override
    public String toString() {
        return "StudentCourseGroupSearchParams [courseGroupMask=" + courseGroupMask + "]";
    }
}
