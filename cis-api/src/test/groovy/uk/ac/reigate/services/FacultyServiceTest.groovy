package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.dto.FacultyDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.FacultyRepository;

@RunWith(MockitoJUnitRunner.class)
class FacultyServiceTest {
    
    @Mock
    private FacultyRepository facultyRepository;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private DepartmentService departmentService;
    
    @InjectMocks
    private FacultyService facultyService;
    
    private Faculty faculty
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Faculty createFaculty() {
        return new Faculty(
                id: 1,
                code:'A',
                description:'A Faculty',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                )
    }
    
    FacultyDto createDto() {
        Faculty sampleData = createFaculty()
        return new FacultyDto(
                id: faculty.id,
                code:faculty.code,
                description:faculty.description,
                validFrom: faculty.validFrom,
                validTo: faculty.validTo
                )
    }
    
    @Before
    public void setup() {
        facultyRepository = mock(FacultyRepository.class);
        staffService = mock(StaffService.class);
        departmentService = mock(DepartmentService.class);
        facultyService = new FacultyService(facultyRepository, staffService, departmentService);
        
        faculty = createFaculty()
        
        when(facultyRepository.findById(faculty.id)).thenReturn(new Optional(new Faculty()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        FacultyService service = new FacultyService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Faculty> result = facultyService.findAll();
        verify(facultyRepository, times(1)).findAll()
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindFacultyById() {
        Faculty result = facultyService.findById(1);
        verify(facultyRepository, times(1)).findById(1)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByHeadOfFaculty() {
        Staff hof = new Staff(id: 11)
        List<Faculty> result = facultyService.findByHeadOfFaculty(hof);
        verify(facultyRepository, times(1)).findByHof(hof)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByDirectorOfLearning() {
        Staff dol = new Staff(id: 11)
        List<Faculty> result = facultyService.findByDirectorOfLearning(dol);
        verify(facultyRepository, times(1)).findByDol(dol)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByDol() {
        Staff dol = new Staff(id: 11)
        List<Faculty> result = facultyService.findByDol(dol);
        verify(facultyRepository, times(1)).findByDol(dol)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByAssociateDirectorOfLearning() {
        Staff adol = new Staff(id: 11)
        List<Faculty> result = facultyService.findByAdol(adol);
        verify(facultyRepository, times(1)).findByAdol(adol)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByAdol() {
        Staff adol = new Staff(id: 11)
        List<Faculty> result = facultyService.findByAssociateDirectorOfLearning(adol);
        verify(facultyRepository, times(1)).findByAdol(adol)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByPastoralDirector() {
        Staff pd = new Staff(id: 11)
        List<Faculty> result = facultyService.findByPastoralDirector(pd);
        verify(facultyRepository, times(1)).findByPd(pd)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByPd() {
        Staff pd = new Staff(id: 11)
        List<Faculty> result = facultyService.findByPd(pd);
        verify(facultyRepository, times(1)).findByPd(pd)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByAssociatePastroalDirector() {
        Staff apd = new Staff(id: 11)
        List<Faculty> result = facultyService.findByAssociatePastroalDirector(apd);
        verify(facultyRepository, times(1)).findByApd(apd)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByApd() {
        Staff apd = new Staff(id: 11)
        List<Faculty> result = facultyService.findByApd(apd);
        verify(facultyRepository, times(1)).findByApd(apd)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testFindByHof() {
        Staff hof = new Staff(id: 11)
        List<Faculty> result = facultyService.findByHof(hof);
        verify(facultyRepository, times(1)).findByHof(hof)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testSave() {
        faculty.id = null
        facultyService.save(faculty);
        verify(facultyRepository, times(1)).save(faculty)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testSaveList() {
        List<Faculty> savedFaculties = facultyService.saveFaculties([faculty, faculty]);
        verify(facultyRepository, times(2)).save(faculty)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testSaveFaculty() {
        facultyService.save(faculty);
        verify(facultyRepository, times(1)).save(faculty)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create facultyDto from null object.")
        FacultyDto dto = null
        facultyService.createFromDto(dto)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withDto() {
        FacultyDto dto = createDto()
        dto.hofId = null
        dto.dolId = null
        dto.adolId = null
        dto.pdId = null
        dto.apdId = null
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withHofId() {
        FacultyDto dto = createDto()
        dto.hofId = 1
        when(staffService.findById(dto.hofId)).thenReturn(null);
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withDolId() {
        FacultyDto dto = createDto()
        dto.dolId = 1
        when(staffService.findById(dto.dolId)).thenReturn(null);
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withADolId() {
        FacultyDto dto = createDto()
        dto.adolId = 1
        when(staffService.findById(dto.adolId)).thenReturn(null);
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withPdId() {
        FacultyDto dto = createDto()
        dto.pdId = 1
        when(staffService.findById(dto.pdId)).thenReturn(null);
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testCreateFromDto_withAPdId() {
        FacultyDto dto = createDto()
        dto.apdId = 1
        when(staffService.findById(dto.apdId)).thenReturn(null);
        facultyService.createFromDto(dto)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        FacultyDto dto = createDto()
        dto.hofId = null
        dto.dolId = null
        dto.adolId = null
        dto.pdId = null
        dto.apdId = null
        facultyService.updateFromDto(dto)
        verify(facultyRepository, times(1)).findById(faculty.id)
        verify(facultyRepository, times(1)).save(any(Faculty.class))
        verifyNoMoreInteractions(facultyRepository)
    }
    
    @Test
    public void testupdateFromDto_withHofId() {
        FacultyDto dto = createDto()
        dto.hofId = 1
        when(staffService.findById(dto.hofId)).thenReturn(null);
        facultyService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.hofId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testupdateFromDto_withDolId() {
        FacultyDto dto = createDto()
        dto.dolId = 1
        when(staffService.findById(dto.dolId)).thenReturn(null);
        facultyService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.dolId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testupdateFromDto_withADolId() {
        FacultyDto dto = createDto()
        dto.adolId = 1
        when(staffService.findById(dto.adolId)).thenReturn(null);
        facultyService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.adolId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testupdateFromDto_withPdId() {
        FacultyDto dto = createDto()
        dto.pdId = 1
        when(staffService.findById(dto.pdId)).thenReturn(null);
        facultyService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.pdId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testupdateFromDto_withAPdId() {
        FacultyDto dto = createDto()
        dto.apdId = 1
        when(staffService.findById(dto.apdId)).thenReturn(null);
        facultyService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.apdId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update facultyDto from null object.")
        FacultyDto dto = null
        facultyService.updateFromDto(dto)
        verifyNoMoreInteractions(facultyRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        facultyService.delete(faculty)
        verifyNoMoreInteractions(facultyRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

