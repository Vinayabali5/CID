package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QDestination is a Querydsl query type for Destination
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDestination extends EntityPathBase<Destination> {
    
    private static final long serialVersionUID = 705071910L;
    
    public static final QDestination destination = new QDestination("destination");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath shortDescription = createString("shortDescription");
    
    public final StringPath type = createString("type");
    
    public final DateTimePath<java.util.Date> validFrom = createDateTime("validFrom", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> validTo = createDateTime("validTo", java.util.Date.class);
    
    public QDestination(
        String variable) {
        super(Destination.class, forVariable(variable));
    }
    
    public QDestination(
        Path<? extends Destination> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QDestination(
        PathMetadata metadata) {
        super(Destination.class, metadata);
    }
    
}
