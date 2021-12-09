package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentSpecialCategory is a Querydsl query type for StudentSpecialCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentSpecialCategory extends EntityPathBase<StudentSpecialCategory> {
    
    private static final long serialVersionUID = -1989824141L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentSpecialCategory studentSpecialCategory = new QStudentSpecialCategory("studentSpecialCategory");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> classificationDate = createDateTime("classificationDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> closedDate = createDateTime("closedDate", java.util.Date.class);
    
    public final StringPath emergencyContactNos = createString("emergencyContactNos");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath inEventEmergency = createString("inEventEmergency");
    
    public final BooleanPath informationConfidential = createBoolean("informationConfidential");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath monitoringNotes = createString("monitoringNotes");
    
    public final StringPath outsideAgenciesInvolved = createString("outsideAgenciesInvolved");
    
    public final BooleanPath passToStaffConcerned = createBoolean("passToStaffConcerned");
    
    public final DateTimePath<java.util.Date> requestDate = createDateTime("requestDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.QStaff riskAssessmentCarriedOutBy;
    
    public final DateTimePath<java.util.Date> riskAssessmentCarriedOutDate = createDateTime("riskAssessmentCarriedOutDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.QStaff riskAssessmentRaisedBy;
    
    public final DateTimePath<java.util.Date> riskAssessmentRaisedDate = createDateTime("riskAssessmentRaisedDate", java.util.Date.class);
    
    public final BooleanPath riskAssessmentRequired = createBoolean("riskAssessmentRequired");
    
    public final uk.ac.reigate.domain.QStaff riskAssessmentToBeCompletedBy;
    
    public final StringPath riskToStudentOrOthers = createString("riskToStudentOrOthers");
    
    public final uk.ac.reigate.domain.academic.QSpecialCategory specialCategory;
    
    public final BooleanPath specialConfirmed = createBoolean("specialConfirmed");
    
    public final uk.ac.reigate.domain.QStaff staffConcerned;
    
    public final uk.ac.reigate.domain.QStaff staffRequesting;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath toBeInformedPotentialRisks = createString("toBeInformedPotentialRisks");
    
    public final BooleanPath writtenEvidence = createBoolean("writtenEvidence");
    
    public QStudentSpecialCategory(
        String variable) {
        this(StudentSpecialCategory.class, forVariable(variable), INITS);
    }
    
    public QStudentSpecialCategory(
        Path<? extends StudentSpecialCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentSpecialCategory(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentSpecialCategory(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentSpecialCategory.class, metadata, inits);
    }
    
    public QStudentSpecialCategory(
        Class<? extends StudentSpecialCategory> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.riskAssessmentCarriedOutBy = inits.isInitialized("riskAssessmentCarriedOutBy") ? new uk.ac.reigate.domain.QStaff(forProperty("riskAssessmentCarriedOutBy"), inits.get("riskAssessmentCarriedOutBy")) : null;
        this.riskAssessmentRaisedBy = inits.isInitialized("riskAssessmentRaisedBy") ? new uk.ac.reigate.domain.QStaff(forProperty("riskAssessmentRaisedBy"), inits.get("riskAssessmentRaisedBy")) : null;
        this.riskAssessmentToBeCompletedBy = inits.isInitialized("riskAssessmentToBeCompletedBy") ? new uk.ac.reigate.domain.QStaff(forProperty("riskAssessmentToBeCompletedBy"), inits.get("riskAssessmentToBeCompletedBy")) : null;
        this.specialCategory = inits.isInitialized("specialCategory") ? new uk.ac.reigate.domain.academic.QSpecialCategory(forProperty("specialCategory")) : null;
        this.staffConcerned = inits.isInitialized("staffConcerned") ? new uk.ac.reigate.domain.QStaff(forProperty("staffConcerned"), inits.get("staffConcerned")) : null;
        this.staffRequesting = inits.isInitialized("staffRequesting") ? new uk.ac.reigate.domain.QStaff(forProperty("staffRequesting"), inits.get("staffRequesting")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
