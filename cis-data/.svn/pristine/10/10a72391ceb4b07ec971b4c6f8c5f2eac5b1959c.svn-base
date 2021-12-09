package uk.ac.reigate.domain.risk_assessment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentRiskLevel is a Querydsl query type for StudentRiskLevel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentRiskLevel extends EntityPathBase<StudentRiskLevel> {
    
    private static final long serialVersionUID = -1761217L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentRiskLevel studentRiskLevel = new QStudentRiskLevel("studentRiskLevel");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath confidential = createBoolean("confidential");
    
    public final DateTimePath<java.util.Date> dateForReview = createDateTime("dateForReview", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> dateRequested = createDateTime("dateRequested", java.util.Date.class);
    
    public final BooleanPath evidence = createBoolean("evidence");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath riskAssessmentRequired = createBoolean("riskAssessmentRequired");
    
    public final QRiskLevel riskLevel;
    
    public final StringPath riskNotes = createString("riskNotes");
    
    public final BooleanPath safetyPlanRequired = createBoolean("safetyPlanRequired");
    
    public final uk.ac.reigate.domain.QStaff staffRequesting;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentRiskLevel(
        String variable) {
        this(StudentRiskLevel.class, forVariable(variable), INITS);
    }
    
    public QStudentRiskLevel(
        Path<? extends StudentRiskLevel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentRiskLevel(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentRiskLevel(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentRiskLevel.class, metadata, inits);
    }
    
    public QStudentRiskLevel(
        Class<? extends StudentRiskLevel> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.riskLevel = inits.isInitialized("riskLevel") ? new QRiskLevel(forProperty("riskLevel")) : null;
        this.staffRequesting = inits.isInitialized("staffRequesting") ? new uk.ac.reigate.domain.QStaff(forProperty("staffRequesting"), inits.get("staffRequesting")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
