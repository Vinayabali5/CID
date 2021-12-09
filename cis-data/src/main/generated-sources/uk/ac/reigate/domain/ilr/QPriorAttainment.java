package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QPriorAttainment is a Querydsl query type for PriorAttainment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPriorAttainment extends EntityPathBase<PriorAttainment> {
    
    private static final long serialVersionUID = 835719013L;
    
    public static final QPriorAttainment priorAttainment = new QPriorAttainment("priorAttainment");
    
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
    
    public QPriorAttainment(
        String variable) {
        super(PriorAttainment.class, forVariable(variable));
    }
    
    public QPriorAttainment(
        Path<? extends PriorAttainment> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QPriorAttainment(
        PathMetadata metadata) {
        super(PriorAttainment.class, metadata);
    }
    
}
