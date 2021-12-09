package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.domain.exams.edi.StatusType

public class StudentOptionEntryDtoTest {
    
    private StudentOptionEntry studentOptionEntry1
    
    private StudentOptionEntry studentOptionEntry2
    
    private StudentOptionEntry studentOptionEntry3
    
    private List<StudentOptionEntry> studentOptionEntries
    
    private Student student
    
    private ExamOption examOption
    
    private StatusType statusType
    
    private EdiStatusType ediStatusType
    
    @Before
    public void setup() {
        this.studentOptionEntry1 = new StudentOptionEntry(
                student : new Student(id: 1),
                examOption : new ExamOption(id: 2, optionEntryCode: 'Test', optionTitle: 'GCSE Maths', syllabus: new Syllabus(id:1, examSeries: new ExamSeries(id: 1, examBoard: new ExamBoard(id: 1)))),
                statusType : new StatusType(id: 1, description: 'Active'),
                ediStatusType : new EdiStatusType(id: 1, description: 'Test'),
                resit :true,
                privateStudent : true
                );
        this.studentOptionEntry2 = new StudentOptionEntry(
                student : new Student(id: 2),
                examOption : new ExamOption(id: 2, optionEntryCode: 'Test', optionTitle: 'GCSE Maths', syllabus: new Syllabus(id:1, examSeries: new ExamSeries(id: 1, examBoard: new ExamBoard(id: 1)))),
                statusType : new StatusType(id: 1, description: 'Active'),
                ediStatusType : new EdiStatusType(id: 2),
                resit :true,
                privateStudent : true
                );
        this.studentOptionEntry3 = new StudentOptionEntry(
                student : new Student(id: 2),
                examOption : new ExamOption(id: 2, optionEntryCode: 'Test', optionTitle: 'GCSE Maths', syllabus: new Syllabus(id:1)),
                statusType : null,
                ediStatusType : null,
                resit :true,
                privateStudent : true
                );
        
        this.studentOptionEntries = Arrays.asList(this.studentOptionEntry1, this.studentOptionEntry2);
    }
    
    @Test
    void testconstructor_studentOptionEntryDto() {
        StudentOptionEntryDto studentOptionEntryDto = new StudentOptionEntryDto(studentOptionEntry1)
        assertEquals( studentOptionEntryDto.studentId, studentOptionEntry1.student.id)
        assertEquals( studentOptionEntryDto.examOptionId, studentOptionEntry1.examOption.id)
        assertEquals( studentOptionEntryDto.statusTypeId, studentOptionEntry1.statusType.id);
        assertEquals( studentOptionEntryDto.ediStatusTypeId, studentOptionEntry1.ediStatusType.id)
        assertEquals( studentOptionEntryDto.resit, studentOptionEntry1.resit)
        assertEquals( studentOptionEntryDto.privateStudent, studentOptionEntry1.privateStudent)
    }
    
    @Test
    void testconstructor_NullObject() {
        StudentOptionEntryDto studentOptionEntryDto = new StudentOptionEntryDto(studentOptionEntry3)
        assertEquals( studentOptionEntryDto.studentId, studentOptionEntry3.student.id)
        assertEquals( studentOptionEntryDto.examOptionId, studentOptionEntry3.examOption.id)
        assertEquals( studentOptionEntryDto.statusTypeId, studentOptionEntry3.statusType);
        assertEquals( studentOptionEntryDto.ediStatusTypeId, studentOptionEntry3.ediStatusType)
        assertEquals( studentOptionEntryDto.resit, studentOptionEntry3.resit)
        assertEquals( studentOptionEntryDto.privateStudent, studentOptionEntry3.privateStudent)
    }
    
    @Test
    void testConstructor_studentOptionEntry() {
        Student student = new Student(id: 1)
        ExamOption examOption = new ExamOption(id: 1)
        StatusType statusType = new StatusType(id: 1)
        EdiStatusType ediStatusType = new EdiStatusType()
        StudentOptionEntryDto studentOptionEntryDto = new StudentOptionEntryDto(student, examOption, statusType, ediStatusType, true, true )
        assertEquals( studentOptionEntryDto.studentId, student.id);
        assertEquals( studentOptionEntryDto.examOptionId, examOption.id);
        assertEquals( studentOptionEntryDto.statusTypeId, statusType.id);
        assertEquals( studentOptionEntryDto.resit, true)
        assertEquals( studentOptionEntryDto.privateStudent, true)
    }
    
    @Test
    public void testMapFromStudentOptionEntryEntity() {
        StudentOptionEntryDto studentOptionEntryDto = StudentOptionEntryDto.mapFromEntity( studentOptionEntry1 );
        assertEquals( studentOptionEntryDto.studentId, studentOptionEntry1.student.id);
        assertEquals( studentOptionEntryDto.examOptionId, studentOptionEntry1.examOption.id);
        assertEquals( studentOptionEntryDto.statusTypeId, studentOptionEntry1.statusType.id);
        assertEquals( studentOptionEntryDto.ediStatusTypeId, studentOptionEntry1.ediStatusType.id)
        assertEquals( studentOptionEntryDto.resit, studentOptionEntry1.resit)
        assertEquals( studentOptionEntryDto.privateStudent, studentOptionEntry1.privateStudent)
    }
    
    @Test
    public void testMapFromStudentComponentsEntities(){
        List<StudentOptionEntryDto> studentComponentDtoList = StudentOptionEntryDto.mapFromList( this.studentOptionEntries )
        assertEquals( studentComponentDtoList[0].studentId, studentOptionEntry1.student.id);
        assertEquals( studentComponentDtoList[0].examOptionId, studentOptionEntry1.examOption.id);
        assertEquals( studentComponentDtoList[0].statusTypeId, studentOptionEntry1.statusType.id);
        assertEquals( studentComponentDtoList[0].ediStatusTypeId, studentOptionEntry1.ediStatusType.id);
        assertEquals( studentComponentDtoList[0].resit, studentOptionEntry1.resit);
        assertEquals( studentComponentDtoList[0].privateStudent, studentOptionEntry1.privateStudent);
        assertEquals( studentComponentDtoList[1].studentId, studentOptionEntry2.student.id);
        assertEquals( studentComponentDtoList[1].examOptionId, studentOptionEntry2.examOption.id);
        assertEquals( studentComponentDtoList[1].statusTypeId, studentOptionEntry2.statusType.id);
        assertEquals( studentComponentDtoList[1].ediStatusTypeId, studentOptionEntry2.ediStatusType.id);
        assertEquals( studentComponentDtoList[1].resit, studentOptionEntry2.resit);
        assertEquals( studentComponentDtoList[1].privateStudent, studentOptionEntry2.privateStudent);
    }
    
    @Test
    public void testMethod_Get_OptionEntryCode() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry1)
        assertEquals(studentOptionEntryDto1.examOption.optionEntryCode, studentOptionEntryDto1.get_OptionEntryCode())
    }
    
    @Test
    public void testMethod_Get_OptionTitle() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry1)
        assertEquals(studentOptionEntryDto1.examOption.optionTitle, studentOptionEntryDto1.get_OptionTitle())
    }
    
    @Test
    public void testMethod_Get_StatusTypeDescription() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry1)
        assertEquals(studentOptionEntryDto1.statusType.description, studentOptionEntryDto1.get_StatusTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullStatusTypeDescription() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry3)
        assertEquals(studentOptionEntryDto1.statusType, studentOptionEntryDto1.get_StatusTypeDescription())
    }
    
    @Test
    public void testMethod_Get_EdiStatusTypeDescription() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry1)
        assertEquals(studentOptionEntryDto1.ediStatusType.description, studentOptionEntryDto1.get_EdiStatusTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullEdiStatusTypeDescription() {
        StudentOptionEntryDto studentOptionEntryDto1 = new StudentOptionEntryDto(studentOptionEntry3)
        assertEquals(studentOptionEntryDto1.ediStatusType, studentOptionEntryDto1.get_EdiStatusTypeDescription())
    }
}
