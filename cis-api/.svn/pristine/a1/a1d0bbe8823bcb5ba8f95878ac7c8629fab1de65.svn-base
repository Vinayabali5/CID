package uk.ac.reigate.services

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Timetable
import uk.ac.reigate.dto.TimetableDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.TimetableRepository

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

class TimetableServiceTest {
    
    @Mock
    private TimetableRepository timetableRepository
    
    @Mock
    private CourseGroupService courseGroupService;
    
    @Mock
    private PeriodService periodService;
    
    @Mock
    private RoomService roomService;
    
    @Mock
    private StaffService staffService
    
    @InjectMocks
    private TimetableService timetableService;
    
    private Timetable timetable;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Timetable createTimetable() {
        return new Timetable(
                id: 1,
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
    }
    
    TimetableDto createDto() {
        Timetable sampleData = createTimetable()
        return new TimetableDto(
                id: sampleData.id,
                validFrom: sampleData.validFrom,
                validTo: sampleData.validTo
                )
    }
    
    @Before
    public void setup() {
        timetableRepository = mock(TimetableRepository.class);
        courseGroupService = mock(CourseGroupService.class);
        periodService = mock(PeriodService.class);
        roomService = mock(RoomService.class);
        staffService = mock(StaffService.class);
        
        this.timetableService = new TimetableService(timetableRepository, courseGroupService, periodService, roomService, staffService);
        
        timetable = createTimetable();
        
        when(timetableRepository.findById(1)).thenReturn(new Optional(timetable));
        when(timetableRepository.save(any(Timetable.class))).thenReturn(timetable);
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        TimetableService service = new TimetableService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Timetable> result = timetableService.findAll();
        verify(timetableRepository, times(1)).findAll()
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testFindTimetable() {
        Timetable result = timetableService.findById(1);
        verify(timetableRepository, times(1)).findById(1)
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testSaveNewTimetable() {
        timetable.id = null
        Timetable savedTimetable = timetableService.save(timetable);
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testSaveTimetable() {
        Timetable savedTimetable = timetableService.save(timetable);
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        TimetableDto dto = createDto()
        timetableService.createFromDto(dto)
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        // Stub Data and Method Returns
        TimetableDto dto = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create timetableDto from null object.");
        // Initialise Test
        timetableService.createFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithCourseGroupId() {
        TimetableDto dto = createDto()
        dto.courseGroupId= 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null);
        timetableService.createFromDto(dto)
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithPeriodId() {
        TimetableDto dto = createDto()
        dto.periodId= 1
        when(periodService.findById(dto.periodId)).thenReturn(null);
        timetableService.createFromDto(dto)
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithRoomId() {
        TimetableDto dto = createDto()
        dto.roomId= 1
        when(roomService.findById(dto.roomId)).thenReturn(null);
        timetableService.createFromDto(dto)
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithTeacherId() {
        TimetableDto dto = createDto()
        dto.teacherId= 1
        when(staffService.findById(dto.teacherId)).thenReturn(null);
        timetableService.createFromDto(dto)
        verify(timetableRepository, times(1)).save(any(Timetable.class))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        // Stub Data and Method Returns
        TimetableDto dto = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update timetableDto from null object.");
        // Initialise Test
        timetableService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithCourseGroupId() {
        TimetableDto dto = createDto()
        dto.courseGroupId= 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null);
        timetableService.updateFromDto(dto)
        verify(courseGroupService, times(1)).findById(dto.courseGroupId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithPeriodId() {
        TimetableDto dto = createDto()
        dto.periodId= 1
        when(periodService.findById(dto.periodId)).thenReturn(null);
        timetableService.updateFromDto(dto)
        verify(periodService, times(1)).findById(dto.periodId)
        verifyNoMoreInteractions(periodService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRoomId() {
        TimetableDto dto = createDto()
        dto.roomId= 1
        when(roomService.findById(dto.roomId)).thenReturn(null);
        timetableService.updateFromDto(dto)
        verify(roomService, times(1)).findById(dto.roomId)
        verifyNoMoreInteractions(roomService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithTeacherId() {
        TimetableDto dto = createDto()
        dto.teacherId= 1
        when(staffService.findById(dto.teacherId)).thenReturn(null);
        timetableService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.teacherId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Timetable should not be deleted");
        timetableService.delete(new Timetable(id: 1))
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testDeleteById() {
        timetableService.delete(1)
        verify(timetableRepository, times(1)).deleteById(1)
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testGetStaffTimetable() {
        AcademicYear year = new AcademicYear(id: 1)
        Staff staff = new Staff(id:1)
        List<Timetable> result = timetableService.getStaffTimetable(year, staff);
        verify(timetableRepository, times(1)).findByCourseGroup_YearAndTeacher(year, staff)
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testGetStaffTimetableCurrent() {
        AcademicYear year = new AcademicYear(id: 1)
        Staff staff = new Staff(id:1)
        List<Timetable> result = timetableService.getStaffTimetableCurrent(year, staff);
        verify(timetableRepository, times(1)).findByYearAndTeacherCurrent(year, staff)
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testGetStaffTimetableOnDate() {
        AcademicYear year = new AcademicYear(id: 1)
        Staff staff = new Staff(id:1)
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        List<Timetable> result = timetableService.getStaffTimetableOnDate(year, staff, date);
        verify(timetableRepository, times(1)).findByYearAndTeacherOnDate(year, staff, date)
        verifyNoMoreInteractions(timetableRepository)
    }
    
    @Test
    public void testGetCourseGroupsByYearId() {
        List<Timetable> result = timetableService.getCourseGroupsByYearId(11, 10);
        verify(timetableRepository, times(1)).findByCourseGroup_Year_IdAndCourseGroup_Id(11, 10)
        verifyNoMoreInteractions(timetableRepository)
    }
}

