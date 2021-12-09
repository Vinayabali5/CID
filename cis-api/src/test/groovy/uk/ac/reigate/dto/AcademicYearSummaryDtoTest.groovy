package uk.ac.reigate.dto;

import static org.junit.Assert.*
import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear

public class AcademicYearSummaryDtoTest {
    
    private AcademicYear academicYear1
    
    private AcademicYear academicYear2
    
    private List<AcademicYear> academicYears
    
    @Before
    public void setup() {
        this.academicYear1 = new AcademicYear(
                id: 1,
                code: '15/16',
                description: 'Academic Year 15/16'
                );
        this.academicYear2 = new AcademicYear(
                id: 2,
                code: '14/15',
                description: 'Academic Year 14/15'
                );
        this.academicYears = Arrays.asList(this.academicYear1, this.academicYear2);
    }
    
    @Test
    public void testMapFromAcademicYearsEntities(){
        List<AcademicYearSummaryDto> academicYearDtoList = AcademicYearSummaryDto.mapFromList( this.academicYears )
        assertEquals( academicYearDtoList[0].id, academicYear1.id);
        assertEquals( academicYearDtoList[0].code, academicYear1.code);
        assertEquals( academicYearDtoList[0].description, academicYear1.description);
        assertEquals( academicYearDtoList[1].id, academicYear2.id );
        assertEquals( academicYearDtoList[1].code, academicYear2.code );
        assertEquals( academicYearDtoList[1].description, academicYear2.description );
    }
}
