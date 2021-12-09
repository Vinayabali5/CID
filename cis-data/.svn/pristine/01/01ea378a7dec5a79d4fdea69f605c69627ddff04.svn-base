package uk.ac.reigate.model.allocation

class WorkingCombinationOption {
    
    /**
     * The courseGroupId for the course group 
     */
    Integer courseGroupId
    
    /**
     * The course spec for the course group
     */
    String spec
    
    /**
     * The number of students that are currently enrolled on the course group 
     */
    Integer currentStudents
    
    /**
     * The allocation weighting for the course group
     */
    Integer weighting
    
    /**
     * Default NoArgs constructor
     */
    WorkingCombinationOption() {}
    
    /**
     * Fields based constructor used to create a WorkingCombinationOption with the individual fields.
     * 
     * @param courseGroupId the course group Id
     * @param spec the course spec
     * @param currentStudents the number of current students
     * @param weighting the allocation weighting
     */
    WorkingCombinationOption(Integer courseGroupId, String spec, Integer currentStudents, Integer weighting){
        this.courseGroupId = courseGroupId
        this.spec = spec
        this.currentStudents = currentStudents
        this.weighting = weighting
    }
    
    /**
     * Spec based constructor used to create a WorkingCombinationOption with the course group spec
     * 
     * @param spec the course group spec
     */
    WorkingCombinationOption(String spec){
        this.spec = spec
    }
}
