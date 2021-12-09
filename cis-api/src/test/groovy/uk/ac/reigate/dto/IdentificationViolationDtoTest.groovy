package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.IdentificationViolation
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.exceptions.InvalidDataException

public class IdentificationViolationDtoTest {
    
    private IdentificationViolation identificationViolation1
    
    private IdentificationViolation identificationViolation2
    
    private IdentificationViolation identificationViolation3
    
    private List<IdentificationViolation> identificationViolations
    
    @Before
    public void setup() {
        this.identificationViolation1 = new IdentificationViolation(
                id: 1,
                student: new Student(id: 190001),
                year: new AcademicYear(id: 18),
                date : null,
                returned: true,
                lost: false,
                printed: true,
                replacementPaidFor: true,
                id_number: 1
                );
        this.identificationViolation2 = new IdentificationViolation(
                id: 2,
                student: new Student(id: 190002),
                year: new AcademicYear(id: 18),
                date : null,
                returned: true,
                lost: false,
                printed: true,
                replacementPaidFor: true,
                id_number: 2
                );
        this.identificationViolation3 = new IdentificationViolation(
                id: 2,
                student: null,
                year: null,
                date : null,
                returned: true,
                lost: false,
                printed: true,
                replacementPaidFor: true,
                id_number: 2
                );
        this.identificationViolations = Arrays.asList(this.identificationViolation1, this.identificationViolation2);
    }
    
    @Test
    public void testConstructor_NullIdentificationViolation() {
        IdentificationViolation identificationViolation = null
        IdentificationViolationDto identificationViolationDto = new IdentificationViolationDto(identificationViolation)
        assertEquals( identificationViolation, null );
    }
    
    @Test
    void testConstructor_Nullyear() {
        IdentificationViolationDto identificationViolationTest = new IdentificationViolationDto( identificationViolation3 )
        assertEquals( identificationViolationTest.id, identificationViolation3.id );
        assertEquals( identificationViolationTest.studentId,  identificationViolation3.student );
        assertEquals( identificationViolationTest.yearId,  identificationViolation3.year );
        assertEquals( identificationViolationTest.returned, identificationViolation3.returned);
        assertEquals( identificationViolationTest.printed, identificationViolation3.printed);
    }
    
    @Test
    void testConstructor_identificationViolation() {
        IdentificationViolationDto identificationViolationTest = new IdentificationViolationDto( identificationViolation1 )
        assertEquals( identificationViolationTest.id, identificationViolation1.id );
        assertEquals( identificationViolationTest.returned, identificationViolation1.returned);
        assertEquals( identificationViolationTest.printed, identificationViolation1.printed);
    }
    
    @Test
    public void testMapFromIdentificationViolationEntity(){
        IdentificationViolationDto identificationViolationTest = IdentificationViolationDto.mapFromEntity( identificationViolation1 )
        assertEquals( identificationViolationTest.id, identificationViolation1.id );
        assertEquals( identificationViolationTest.returned, identificationViolation1.returned);
        assertEquals( identificationViolationTest.printed, identificationViolation1.printed);
    }
    
    @Test
    public void testMapFromIdentificationViolationsEntities(){
        List<IdentificationViolationDto> identificationViolationsTest = IdentificationViolationDto.mapFromEntities( this.identificationViolations )
        assertEquals( identificationViolationsTest[0].id, identificationViolation1.id );
        assertEquals( identificationViolationsTest[0].returned, identificationViolation1.returned );
        assertEquals( identificationViolationsTest[0].printed, identificationViolation1.printed);
        assertEquals( identificationViolationsTest[1].id, identificationViolation2.id );
        assertEquals( identificationViolationsTest[1].returned, identificationViolation2.returned );
        assertEquals( identificationViolationsTest[1].printed, identificationViolation2.printed);
    }
    
    @Test
    public void testEquals_Same() {
        IdentificationViolationDto identificationViolationDto1 = new IdentificationViolationDto(identificationViolation1)
        IdentificationViolationDto identificationViolationDto2 = new IdentificationViolationDto(identificationViolation1)
        assertEquals( identificationViolationDto1, identificationViolationDto2)
    }
    
    @Test
    public void testEquals_Different() {
        IdentificationViolationDto identificationViolationDto1 = new IdentificationViolationDto(identificationViolation1)
        IdentificationViolationDto identificationViolationDto2 = new IdentificationViolationDto(identificationViolation2)
        assertNotEquals( identificationViolationDto1, identificationViolationDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        IdentificationViolationDto identificationViolationDto1 = new IdentificationViolationDto(identificationViolation1)
        IdentificationViolationDto identificationViolationDto2 = new IdentificationViolationDto(identificationViolation1)
        assertEquals( identificationViolationDto1.hashCode(), identificationViolationDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        IdentificationViolationDto identificationViolationDto1 = new IdentificationViolationDto(identificationViolation1)
        IdentificationViolationDto identificationViolationDto2 = new IdentificationViolationDto(identificationViolation2)
        assertNotEquals( identificationViolationDto1.hashCode(), identificationViolationDto2.hashCode())
    }
}
