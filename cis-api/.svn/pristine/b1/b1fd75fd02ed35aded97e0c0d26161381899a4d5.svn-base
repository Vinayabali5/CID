package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseSyllabus
import uk.ac.reigate.domain.exams.basedata.Syllabus

public class CourseSyllabusDtoTest {
    
    private CourseSyllabus courseSyllabus1
    
    private CourseSyllabus courseSyllabus2
    
    private List<CourseSyllabus> courseSyllabusList
    
    private Course course
    
    @Before
    public void setup() {
        this.courseSyllabus1 = new CourseSyllabus(
                course : new Course(id: 1),
                syllabus : new Syllabus(id: 1)
                );
        this.courseSyllabus2 = new CourseSyllabus(
                course : new Course(id: 4),
                syllabus : new Syllabus(id: 4)
                );
        this.courseSyllabusList = Arrays.asList(this.courseSyllabus1, this.courseSyllabus2);
    }
    
    @Test
    void testconstructor_courseSyllabusDto() {
        CourseSyllabusDto courseSyllabusDto = new CourseSyllabusDto(courseSyllabus1)
        assertEquals( courseSyllabusDto.courseId, courseSyllabus1.course.id)
        assertEquals( courseSyllabusDto.syllabusId, courseSyllabus1.syllabus.id)
    }
    
    @Test
    void testConstructor_courseSyllabus() {
        Course course = new Course(id: 1)
        Syllabus syllabus = new Syllabus(id: 1)
        CourseSyllabusDto courseSyllabusDto = new CourseSyllabusDto( course, syllabus )
        assertEquals( courseSyllabusDto.courseId, course.id);
        assertEquals( courseSyllabusDto.syllabusId, syllabus.id);
    }
    
    @Test
    public void testMapFromCourseSyllabusEntity() {
        CourseSyllabusDto courseSyllabusDto = CourseSyllabusDto.mapFromEntity( courseSyllabus1 );
        assertEquals( courseSyllabusDto.courseId, courseSyllabus1.course.id);
        assertEquals( courseSyllabusDto.syllabusId, courseSyllabus1.syllabus.id);
    }
    
    @Test
    public void testMapFromCourseSyllabusEntities(){
        List<CourseSyllabusDto> courseSyllabusDtoList = CourseSyllabusDto.mapFromList( this.courseSyllabusList )
        assertEquals( courseSyllabusDtoList[0].courseId, courseSyllabus1.course.id);
        assertEquals( courseSyllabusDtoList[0].syllabusId, courseSyllabus1.syllabus.id);
        assertEquals( courseSyllabusDtoList[1].courseId, courseSyllabus2.course.id);
        assertEquals( courseSyllabusDtoList[1].syllabusId, courseSyllabus2.syllabus.id);
    }
}
