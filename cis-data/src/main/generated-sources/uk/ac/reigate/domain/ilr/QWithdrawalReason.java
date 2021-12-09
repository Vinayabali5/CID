package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QWithdrawalReason is a Querydsl query type for WithdrawalReason
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWithdrawalReason extends EntityPathBase<WithdrawalReason> {
    
    private static final long serialVersionUID = 1464616769L;
    
    public static final QWithdrawalReason withdrawalReason = new QWithdrawalReason("withdrawalReason");
    
    public final QILREntityNoIdentity _super = new QILREntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    // inherited
    public final StringPath shortDescription = _super.shortDescription;
    
    // inherited
    public final DateTimePath<java.util.Date> validFrom = _super.validFrom;
    
    // inherited
    public final DateTimePath<java.util.Date> validTo = _super.validTo;
    
    public QWithdrawalReason(
        String variable) {
        super(WithdrawalReason.class, forVariable(variable));
    }
    
    public QWithdrawalReason(
        Path<? extends WithdrawalReason> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QWithdrawalReason(
        PathMetadata metadata) {
        super(WithdrawalReason.class, metadata);
    }
    
}
