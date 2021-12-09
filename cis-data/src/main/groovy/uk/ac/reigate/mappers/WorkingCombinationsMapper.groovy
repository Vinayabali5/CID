package uk.ac.reigate.mappers

import java.sql.ResultSet
import java.sql.SQLException

import org.springframework.jdbc.core.RowMapper

import uk.ac.reigate.model.allocation.WorkingCombination
import uk.ac.reigate.model.allocation.WorkingCombinationOption

class WorkingCombinationsMapper implements RowMapper<WorkingCombination> {
    
    private final static MAX_REQUESTS = 12;
    
    @Override
    public WorkingCombination mapRow(ResultSet rs, int rowNum) throws SQLException {
        WorkingCombination wc = new WorkingCombination();
        
        for (int i = 1; i <= this.MAX_REQUESTS; i++) {
            String spec = null
            Integer courseGroupId = null
            Integer currentStudents = null
            try {
                if (rs.findColumn("Class$i")) {
                    spec = rs.getString("Class$i")
                };
            } catch (SQLException ex) {
                /* Field not found */
            }
            try {
                if (rs.findColumn("Class$i-CourseGroupId")) {
                    courseGroupId = rs.getInt("Class$i-CourseGroupId")
                };
            } catch (SQLException ex) {
                /* Field not found */
            }
            try {
                if (rs.findColumn("Class$i-CurrentStudents")) {
                    currentStudents = rs.getInt("Class$i-CurrentStudents")
                };
            } catch (SQLException ex) {
                /* Field not found */
            }
            if (spec != null) {
                wc.addCourseGroup(new WorkingCombinationOption(courseGroupId, spec, currentStudents, null))
            }
        }
        
        return wc;
    }
}
