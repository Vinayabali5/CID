package uk.ac.reigate.dto.interimreport

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.interimreport.CourseGroupInterimReport
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.CourseGroupDto

class CourseGroupInterimReportDtoTest {
    
    private CourseGroupInterimReport courseGroupInterimReport1
    
    private CourseGroupInterimReport courseGroupInterimReport2
    
    private List<CourseGroupInterimReport> courseGroupInterimReports
    
    @Before
    public void setup() {
        courseGroupInterimReport1 = new CourseGroupInterimReport(
                courseGroup : new CourseGroup(id: 1),
                interimReport : new InterimReport(id: 1),
                staffCompleted : new Staff(id: 1),
                complete : true
                );
        courseGroupInterimReport2 = new CourseGroupInterimReport(
                courseGroup : new CourseGroup(id: 1),
                interimReport : new InterimReport(id: 1),
                staffCompleted : null,
                complete : true
                );
        courseGroupInterimReports = Arrays.asList(courseGroupInterimReport1, courseGroupInterimReport2)
    }
    
    @Test
    public void testMapFromEntity() {
        CourseGroupInterimReportDto courseGroupInterimReportDto = CourseGroupInterimReportDto.mapFromEntity(courseGroupInterimReport1)
        assertEquals( courseGroupInterimReportDto.courseGroupId, courseGroupInterimReport1.courseGroup.id );
        assertEquals( courseGroupInterimReportDto.interimReportId, courseGroupInterimReport1.interimReport.id );
        assertEquals( courseGroupInterimReportDto.staffCompletedId, courseGroupInterimReport1.staffCompleted.id );
        assertEquals( courseGroupInterimReportDto.complete, courseGroupInterimReport1.complete );
    }
    
    @Test
    public void testMapFromList() {
        List<CourseGroupInterimReportDto> courseGroupInterimReportDto = CourseGroupInterimReportDto.mapFromList(courseGroupInterimReports)
        assertEquals( courseGroupInterimReportDto[0].courseGroupId, courseGroupInterimReport1.courseGroup.id );
        assertEquals( courseGroupInterimReportDto[0].interimReportId, courseGroupInterimReport1.interimReport.id );
        assertEquals( courseGroupInterimReportDto[0].staffCompletedId, courseGroupInterimReport1.staffCompleted.id );
        assertEquals( courseGroupInterimReportDto[0].complete, courseGroupInterimReport1.complete );
        assertEquals( courseGroupInterimReportDto[1].courseGroupId, courseGroupInterimReport2.courseGroup.id );
        assertEquals( courseGroupInterimReportDto[1].interimReportId, courseGroupInterimReport2.interimReport.id );
        assertEquals( courseGroupInterimReportDto[1].staffCompletedId, courseGroupInterimReport2.staffCompleted );
        assertEquals( courseGroupInterimReportDto[1].complete, courseGroupInterimReport2.complete );
    }
    
    @Test
    public void testConstrutor() {
        CourseGroupInterimReportDto courseGroupInterimReportDto = new CourseGroupInterimReportDto(courseGroupInterimReport1)
        assertEquals( courseGroupInterimReportDto.courseGroupId, courseGroupInterimReport1.courseGroup.id );
        assertEquals( courseGroupInterimReportDto.interimReportId, courseGroupInterimReport1.interimReport.id );
        assertEquals( courseGroupInterimReportDto.staffCompletedId, courseGroupInterimReport1.staffCompleted.id );
        assertEquals( courseGroupInterimReportDto.complete, courseGroupInterimReport1.complete );
    }
    
    @Test
    public void testConstrutorNullStaff() {
        CourseGroupInterimReportDto courseGroupInterimReportDto = new CourseGroupInterimReportDto(courseGroupInterimReport2)
        assertEquals( courseGroupInterimReportDto.courseGroupId, courseGroupInterimReport2.courseGroup.id );
        assertEquals( courseGroupInterimReportDto.interimReportId, courseGroupInterimReport2.interimReport.id );
        assertEquals( courseGroupInterimReportDto.staffCompletedId, courseGroupInterimReport2.staffCompleted );
        assertEquals( courseGroupInterimReportDto.complete, courseGroupInterimReport2.complete );
    }
}
