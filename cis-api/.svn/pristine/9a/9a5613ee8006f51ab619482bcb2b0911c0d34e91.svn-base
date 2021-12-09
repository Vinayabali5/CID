package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption

public class CourseComponentDtoTest {
    
    private CourseComponent courseComponent1
    
    private CourseComponent courseComponent2
    
    private List<CourseComponent> courseComponents
    
    private Course course
    
    private ExamOption examOption
    
    private ExamComponent examComponent
    
    @Before
    public void setup() {
        this.courseComponent1 = new CourseComponent(
                course : new Course(id: 1),
                examOption : new ExamOption(id: 1),
                examComponent : new ExamComponent(id:1)
                );
        this.courseComponent2 = new CourseComponent(
                course : new Course(id: 4),
                examOption : new ExamOption(id: 4),
                examComponent : new ExamComponent(id:4)
                );
        this.courseComponents = Arrays.asList(this.courseComponent1, this.courseComponent2);
    }
    
    @Test
    void testconstructor_courseComponentDto() {
        CourseComponentDto courseComponentDto = new CourseComponentDto(courseComponent1)
        assertEquals( courseComponentDto.courseId, courseComponent1.course.id)
        assertEquals( courseComponentDto.examOptionId, courseComponent1.examOption.id)
        assertEquals( courseComponentDto.examComponentId, courseComponent1.examComponent.id)
    }
    
    @Test
    void testConstructor_courseComponent() {
        Course course = new Course(id: 1)
        ExamOption examOption = new ExamOption(id: 1)
        ExamComponent examComponent = new ExamComponent(id: 1)
        CourseComponentDto courseComponentDto = new CourseComponentDto( course, examOption, examComponent )
        assertEquals( courseComponentDto.courseId, course.id);
        assertEquals( courseComponentDto.examOptionId, examOption.id);
        assertEquals( courseComponentDto.examComponentId, examOption.id);
    }
    
    @Test
    public void testMapFromCoursecomponentEntity() {
        CourseComponentDto courseComponentDto = CourseComponentDto.mapFromEntity( courseComponent1 );
        assertEquals( courseComponentDto.courseId, courseComponent1.course.id);
        assertEquals( courseComponentDto.examOptionId, courseComponent1.examOption.id);
        assertEquals( courseComponentDto.examComponentId, courseComponent1.examComponent.id);
    }
    
    @Test
    public void testMapFromCourseComponentsEntities(){
        List<CourseComponentDto> courseComponentDtoList = CourseComponentDto.mapFromList( this.courseComponents )
        assertEquals( courseComponentDtoList[0].courseId, courseComponent1.course.id);
        assertEquals( courseComponentDtoList[0].examOptionId, courseComponent1.examOption.id);
        assertEquals( courseComponentDtoList[0].examComponentId, courseComponent1.examComponent.id);
        assertEquals( courseComponentDtoList[1].courseId, courseComponent2.course.id);
        assertEquals( courseComponentDtoList[1].examOptionId, courseComponent2.examOption.id);
        assertEquals( courseComponentDtoList[1].examComponentId, courseComponent2.examComponent.id);
    }
}
