package uk.ac.reigate.domain.risk_assessment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentRiskAssessment is a Querydsl query type for StudentRiskAssessment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentRiskAssessment extends EntityPathBase<StudentRiskAssessment> {
    
    private static final long serialVersionUID = -1522766105L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentRiskAssessment studentRiskAssessment = new QStudentRiskAssessment("studentRiskAssessment");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    public final StringPath actionsToMinimiseRisk = createString("actionsToMinimiseRisk");
    
    public final StringPath agencyContactDetails = createString("agencyContactDetails");
    
    public final uk.ac.reigate.domain.QStaff completeByStaff;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath otherAgenciesInvolved = createString("otherAgenciesInvolved");
    
    public final StringPath riskToOtherStudents = createString("riskToOtherStudents");
    
    public final StringPath riskToStaff = createString("riskToStaff");
    
    public final StringPath riskToStudent = createString("riskToStudent");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath whoToInform = createString("whoToInform");
    
    public QStudentRiskAssessment(
        String variable) {
        this(StudentRiskAssessment.class, forVariable(variable), INITS);
    }
    
    public QStudentRiskAssessment(
        Path<? extends StudentRiskAssessment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentRiskAssessment(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentRiskAssessment(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentRiskAssessment.class, metadata, inits);
    }
    
    public QStudentRiskAssessment(
        Class<? extends StudentRiskAssessment> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.completeByStaff = inits.isInitialized("completeByStaff") ? new uk.ac.reigate.domain.QStaff(forProperty("completeByStaff"), inits.get("completeByStaff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
