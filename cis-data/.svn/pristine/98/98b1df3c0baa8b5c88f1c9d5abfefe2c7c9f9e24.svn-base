package uk.ac.reigate.repositories.exams.edi

import java.sql.ResultSet
import java.sql.SQLException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcCall
import org.springframework.stereotype.Repository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.domain.exams.edi.StatusType

@Repository
public class EdiDataRepository {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EdiDataRepository.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    EdiDataRepository() {}
    
    /**
     * createStudentOptionEntry - Calls SQL procedure Exams.CreateStudentoptionEntries
     * 
     * returns List<StudentOptionEntry> containing all the student option entries created
     */
    public List<StudentOptionEntry> createStudentOptionEntry() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("Exams")
                .withProcedureName("CreateStudentOptionEntries")
                .returningResultSet("items", new RowMapper<StudentOptionEntry>() {
                    @Override
                    public StudentOptionEntry mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        StudentOptionEntry studentOptionEntry = new StudentOptionEntry();
                        studentOptionEntry.student = new Student();
                        studentOptionEntry.student.id = rs.getInt(1);
                        studentOptionEntry.examOption = new ExamOption();
                        studentOptionEntry.examOption.examOptionId = rs.getInt(2);
                        studentOptionEntry.statusType = new StatusType();
                        studentOptionEntry.statusType.id = rs.getInt(3);
                        studentOptionEntry.ediStatusType = new EdiStatusType();
                        studentOptionEntry.ediStatusType.id = rs.getInt(4);
                        studentOptionEntry.resit = rs.getBoolean(5);
                        studentOptionEntry.privateStudent = rs.getBoolean(6);
                        return studentOptionEntry;
                    }
                });
        Map<StudentOptionEntry, Object> out = simpleJdbcCall.execute();
        List<StudentOptionEntry> toReturn = out.get("items");
        return toReturn;
    }
    
    /**
     * getCreateEdiFileData - Calls SQL procedure Exams.CreateEdiFileData	
     * 
     * @param year
     * @param series
     * @param examBoardId
     * @return List<String> 
     * 		first element contains the name of the edi file to create
     * 		remaining elements contain the data to be written to the edi file 
     */
    public List<String> getCreateEdiFileData(String year, String series, Integer examBoardId) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("Exams")
                .withProcedureName("CreateEdiFileData")
                .returningResultSet("items", new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        String out = rs.getString(1);
                        return out;
                    }
                });
        SqlParameterSource functionParameters = new MapSqlParameterSource()
                .addValue("year", year)
                .addValue("series", series)
                .addValue("exam_board_id", examBoardId);
        Map<String, Object> out = simpleJdbcCall.execute(functionParameters);
        List<String> ediFileData = out.get("items");
        return ediFileData;
    }
    
    /**
     * setEdiStatusToSubmitted - Calls SQL procedure Exams.SetEdiStatusToSubmitted
     * 	
     * @param year
     * @param series
     * @param examBoardId
     */
    public void setEdiStatusToSubmitted(String year, String series, Integer examBoardId) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("Exams")
                .withProcedureName("SetEdiStatusToSubmitted");
        SqlParameterSource functionParameters = new MapSqlParameterSource()
                .addValue("year", year)
                .addValue("series", series)
                .addValue("exam_board_id", examBoardId);
        simpleJdbcCall.execute(functionParameters);
    }
}
