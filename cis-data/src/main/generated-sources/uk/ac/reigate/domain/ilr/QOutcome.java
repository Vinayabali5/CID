package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QOutcome is a Querydsl query type for Outcome
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOutcome extends EntityPathBase<Outcome> {
    
    private static final long serialVersionUID = -1275356566L;
    
    public static final QOutcome outcome = new QOutcome("outcome");
    
    public final QILREntity _super = new QILREntity(this);
    
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
    
    public QOutcome(
        String variable) {
        super(Outcome.class, forVariable(variable));
    }
    
    public QOutcome(
        Path<? extends Outcome> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QOutcome(
        PathMetadata metadata) {
        super(Outcome.class, metadata);
    }
    
}
