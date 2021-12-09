package uk.ac.reigate.config.testing

import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

import uk.ac.reigate.repositories.AddressRepository
import uk.ac.reigate.repositories.ContactRepository
import uk.ac.reigate.repositories.NoteRepository
import uk.ac.reigate.repositories.NoteTypeRepository
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.repositories.RoomRepository
import uk.ac.reigate.repositories.SchoolRepository
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.repositories.academic.BlockRepository
import uk.ac.reigate.repositories.academic.CourseGroupRepository
import uk.ac.reigate.repositories.academic.CourseRepository
import uk.ac.reigate.repositories.academic.DepartmentRepository
import uk.ac.reigate.repositories.academic.FacultyRepository
import uk.ac.reigate.repositories.academic.HolidayRepository
import uk.ac.reigate.repositories.academic.PeriodRepository
import uk.ac.reigate.repositories.academic.RegisteredSessionRepository
import uk.ac.reigate.repositories.academic.SpecialCategoryRepository
import uk.ac.reigate.repositories.academic.TimetableRepository
import uk.ac.reigate.repositories.admissions.ApplicationStatusRepository
import uk.ac.reigate.repositories.admissions.CollegeFundPaidRepository
import uk.ac.reigate.repositories.admissions.CollegeFundPaymentRepository
import uk.ac.reigate.repositories.admissions.OfferTypeRepository
import uk.ac.reigate.repositories.admissions.RequestRepository
import uk.ac.reigate.repositories.exams.ExamBoardRepository
import uk.ac.reigate.repositories.ilr.AimTypeRepository
import uk.ac.reigate.repositories.ilr.CompletionStatusRepository
import uk.ac.reigate.repositories.ilr.FundingModelRepository
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemCategoryRepository
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemRepository
import uk.ac.reigate.repositories.ilr.OutcomeRepository
import uk.ac.reigate.repositories.ilr.PriorAttainmentRepository
import uk.ac.reigate.repositories.ilr.ProgrammeTypeRepository
import uk.ac.reigate.repositories.ilr.RestrictedUseIndicatorRepository
import uk.ac.reigate.repositories.ilr.WithdrawalReasonRepository
import uk.ac.reigate.repositories.lookup.ContactTypeRepository
import uk.ac.reigate.repositories.lookup.EthnicityRepository
import uk.ac.reigate.repositories.lookup.GenderRepository
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.repositories.lookup.NationalityRepository
import uk.ac.reigate.repositories.lookup.PossibleGradeRepository
import uk.ac.reigate.repositories.lookup.SchoolPriorityRepository
import uk.ac.reigate.repositories.lookup.SchoolTypeRepository
import uk.ac.reigate.repositories.lookup.StaffTypeRepository
import uk.ac.reigate.repositories.lookup.StudentTypeRepository
import uk.ac.reigate.repositories.lookup.SubjectRepository
import uk.ac.reigate.repositories.lookup.TitleRepository
import uk.ac.reigate.repositories.lookup.TutorGroupRepository
import uk.ac.reigate.repositories.lookup.YearGroupRepository
import uk.ac.reigate.repositories.register.RegisterRepository
import uk.ac.reigate.repositories.system.SettingRepository


@Configuration
@Profile("test")
class TestMockRepositoryConfig {
    
    @Bean
    AcademicYearRepository academicYearRepository() {
        return Mockito.mock(AcademicYearRepository.class)
    }
    
    @Bean
    AddressRepository addressRepository() {
        return Mockito.mock(AddressRepository.class)
    }
    
    @Bean
    AimTypeRepository aimTypeRepository() {
        return Mockito.mock(AimTypeRepository.class)
    }
    
    @Bean
    ApplicationStatusRepository applicationStatusRepository() {
        return Mockito.mock(ApplicationStatusRepository.class)
    }
    
    @Bean
    BlockRepository blockRepository() {
        return Mockito.mock(BlockRepository.class)
    }
    
    @Bean
    CollegeFundPaidRepository collegeFundPaidRepository() {
        return Mockito.mock(CollegeFundPaidRepository.class)
    }
    
    @Bean
    CollegeFundPaymentRepository collegeFundPaymentRepository() {
        return Mockito.mock(CollegeFundPaymentRepository.class)
    }
    
    @Bean
    CompletionStatusRepository completionStatusRepository() {
        return Mockito.mock(CompletionStatusRepository.class)
    }
    
    @Bean
    ContactRepository contactRepository() {
        return Mockito.mock(ContactRepository.class)
    }
    @Bean
    ContactTypeRepository contactTypeRepository() {
        return Mockito.mock(ContactTypeRepository.class)
    }
    
    @Bean
    CourseGroupRepository courseGroupRepository() {
        return Mockito.mock(CourseGroupRepository.class)
    }
    
    @Bean
    CourseRepository courseRepository() {
        return Mockito.mock(CourseRepository.class)
    }
    
    @Bean
    DepartmentRepository departmentRepository() {
        return Mockito.mock(DepartmentRepository.class)
    }
    
    @Bean
    EthnicityRepository ethnicityRepository() {
        return Mockito.mock(EthnicityRepository.class)
    }
    
    @Bean
    ExamBoardRepository examBoardRepository() {
        return Mockito.mock(ExamBoardRepository.class)
    }
    
    @Bean
    FacultyRepository facultyRepository() {
        return Mockito.mock(FacultyRepository.class)
    }
    
    @Bean
    FundingModelRepository fundingModelRepository() {
        return Mockito.mock(FundingModelRepository.class)
    }
    
    @Bean
    GenderRepository genderRepository() {
        return Mockito.mock(GenderRepository.class)
    }
    
    @Bean
    HolidayRepository holidayRepository() {
        return Mockito.mock(HolidayRepository.class)
    }
    
    @Bean
    LevelRepository levelRepository() {
        return Mockito.mock(LevelRepository.class)
    }
    
    @Bean
    LLDDHealthProblemCategoryRepository lLDDHealthProblemCategoryRepository() {
        return Mockito.mock(LLDDHealthProblemCategoryRepository.class)
    }
    
    @Bean
    LLDDHealthProblemRepository lLDDHealthProblemRepository() {
        return Mockito.mock(LLDDHealthProblemRepository.class)
    }
    
    @Bean
    NationalityRepository nationalityRepository() {
        return Mockito.mock(NationalityRepository.class)
    }
    
    @Bean
    NoteRepository noteRepository() {
        return Mockito.mock(NoteRepository.class)
    }
    
    @Bean
    NoteTypeRepository noteTypeRepository() {
        return Mockito.mock(NoteTypeRepository.class)
    }
    
    @Bean
    OfferTypeRepository offerTypeRepository() {
        return Mockito.mock(OfferTypeRepository.class)
    }
    
    @Bean
    OutcomeRepository outcomeRepository() {
        return Mockito.mock(OutcomeRepository.class)
    }
    
    @Bean
    PeriodRepository periodRepository() {
        return Mockito.mock(PeriodRepository.class)
    }
    
    @Bean
    PersonRepository personRepository() {
        return Mockito.mock(PersonRepository.class)
    }
    
    @Bean
    PossibleGradeRepository possibleGradeRepository() {
        return Mockito.mock(PossibleGradeRepository.class)
    }
    
    @Bean
    PriorAttainmentRepository priorAttainmentRepository() {
        return Mockito.mock(PriorAttainmentRepository.class)
    }
    
    @Bean
    ProgrammeTypeRepository programmeTypeRepository() {
        return Mockito.mock(ProgrammeTypeRepository.class)
    }
    
    @Bean
    RegisteredSessionRepository registeredSessionsRepository() {
        return Mockito.mock(RegisteredSessionRepository.class)
    }
    
    @Bean
    RegisterRepository registerRepository() {
        return Mockito.mock(RegisterRepository.class)
    }
    
    @Bean
    RequestRepository requestRepository() {
        return Mockito.mock(RequestRepository.class)
    }
    
    @Bean
    RestrictedUseIndicatorRepository restrictedUseIndicatorRepository() {
        return Mockito.mock(RestrictedUseIndicatorRepository.class)
    }
    
    @Bean
    RoomRepository roomRepository() {
        return Mockito.mock(RoomRepository.class)
    }
    
    @Bean
    SchoolPriorityRepository schoolPriorityRepository() {
        return Mockito.mock(SchoolPriorityRepository.class)
    }
    
    @Bean
    SchoolRepository schoolRepository() {
        return Mockito.mock(SchoolRepository.class)
    }
    
    @Bean
    SchoolTypeRepository schoolTypeRepository() {
        return Mockito.mock(SchoolTypeRepository.class)
    }
    
    @Bean
    SettingRepository settingRepository() {
        return Mockito.mock(SettingRepository.class)
    }
    
    @Bean
    SpecialCategoryRepository specialCategoryRepository() {
        return Mockito.mock(SpecialCategoryRepository.class)
    }
    
    @Bean
    StaffRepository staffRepository() {
        return Mockito.mock(StaffRepository.class)
    }
    
    @Bean
    StaffTypeRepository staffTypeRepository() {
        return Mockito.mock(StaffTypeRepository.class)
    }
    
    @Bean
    StudentTypeRepository studentTypeRepository() {
        return Mockito.mock(StudentTypeRepository.class)
    }
    
    @Bean
    SubjectRepository subjectRepository() {
        return Mockito.mock(SubjectRepository.class)
    }
    
    @Bean
    TimetableRepository timetableRepository() {
        return Mockito.mock(TimetableRepository.class)
    }
    
    @Bean
    TitleRepository titleRepository() {
        return Mockito.mock(TitleRepository.class)
    }
    
    @Bean
    TutorGroupRepository tutorGroupRepository() {
        return Mockito.mock(TutorGroupRepository.class)
    }
    
    @Bean
    WithdrawalReasonRepository withdrawalReasonRepository() {
        return Mockito.mock(WithdrawalReasonRepository.class)
    }
    
    @Bean
    YearGroupRepository yearGroupRepository() {
        return Mockito.mock(YearGroupRepository.class)
    }
}
