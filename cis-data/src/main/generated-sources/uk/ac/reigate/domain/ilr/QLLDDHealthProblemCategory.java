package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QLLDDHealthProblemCategory is a Querydsl query type for LLDDHealthProblemCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLLDDHealthProblemCategory extends EntityPathBase<LLDDHealthProblemCategory> {
    
    private static final long serialVersionUID = 1956807129L;
    
    public static final QLLDDHealthProblemCategory lLDDHealthProblemCategory = new QLLDDHealthProblemCategory("lLDDHealthProblemCategory");
    
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
    
    public final DateTimePath<java.util.Date> validFrom = createDateTime("validFrom", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> validTo = createDateTime("validTo", java.util.Date.class);
    
    public QLLDDHealthProblemCategory(
        String variable) {
        super(LLDDHealthProblemCategory.class, forVariable(variable));
    }
    
    public QLLDDHealthProblemCategory(
        Path<? extends LLDDHealthProblemCategory> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QLLDDHealthProblemCategory(
        PathMetadata metadata) {
        super(LLDDHealthProblemCategory.class, metadata);
    }
    
}
