package uk.ac.reigate.domain.risk_assessment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentSafetyPlan is a Querydsl query type for StudentSafetyPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentSafetyPlan extends EntityPathBase<StudentSafetyPlan> {
    
    private static final long serialVersionUID = 274380817L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentSafetyPlan studentSafetyPlan = new QStudentSafetyPlan("studentSafetyPlan");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    public final StringPath actionsToCalmAndSoothe = createString("actionsToCalmAndSoothe");
    
    public final uk.ac.reigate.domain.QStaff completedWith;
    
    public final DateTimePath<java.util.Date> dateCompleted = createDateTime("dateCompleted", java.util.Date.class);
    
    public final StringPath howToReduceRiskAtHome = createString("howToReduceRiskAtHome");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath pastActionsToHelp = createString("pastActionsToHelp");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath warningSignsOrTriggers = createString("warningSignsOrTriggers");
    
    public final StringPath whatCouldOthersDo = createString("whatCouldOthersDo");
    
    public final StringPath whatToTellSelf = createString("whatToTellSelf");
    
    public final StringPath whoCanICall = createString("whoCanICall");
    
    public final StringPath whoWouldbeSaidToFriend = createString("whoWouldbeSaidToFriend");
    
    public QStudentSafetyPlan(
        String variable) {
        this(StudentSafetyPlan.class, forVariable(variable), INITS);
    }
    
    public QStudentSafetyPlan(
        Path<? extends StudentSafetyPlan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentSafetyPlan(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentSafetyPlan(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentSafetyPlan.class, metadata, inits);
    }
    
    public QStudentSafetyPlan(
        Class<? extends StudentSafetyPlan> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.completedWith = inits.isInitialized("completedWith") ? new uk.ac.reigate.domain.QStaff(forProperty("completedWith"), inits.get("completedWith")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
