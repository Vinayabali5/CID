package uk.ac.reigate.model.search



/**
 * The StudentSearchParams object is use to retrieve search parameters from the HTTP request params to 
 * be processed by the StudentSearchService.
 * 
 * @author Michael Horgan
 *
 */
class StudentSearchParams extends AcademicYearSearchParams {
    
    /**
     * The reference date to use for the search (default: null)
     */
    Date referenceDate = null
    
    /**
     * The name filter to use for searching (default: '%')
     */
    String name = '%'
    
    /**
     * The student type mask to use for searching (default: null)
     */
    String studentTypeMask = null
    
    /**
     * The tutor group mask to use for searching (default: null)
     */
    String tutorGroupMask = null
    
    /**
     * This property is used to include withdrawn student in the search results if required.  
     */
    Boolean includeWithdrawn = false
    
    /**
     * Default NoArgs constructor
     */
    StudentSearchParams() {}
    
    /**
     * This setter is used to set the referenceDate fields when the date fields is populated with a date string 
     * in the format of dd/MM/yyyy 
     * 
     * @param date a date string in to format of dd/MM/yyyy
     */
    void setDate(String date) {
        referenceDate = Date.parse('dd/MM/yyyy', date);
    }
    
    /**
     * This setter is an aliased method used to allow referenceDate to be entered using ref
     * 
     * @param date a date string in to format of dd/MM/yyyy
     */
    void setRef(String date) {
        this.setDate(date);
    }
    
    
    @Override
    public String toString() {
        return "StudentSearchParams [referenceDate=" + referenceDate + ", name=" + name + ", studentTypeMask=" + studentTypeMask + ", tutorGroupMask=" + tutorGroupMask + "]";
    }
}
