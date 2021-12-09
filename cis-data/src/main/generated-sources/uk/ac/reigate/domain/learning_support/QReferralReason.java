package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QReferralReason is a Querydsl query type for ReferralReason
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReferralReason extends EntityPathBase<ReferralReason> {
    
    private static final long serialVersionUID = -1180346472L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QReferralReason referralReason = new QReferralReason("referralReason");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final uk.ac.reigate.domain.ilr.QLLDDHealthProblemCategory llddHealthProblemCategory;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath reason = createString("reason");
    
    public QReferralReason(
        String variable) {
        this(ReferralReason.class, forVariable(variable), INITS);
    }
    
    public QReferralReason(
        Path<? extends ReferralReason> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QReferralReason(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QReferralReason(
        PathMetadata metadata,
        PathInits inits) {
        this(ReferralReason.class, metadata, inits);
    }
    
    public QReferralReason(
        Class<? extends ReferralReason> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.llddHealthProblemCategory = inits.isInitialized("llddHealthProblemCategory") ? new uk.ac.reigate.domain.ilr.QLLDDHealthProblemCategory(forProperty("llddHealthProblemCategory")) : null;
    }
    
}
