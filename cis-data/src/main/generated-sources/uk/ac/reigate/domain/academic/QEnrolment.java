package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEnrolment is a Querydsl query type for Enrolment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnrolment extends EntityPathBase<Enrolment> {
    
    private static final long serialVersionUID = -890347450L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QEnrolment enrolment = new QEnrolment("enrolment");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.ilr.QAimType aimType;
    
    public final uk.ac.reigate.domain.lookup.QCentralMonitoring centralMonitoring;
    
    public final uk.ac.reigate.domain.ilr.QCompletionStatus completionStatus;
    
    public final QCourse course;
    
    public final QCourseGroup courseGroup;
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.ilr.QFundingModel fundingModel;
    
    public final StringPath grade = createString("grade");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath ilr = createBoolean("ilr");
    
    public final StringPath learningAimReferenceOverride = createString("learningAimReferenceOverride");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath notes = createString("notes");
    
    public final uk.ac.reigate.domain.ilr.QOutcome outcome;
    
    public final NumberPath<Integer> peeph = createNumber("peeph", Integer.class);
    
    public final DateTimePath<java.util.Date> plannedEndDate = createDateTime("plannedEndDate", java.util.Date.class);
    
    public final NumberPath<Integer> plh = createNumber("plh", Integer.class);
    
    public final DateTimePath<java.util.Date> qualificationStartDate = createDateTime("qualificationStartDate", java.util.Date.class);
    
    public final QPreReference reference;
    
    public final uk.ac.reigate.domain.ilr.QSourceOfFunding sourceOfFunding;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QStudent student;
    
    public final uk.ac.reigate.domain.ilr.QWithdrawalReason withdrawalReason;
    
    public final QAcademicYear year;
    
    public QEnrolment(
        String variable) {
        this(Enrolment.class, forVariable(variable), INITS);
    }
    
    public QEnrolment(
        Path<? extends Enrolment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QEnrolment(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QEnrolment(
        PathMetadata metadata,
        PathInits inits) {
        this(Enrolment.class, metadata, inits);
    }
    
    public QEnrolment(
        Class<? extends Enrolment> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.aimType = inits.isInitialized("aimType") ? new uk.ac.reigate.domain.ilr.QAimType(forProperty("aimType")) : null;
        this.centralMonitoring = inits.isInitialized("centralMonitoring") ? new uk.ac.reigate.domain.lookup.QCentralMonitoring(forProperty("centralMonitoring")) : null;
        this.completionStatus = inits.isInitialized("completionStatus") ? new uk.ac.reigate.domain.ilr.QCompletionStatus(forProperty("completionStatus")) : null;
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.fundingModel = inits.isInitialized("fundingModel") ? new uk.ac.reigate.domain.ilr.QFundingModel(forProperty("fundingModel")) : null;
        this.outcome = inits.isInitialized("outcome") ? new uk.ac.reigate.domain.ilr.QOutcome(forProperty("outcome")) : null;
        this.reference = inits.isInitialized("reference") ? new QPreReference(forProperty("reference"), inits.get("reference")) : null;
        this.sourceOfFunding = inits.isInitialized("sourceOfFunding") ? new uk.ac.reigate.domain.ilr.QSourceOfFunding(forProperty("sourceOfFunding")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.withdrawalReason = inits.isInitialized("withdrawalReason") ? new uk.ac.reigate.domain.ilr.QWithdrawalReason(forProperty("withdrawalReason")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
