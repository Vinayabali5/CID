package uk.ac.reigate.mappers

import java.sql.ResultSet
import java.sql.SQLException

import org.springframework.jdbc.core.RowMapper

import uk.ac.reigate.model.search.StudentSearchResult;


class StudentSearchResultMapper implements RowMapper<StudentSearchResult> {
    
    @Override
    public StudentSearchResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StudentSearchResult(rs.getInt("student_id"), rs.getString("DisplayText"));
    }
}
