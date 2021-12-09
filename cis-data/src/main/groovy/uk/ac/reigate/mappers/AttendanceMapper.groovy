package uk.ac.reigate.mappers

import java.sql.ResultSet
import java.sql.SQLException

import org.springframework.jdbc.core.RowMapper

import uk.ac.reigate.model.attendance.AttendanceRange


class AttendanceMapper implements RowMapper<AttendanceRange> {
    
    @Override
    public AttendanceRange mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AttendanceRange(
                attendance: rs.getFloat("attendance"),
                adjuestedAttendance: rs.getFloat("adjusted_attendance"),
                punctuality: rs.getFloat("punctuality")
                );
    }
}
