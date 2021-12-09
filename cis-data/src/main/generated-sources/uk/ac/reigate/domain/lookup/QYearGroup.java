package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QYearGroup is a Querydsl query type for YearGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QYearGroup extends EntityPathBase<YearGroup> {
    
    private static final long serialVersionUID = 668575895L;
    
    public static final QYearGroup yearGroup = new QYearGroup("yearGroup");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final BooleanPath excludeTTCheck = createBoolean("excludeTTCheck");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QYearGroup(
        String variable) {
        super(YearGroup.class, forVariable(variable));
    }
    
    public QYearGroup(
        Path<? extends YearGroup> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QYearGroup(
        PathMetadata metadata) {
        super(YearGroup.class, metadata);
    }
    
}
