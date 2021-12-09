package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentYear is a Querydsl query type for StudentYear
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentYear extends EntityPathBase<StudentYear> {
    
    private static final long serialVersionUID = 2103776762L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentYear studentYear = new QStudentYear("studentYear");
    
    public final BooleanPath attendanceMonitorable = createBoolean("attendanceMonitorable");
    
    public final uk.ac.reigate.domain.lookup.QAttendanceMonitoring attendanceMonitoring;
    
    public final BooleanPath breakInLearning = createBoolean("breakInLearning");
    
    public final uk.ac.reigate.domain.lookup.QBursaryType bursaryType;
    
    public final NumberPath<Integer> candidateNo = createNumber("candidateNo", Integer.class);
    
    public final BooleanPath contractRequired = createBoolean("contractRequired");
    
    public final BooleanPath db = createBoolean("db");
    
    public final uk.ac.reigate.domain.ilr.QDestination destination;
    
    public final StringPath destinationCollegeEmployer = createString("destinationCollegeEmployer");
    
    public final StringPath destinationCourseCareer = createString("destinationCourseCareer");
    
    public final BooleanPath ehc = createBoolean("ehc");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.ilr.QEnglishConditionOfFunding englishConditionOfFunding;
    
    public final BooleanPath externalCandidate = createBoolean("externalCandidate");
    
    public final BooleanPath freeMealsEligibility = createBoolean("freeMealsEligibility");
    
    public final BooleanPath gb = createBoolean("gb");
    
    public final StringPath gcseEnglishGrade = createString("gcseEnglishGrade");
    
    public final StringPath gcseMathsGrade = createString("gcseMathsGrade");
    
    public final BooleanPath hns = createBoolean("hns");
    
    public final BooleanPath ilr = createBoolean("ilr");
    
    public final uk.ac.reigate.domain.QStaff inductionInterviewer;
    
    public final StringPath initialPostcode = createString("initialPostcode");
    
    public final BooleanPath largerThanAdvisedProgramme = createBoolean("largerThanAdvisedProgramme");
    
    public final BooleanPath lda = createBoolean("lda");
    
    public final NumberPath<Integer> learningSupportCost = createNumber("learningSupportCost", Integer.class);
    
    public final uk.ac.reigate.domain.ilr.QMathsConditionOfFunding mathsConditionOfFunding;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final BooleanPath onContract = createBoolean("onContract");
    
    public final BooleanPath onMentoring = createBoolean("onMentoring");
    
    public final uk.ac.reigate.domain.QStaff pastoralMonitor;
    
    public final NumberPath<Integer> peeph = createNumber("peeph", Integer.class);
    
    public final NumberPath<Integer> plh = createNumber("plh", Integer.class);
    
    public final BooleanPath punctualityMonitorable = createBoolean("punctualityMonitorable");
    
    public final uk.ac.reigate.domain.lookup.QPunctualityMonitoring punctualityMonitoring;
    
    public final BooleanPath receivingFreeMeals = createBoolean("receivingFreeMeals");
    
    public final BooleanPath removedFromFreeMeals = createBoolean("removedFromFreeMeals");
    
    public final BooleanPath sen = createBoolean("sen");
    
    public final BooleanPath socialWorker = createBoolean("socialWorker");
    
    public final BooleanPath starAdviceGiven = createBoolean("starAdviceGiven");
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QStudent student;
    
    public final uk.ac.reigate.domain.lookup.QStudentType studentType;
    
    public final uk.ac.reigate.domain.lookup.QTutorGroup tutorGroup;
    
    public final DateTimePath<java.util.Date> withdrawnDate = createDateTime("withdrawnDate", java.util.Date.class);
    
    public final QAcademicYear year;
    
    public QStudentYear(
        String variable) {
        this(StudentYear.class, forVariable(variable), INITS);
    }
    
    public QStudentYear(
        Path<? extends StudentYear> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentYear(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentYear(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentYear.class, metadata, inits);
    }
    
    public QStudentYear(
        Class<? extends StudentYear> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.attendanceMonitoring = inits.isInitialized("attendanceMonitoring") ? new uk.ac.reigate.domain.lookup.QAttendanceMonitoring(forProperty("attendanceMonitoring")) : null;
        this.bursaryType = inits.isInitialized("bursaryType") ? new uk.ac.reigate.domain.lookup.QBursaryType(forProperty("bursaryType")) : null;
        this.destination = inits.isInitialized("destination") ? new uk.ac.reigate.domain.ilr.QDestination(forProperty("destination")) : null;
        this.englishConditionOfFunding = inits.isInitialized("englishConditionOfFunding") ? new uk.ac.reigate.domain.ilr.QEnglishConditionOfFunding(forProperty("englishConditionOfFunding")) : null;
        this.inductionInterviewer = inits.isInitialized("inductionInterviewer") ? new uk.ac.reigate.domain.QStaff(forProperty("inductionInterviewer"), inits.get("inductionInterviewer")) : null;
        this.mathsConditionOfFunding = inits.isInitialized("mathsConditionOfFunding") ? new uk.ac.reigate.domain.ilr.QMathsConditionOfFunding(forProperty("mathsConditionOfFunding")) : null;
        this.pastoralMonitor = inits.isInitialized("pastoralMonitor") ? new uk.ac.reigate.domain.QStaff(forProperty("pastoralMonitor"), inits.get("pastoralMonitor")) : null;
        this.punctualityMonitoring = inits.isInitialized("punctualityMonitoring") ? new uk.ac.reigate.domain.lookup.QPunctualityMonitoring(forProperty("punctualityMonitoring")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.studentType = inits.isInitialized("studentType") ? new uk.ac.reigate.domain.lookup.QStudentType(forProperty("studentType")) : null;
        this.tutorGroup = inits.isInitialized("tutorGroup") ? new uk.ac.reigate.domain.lookup.QTutorGroup(forProperty("tutorGroup"), inits.get("tutorGroup")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
