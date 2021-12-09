package uk.ac.reigate.services.search

import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.repositories.search.StudentSearchRepository
import uk.ac.reigate.services.AcademicYearService


@RunWith(MockitoJUnitRunner.class)
class StudentSearchServiceTest {
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentSearchRepository studentServiceRepository
    
    @InjectMocks
    private StudentSearchService studentSearchService;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private Student student
    
    @Before
    public void setup() {
        this.academicYearService = mock(AcademicYearService.class);
        this.studentServiceRepository = mock(StudentSearchRepository.class);
        this.studentSearchService = new StudentSearchService(academicYearService, studentServiceRepository)
    }
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testSearchByYearSurnameFirstNameAndReference() {
        AcademicYear year = new AcademicYear(id:1)
        List<Student> result = studentSearchService.searchByYearSurnameFirstNameAndReference(year, 'vin','uday', '123')
        verify(studentServiceRepository, times(1)).findByStudentYears_YearAndPerson_SurnameLikeAndPerson_FirstNameLikeAndReferenceNoLike(year, 'vin','uday', '123')
        verifyNoMoreInteractions(studentServiceRepository)
    }
    
    @Test
    public void testSearchByYearSurnameFirstNameOrPreferredNameAndReference() {
        AcademicYear year = new AcademicYear(id:1)
        List<Student> result = studentSearchService.searchByYearSurnameFirstNameOrPreferredNameAndReference(year, 'vin','uday', 'vinaya', '123')
        verify(studentServiceRepository, times(1)).findByStudentYears_YearAndPerson_SurnameLikeAndPerson_FirstNameLikeOrPerson_PreferredNameLikeAndReferenceNoLike(year, 'vin','uday', 'vinaya', '123')
        verifyNoMoreInteractions(studentServiceRepository)
    }
    
    @Test
    public void testSearchByYearCandidateNo() {
        AcademicYear year = new AcademicYear(id:1)
        List<Student> result = studentSearchService.searchByYearCandidateNo(year, 1)
        verify(studentServiceRepository, times(1)).findByStudentYears_YearAndStudentYears_CandidateNo(year, 1)
        verifyNoMoreInteractions(studentServiceRepository)
    }
    
    @Test
    public void testSearchByYearSurnameName() {
        AcademicYear year = new AcademicYear(id:1)
        List<Student> result = studentSearchService.searchByYearSurnameName(year, 'vin','uday', '123')
        verify(studentServiceRepository, times(1)).searchStudent(year, 'vin','uday', '123')
        verifyNoMoreInteractions(studentServiceRepository)
    }
}