package uk.ac.reigate.mappers

import java.sql.ResultSet
import java.sql.SQLException

import org.springframework.jdbc.core.RowMapper

import uk.ac.reigate.model.attendance.OverallAttendance
import uk.ac.reigate.model.search.StudentSearchResult


class OverallAttendanceMapper implements RowMapper<OverallAttendance> {
    
    @Override
    public OverallAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OverallAttendance(
                rs.getFloat("overall_attendance"),
                rs.getFloat("overall_adjusted_attendance"),
                rs.getFloat("overall_punctuality")
                );
    }
}
