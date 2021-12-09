package uk.ac.reigate.domain.interimreport;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentInterimReport is a Querydsl query type for StudentInterimReport
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentInterimReport extends EntityPathBase<StudentInterimReport> {
    
    private static final long serialVersionUID = -781958372L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentInterimReport studentInterimReport = new QStudentInterimReport("studentInterimReport");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final NumberPath<Integer> absence = createNumber("absence", Integer.class);
    
    public final NumberPath<Double> AdjustedAttendance = createNumber("AdjustedAttendance", Double.class);
    
    public final NumberPath<Double> adjustedAttendance = createNumber("adjustedAttendance", Double.class);
    
    public final NumberPath<Double> Attendance = createNumber("Attendance", Double.class);
    
    public final NumberPath<Double> attendance = createNumber("attendance", Double.class);
    
    public final NumberPath<Integer> authorisedAbsence = createNumber("authorisedAbsence", Integer.class);
    
    public final uk.ac.reigate.domain.cristal.QInterimReportEffortGrade classEthic;
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final uk.ac.reigate.domain.lookup.QPossibleGrade currentPredictedGrade;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final QInterimReport interimReport;
    
    public final uk.ac.reigate.domain.lookup.QPossibleGrade keyAssessment1;
    
    public final uk.ac.reigate.domain.lookup.QPossibleGrade keyAssessment2;
    
    public final uk.ac.reigate.domain.lookup.QPossibleGrade keyAssessment3;
    
    public final NumberPath<Integer> late = createNumber("late", Integer.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.cristal.QInterimReportEffortGrade motivation;
    
    public final NumberPath<Double> Punctuality = createNumber("Punctuality", Double.class);
    
    public final NumberPath<Double> punctuality = createNumber("punctuality", Double.class);
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final uk.ac.reigate.domain.cristal.QInterimReportEffortGrade timeManagement;
    
    public final NumberPath<Integer> totalPossible = createNumber("totalPossible", Integer.class);
    
    public QStudentInterimReport(
        String variable) {
        this(StudentInterimReport.class, forVariable(variable), INITS);
    }
    
    public QStudentInterimReport(
        Path<? extends StudentInterimReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentInterimReport(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentInterimReport(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentInterimReport.class, metadata, inits);
    }
    
    public QStudentInterimReport(
        Class<? extends StudentInterimReport> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.classEthic = inits.isInitialized("classEthic") ? new uk.ac.reigate.domain.cristal.QInterimReportEffortGrade(forProperty("classEthic")) : null;
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.currentPredictedGrade = inits.isInitialized("currentPredictedGrade") ? new uk.ac.reigate.domain.lookup.QPossibleGrade(forProperty("currentPredictedGrade"), inits.get("currentPredictedGrade")) : null;
        this.interimReport = inits.isInitialized("interimReport") ? new QInterimReport(forProperty("interimReport"), inits.get("interimReport")) : null;
        this.keyAssessment1 = inits.isInitialized("keyAssessment1") ? new uk.ac.reigate.domain.lookup.QPossibleGrade(forProperty("keyAssessment1"), inits.get("keyAssessment1")) : null;
        this.keyAssessment2 = inits.isInitialized("keyAssessment2") ? new uk.ac.reigate.domain.lookup.QPossibleGrade(forProperty("keyAssessment2"), inits.get("keyAssessment2")) : null;
        this.keyAssessment3 = inits.isInitialized("keyAssessment3") ? new uk.ac.reigate.domain.lookup.QPossibleGrade(forProperty("keyAssessment3"), inits.get("keyAssessment3")) : null;
        this.motivation = inits.isInitialized("motivation") ? new uk.ac.reigate.domain.cristal.QInterimReportEffortGrade(forProperty("motivation")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.timeManagement = inits.isInitialized("timeManagement") ? new uk.ac.reigate.domain.cristal.QInterimReportEffortGrade(forProperty("timeManagement")) : null;
    }
    
}
