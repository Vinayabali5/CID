package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.Results
import uk.ac.reigate.domain.exams.basedata.ExamOption

public class ResultsDtoTest {
    
    private Student student
    
    private AcademicYear academicYear
    
    private Faculty faculty
    
    private Results results1
    
    private Results results2
    
    private Results results3
    
    private List<Results> resultss
    
    @Before
    public void setupTests() {
        this.results1 = new Results(
                id: 1,
                student: new Student(id: 190001),
                academicYear: new AcademicYear(id: 20, code: '18'),
                candidateNo : 19001,
                examBoard : new ExamBoard(id:1, boardIdentifier: '1A', name: 'Test'),
                examSeries : '1A',
                examYear : '2020',
                resultsCode: 'P',
                score: 'A',
                grade: 'A',
                examDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                importDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                examOption: new ExamOption(id: 1, optionTitle: 'A Level')
                );
        this.results2 = new Results(
                id: 2,
                student: new Student(id: 190001),
                academicYear: new AcademicYear(id: 20),
                candidateNo : 19001,
                examBoard : new ExamBoard(id:1, boardIdentifier: '1A'),
                examSeries : '1A',
                examYear : '2020',
                resultsCode: 'P',
                score: 'A',
                grade: 'A',
                examDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                importDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        this.results3 = new Results(
                id: 2,
                student: new Student(id: 190001),
                academicYear: null,
                candidateNo : 19001,
                examBoard : null,
                examSeries : '1A',
                examYear : '2020',
                resultsCode: 'P',
                score: 'A',
                grade: 'A',
                examDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                importDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                examOption: null
                );
        this.resultss = Arrays.asList(results1, results2);
    }
    
    ResultsDto generateResultsDto() {
        return generateResults1Dto()
    }
    
    ResultsDto generateResults1Dto(){
        return new ResultsDto(results1)
    }
    
    ResultsDto generateResults2Dto(){
        return new ResultsDto(results2)
    }
    
    @Test
    public void testMapFromResultsEntityTest(){
        ResultsDto resultsTest = ResultsDto.mapFromEntity( results1 )
        assertEquals( resultsTest.id, results1.id );
        assertEquals( resultsTest.studentId, results1.student.id);
        assertEquals( resultsTest.academicYearId, results1.academicYear.id);
        assertEquals( resultsTest.candidateNo, results1.candidateNo);
        assertEquals( resultsTest.examSeries, results1.examSeries);
        assertEquals( resultsTest.resultCode, results1.resultsCode);
        assertEquals( resultsTest.score, results1.score);
        assertEquals( resultsTest.grade, results1.grade);
        assertEquals( resultsTest.examDate, results1.examDate);
        assertEquals( resultsTest.importDate, results1.importDate);
    }
    
    @Test
    public void testMapFromResultsEntitiesTest(){
        List<ResultsDto> resultsTest = ResultsDto.mapFromList(resultss)
        assertEquals( resultsTest[0].id, results1.id );
        assertEquals( resultsTest[0].studentId, results1.student.id);
        assertEquals( resultsTest[0].academicYearId, results1.academicYear.id);
        assertEquals( resultsTest[0].candidateNo, results1.candidateNo)
        assertEquals( resultsTest[0].examSeries, results1.examSeries)
        assertEquals( resultsTest[0].resultCode, results1.resultsCode)
        assertEquals( resultsTest[0].score, results1.score)
        assertEquals( resultsTest[0].grade, results1.grade)
        assertEquals( resultsTest[0].examDate, results1.examDate)
        assertEquals( resultsTest[0].importDate, results1.importDate)
        assertEquals( resultsTest[1].id, results2.id );
        assertEquals( resultsTest[1].studentId, results2.student.id);
        assertEquals( resultsTest[1].academicYearId, results2.academicYear.id);
        assertEquals( resultsTest[1].candidateNo, results2.candidateNo)
        assertEquals( resultsTest[1].examSeries, results2.examSeries)
        assertEquals( resultsTest[1].resultCode, results2.resultsCode)
        assertEquals( resultsTest[1].score, results2.score)
        assertEquals( resultsTest[1].grade, results2.grade)
        assertEquals( resultsTest[1].examDate, results2.examDate)
        assertEquals( resultsTest[1].importDate, results2.importDate)
    }
    
    @Test
    public void testEquals_Same() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        ResultsDto resultsDto2 = new ResultsDto(results1)
        assertEquals( resultsDto1, resultsDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        ResultsDto resultsDto2 = new ResultsDto(results2)
        assertNotEquals( resultsDto1, resultsDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        ResultsDto resultsDto2 = new ResultsDto(results1)
        assertEquals( resultsDto1.hashCode(), resultsDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        ResultsDto resultsDto2 = new ResultsDto(results2)
        assertNotEquals( resultsDto1.hashCode(), resultsDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Results() {
        ResultsDto resultsTest = new ResultsDto(results1)
        assertEquals( resultsTest.studentId, results1.student.id )
        assertEquals( resultsTest.studentId, results1.student.id);
        assertEquals( resultsTest.academicYearId, results1.academicYear.id);
        assertEquals( resultsTest.candidateNo, results1.candidateNo);
        assertEquals( resultsTest.examSeries, results1.examSeries);
        assertEquals( resultsTest.resultCode, results1.resultsCode);
        assertEquals( resultsTest.score, results1.score);
        assertEquals( resultsTest.grade, results1.grade);
        assertEquals( resultsTest.examDate, results1.examDate);
        assertEquals( resultsTest.importDate, results1.importDate);
    }
    
    @Test
    public void testConstructor_NullAcademicYear() {
        ResultsDto resultsTest = new ResultsDto(results3)
        assertEquals( resultsTest.studentId, results3.student.id )
        assertEquals( resultsTest.studentId, results3.student.id )
        assertEquals( resultsTest.studentId, results3.student.id);
        assertEquals( resultsTest.academicYearId, results3.academicYear);
        assertEquals( resultsTest.candidateNo, results3.candidateNo);
        assertEquals( resultsTest.examSeries, results3.examSeries);
        assertEquals( resultsTest.resultCode, results3.resultsCode);
        assertEquals( resultsTest.score, results3.score);
        assertEquals( resultsTest.grade, results3.grade);
        assertEquals( resultsTest.examDate, results3.examDate);
        assertEquals( resultsTest.importDate, results3.importDate);
    }
    
    @Test
    public void testMethod_Get_AcademicYearCode() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        assertEquals(resultsDto1.academicYear.code, resultsDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_NullAcademicYearCode() {
        ResultsDto resultsDto1 = new ResultsDto(results3)
        assertEquals(resultsDto1.academicYear, resultsDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_BoardName() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        assertEquals(resultsDto1.examBoard.name, resultsDto1.get_BoardName())
    }
    
    @Test
    public void testMethod_Get_NullBoardName() {
        ResultsDto resultsDto1 = new ResultsDto(results3)
        assertEquals(resultsDto1.examBoard, resultsDto1.get_BoardName())
    }
    
    @Test
    public void testMethod_Get_ExamOptionTitle() {
        ResultsDto resultsDto1 = new ResultsDto(results1)
        assertEquals(resultsDto1.examOption.optionTitle, resultsDto1.get_examOptionTitle())
    }
    
    @Test
    public void testMethod_Get_NullExamOptionTitle() {
        ResultsDto resultsDto1 = new ResultsDto(results3)
        assertEquals(resultsDto1.examOption, resultsDto1.get_examOptionTitle())
    }
}
