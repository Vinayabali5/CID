package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentReferralReason is a Querydsl query type for StudentReferralReason
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentReferralReason extends EntityPathBase<StudentReferralReason> {
    
    private static final long serialVersionUID = -1109101531L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentReferralReason studentReferralReason = new QStudentReferralReason("studentReferralReason");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath primary = createBoolean("primary");
    
    public final QReferralReason referralReason;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentReferralReason(
        String variable) {
        this(StudentReferralReason.class, forVariable(variable), INITS);
    }
    
    public QStudentReferralReason(
        Path<? extends StudentReferralReason> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentReferralReason(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentReferralReason(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentReferralReason.class, metadata, inits);
    }
    
    public QStudentReferralReason(
        Class<? extends StudentReferralReason> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.referralReason = inits.isInitialized("referralReason") ? new QReferralReason(forProperty("referralReason"), inits.get("referralReason")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
