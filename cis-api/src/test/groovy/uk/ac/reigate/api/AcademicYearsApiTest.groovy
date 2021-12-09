package uk.ac.reigate.api;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset
import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.web.context.WebApplicationContext

import uk.ac.reigate.config.testing.TestMockServiceConfig
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.services.AcademicYearService


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestMockServiceConfig.class)
@WebAppConfiguration
public class AcademicYearsApiTest {
    
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    
    private MockMvc mockMvc;
    
    @Mock
    private AcademicYearRepository academicYearRepoisitory
    
    @MockBean
    private AcademicYearService academicYearService
    
    @Mock
    private WebApplicationContext webApplicationContext;
    
    private AcademicYear academicYear
    
    @InjectMocks
    private AcademicYearsApi academicYearsApi
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.academicYearService = mock(academicYearService.class);
        this.academicYearsApi = new AcademicYearsApi(academicYearService);
    }
    
    @Test
    public void testApiNoArgsConstructor() {
        AcademicYearsApi api = new AcademicYearsApi();
        assertNotNull(api)
    }
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AcademicYearsApi.class);
    
    //@Test
    public void getAll() throws Exception{
        AcademicYear academicYear1 = new AcademicYear(
                id: 1,
                code: '99/00',
                description: 'Test Data',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                startYear: 2017,
                enumerationDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingStartDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
        AcademicYear academicYear2 = new AcademicYear(
                id: 2,
                code: '99/00',
                description: 'Test Data',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                startYear: 2019,
                enumerationDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingStartDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
        when(academicYearService.findAll()).thenReturn(Arrays.asList(academicYear1, academicYear2))
        
        mockMvc.perform(get("/academic-years"))
        verify(academicYearService, times(1)).findAll();
        verifyNoMoreInteractions(academicYearService);
    }
    
    //@Test
    public void getById() throws Exception {
        AcademicYear academicYear = academicYearService.findById(1);
        Mockito.when(academicYearService.findById(1)).thenReturn(academicYear);
        
        //	  when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(AcademicYear.class)))
        //	  .thenReturn(new ResponseEntity<>(new AcademicYear(), HttpStatus.OK));
        
        ResultActions resultActions = mvc.perform(get("/academic-years/" + 1))
                .andExpect(status().isOk())
        
        // AcademicYearsApi academicYearsApi = mapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), academicYearsApi.class);
        
        //  assertEquals(academicYear.getId(), academicYearsApi.getById(1));
        
        verify(academicYearService, times(1)).findById(1);
    }
}
