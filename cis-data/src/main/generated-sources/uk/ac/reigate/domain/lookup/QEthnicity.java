package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QEthnicity is a Querydsl query type for Ethnicity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEthnicity extends EntityPathBase<Ethnicity> {
    
    private static final long serialVersionUID = 369299668L;
    
    public static final QEthnicity ethnicity = new QEthnicity("ethnicity");
    
    public final uk.ac.reigate.domain.ilr.QILREntity _super = new uk.ac.reigate.domain.ilr.QILREntity(this);
    
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
    
    public QEthnicity(
        String variable) {
        super(Ethnicity.class, forVariable(variable));
    }
    
    public QEthnicity(
        Path<? extends Ethnicity> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QEthnicity(
        PathMetadata metadata) {
        super(Ethnicity.class, metadata);
    }
    
}
