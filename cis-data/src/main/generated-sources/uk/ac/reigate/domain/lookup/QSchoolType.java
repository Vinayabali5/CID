package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QSchoolType is a Querydsl query type for SchoolType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchoolType extends EntityPathBase<SchoolType> {
    
    private static final long serialVersionUID = 1836090137L;
    
    public static final QSchoolType schoolType = new QSchoolType("schoolType");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QSchoolType(
        String variable) {
        super(SchoolType.class, forVariable(variable));
    }
    
    public QSchoolType(
        Path<? extends SchoolType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QSchoolType(
        PathMetadata metadata) {
        super(SchoolType.class, metadata);
    }
    
}
