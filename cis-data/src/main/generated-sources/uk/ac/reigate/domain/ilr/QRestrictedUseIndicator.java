package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QRestrictedUseIndicator is a Querydsl query type for RestrictedUseIndicator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRestrictedUseIndicator extends EntityPathBase<RestrictedUseIndicator> {
    
    private static final long serialVersionUID = -1930631637L;
    
    public static final QRestrictedUseIndicator restrictedUseIndicator = new QRestrictedUseIndicator("restrictedUseIndicator");
    
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
    
    public QRestrictedUseIndicator(
        String variable) {
        super(RestrictedUseIndicator.class, forVariable(variable));
    }
    
    public QRestrictedUseIndicator(
        Path<? extends RestrictedUseIndicator> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QRestrictedUseIndicator(
        PathMetadata metadata) {
        super(RestrictedUseIndicator.class, metadata);
    }
    
}
