package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.Request

public class RequestDtoTest {
    
    private Request request1
    
    private Request request2
    
    private Request request3
    
    private List<Request> requests
    
    @Before
    public void setup() {
        request1 = new Request(
                id: 1,
                student: new Student(id:19001),
                academicYear: new AcademicYear(id:1, code: '18'),
                request:'Conditional',
                coreAim: false,
                broadeningSubject: true,
                chosenAgainstAdvice: false,
                allocated: true
                );
        request2 = new Request(
                id: 2,
                student: new Student(id:19001),
                academicYear: new AcademicYear(id:1),
                request:'Normal',
                coreAim: false,
                broadeningSubject: true,
                chosenAgainstAdvice: false,
                allocated: true
                );
        request3 = new Request(
                id: 3,
                student: null,
                academicYear: null,
                request:'Normal',
                coreAim: false,
                broadeningSubject: true,
                chosenAgainstAdvice: false,
                allocated: true
                );
        requests = Arrays.asList(request1, request2);
    }
    
    @Test
    public void testConstructor_Request(){
        Request request = null
        RequestDto requestTest = new RequestDto( request )
        assertEquals( request, null );
    }
    
    @Test
    public void testConstructor_NullStudent(){
        RequestDto requestTest = new RequestDto( request3 )
        assertEquals( requestTest.id, request3.id );
        assertEquals( requestTest.studentId, request3.student);
        assertEquals( requestTest.academicYearId, null);
        assertEquals( requestTest.request, request3.request);
        assertEquals( requestTest.coreAim, request3.coreAim);
        assertEquals( requestTest.broadeningSubject, request3.broadeningSubject);
        assertEquals( requestTest.chosenAgainstAdvice, request3.chosenAgainstAdvice);
        assertEquals( requestTest.allocated, request3.allocated);
    }
    
    @Test
    public void testMapFromRequestEntity(){
        RequestDto requestTest = RequestDto.mapFromEntity( request1 )
        assertEquals( requestTest.id, request1.id );
        assertEquals( requestTest.studentId, request1.student.id);
        assertEquals( requestTest.request, request1.request);
        assertEquals( requestTest.coreAim, request1.coreAim);
        assertEquals( requestTest.broadeningSubject, request1.broadeningSubject);
        assertEquals( requestTest.chosenAgainstAdvice, request1.chosenAgainstAdvice);
        assertEquals( requestTest.allocated, request1.allocated);
    }
    
    @Test
    public void testMapFromRequestsEntities(){
        List<RequestDto> requestsDtoTest = RequestDto.mapFromList( requests )
        assertEquals( requestsDtoTest[0].id, request1.id );
        assertEquals( requestsDtoTest[0].studentId, request1.student.id);
        assertEquals( requestsDtoTest[0].request, request1.request);
        assertEquals( requestsDtoTest[1].id, request2.id );
        assertEquals( requestsDtoTest[1].studentId, request2.student.id);
        assertEquals( requestsDtoTest[1].request, request2.request);
    }
    
    @Test
    public void testEquals_Same() {
        RequestDto requestDto1 = new RequestDto(request1);
        RequestDto requestDto2 = new RequestDto(request1);
        assertEquals(requestDto1, requestDto2)
    }
    
    @Test
    public void testEquals_Different() {
        RequestDto requestDto1 = new RequestDto(request1);
        RequestDto requestDto2 = new RequestDto(request2);
        assertNotEquals(requestDto1, requestDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        RequestDto requestDto1 = new RequestDto(request1);
        RequestDto requestDto2 = new RequestDto(request1);
        assertEquals(requestDto1.hashCode(), requestDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        RequestDto requestDto1 = new RequestDto(request1);
        RequestDto requestDto2 = new RequestDto(request2);
        assertNotEquals(requestDto1.hashCode(), requestDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullAcademicYearCode() {
        RequestDto requestDto1 = new RequestDto(request3);
        assertEquals(requestDto1.academicYear, requestDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_AcademicYearCode() {
        RequestDto requestDto1 = new RequestDto(request1);
        assertEquals(requestDto1.academicYear.code, requestDto1.get_AcademicYearCode())
    }
}
