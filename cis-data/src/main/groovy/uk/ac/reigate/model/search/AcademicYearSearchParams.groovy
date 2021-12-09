package uk.ac.reigate.model.search

class AcademicYearSearchParams {
    
    /**
     * The id of the AcademicYear to use for the search. The yearId is used over the
     * yearCode if both are provided.
     */
    Integer yearId
    
    /**
     * The code representation of the AcademicYear to use for the search. The yearId is
     * used over the yearCode if both are provided.
     */
    String yearCode
    
    /**
     * This method is used to process the parameter year into either the yearId or yearCode
     *
     * @param year a year string to be processed
     */
    void setYear(String year) {
        try {
            yearId = Integer.valueOf(year)
        } catch (NumberFormatException nfe ) {
            yearCode = year
        }
    }
    
    @Override
    public String toString() {
        return "AcademicYearSearchParams [yearId=" + yearId + ", yearCode=" + yearCode + "]";
    }
}
