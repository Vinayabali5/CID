package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.basedata.ExamOption

public class CourseOptionDtoTest {
    
    private CourseOption courseOption1
    
    private CourseOption courseOption2
    
    private List<CourseOption> courseOptions
    
    private Course course
    
    private ExamOption examOption
    
    @Before
    public void setup() {
        this.courseOption1 = new CourseOption(
                course : new Course(id: 1),
                examOption : new ExamOption(id: 1),
                lowerEntry :true,
                upperEntry : true,
                intermediateEntry : true
                );
        this.courseOption2 = new CourseOption(
                course : new Course(id: 4),
                examOption : new ExamOption(id: 4),
                lowerEntry :true,
                upperEntry : true,
                intermediateEntry : true
                );
        this.courseOptions = Arrays.asList(this.courseOption1, this.courseOption2);
    }
    
    @Test
    void testconstructor_courseOptionDto() {
        CourseOptionDto courseOptionDto = new CourseOptionDto(courseOption1)
        assertEquals( courseOptionDto.courseId, courseOption1.course.id)
        assertEquals( courseOptionDto.examOptionId, courseOption1.examOption.id)
    }
    
    @Test
    void testConstructor_courseOption() {
        Course course = new Course(id: 1)
        ExamOption examOption = new ExamOption(id: 1)
        CourseOptionDto courseOptionDto = new CourseOptionDto( course, examOption, true, true, true )
        assertEquals( courseOptionDto.courseId, course.id);
        assertEquals( courseOptionDto.examOptionId, examOption.id);
        assertEquals( courseOptionDto.lowerEntry, true)
        assertEquals( courseOptionDto.upperEntry, true)
        assertEquals( courseOptionDto.intermediateEntry, true)
    }
    
    @Test
    public void testMapFromCourseOptionEntity() {
        CourseOptionDto courseOptionDto = CourseOptionDto.mapFromEntity( courseOption1 );
        assertEquals( courseOptionDto.courseId, courseOption1.course.id);
        assertEquals( courseOptionDto.examOptionId, courseOption1.examOption.id);
    }
    
    @Test
    public void testMapFromCourseComponentsEntities(){
        List<CourseOptionDto> courseComponentDtoList = CourseOptionDto.mapFromList( this.courseOptions )
        assertEquals( courseComponentDtoList[0].courseId, courseOption1.course.id);
        assertEquals( courseComponentDtoList[0].examOptionId, courseOption1.examOption.id);
        assertEquals( courseComponentDtoList[1].courseId, courseOption2.course.id);
        assertEquals( courseComponentDtoList[1].examOptionId, courseOption2.examOption.id);
    }
}
