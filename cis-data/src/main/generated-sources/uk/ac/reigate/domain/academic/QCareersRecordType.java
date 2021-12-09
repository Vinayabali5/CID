package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCareersRecordType is a Querydsl query type for CareersRecordType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCareersRecordType extends EntityPathBase<CareersRecordType> {
    
    private static final long serialVersionUID = -1974304478L;
    
    public static final QCareersRecordType careersRecordType = new QCareersRecordType("careersRecordType");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QCareersRecordType(
        String variable) {
        super(CareersRecordType.class, forVariable(variable));
    }
    
    public QCareersRecordType(
        Path<? extends CareersRecordType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCareersRecordType(
        PathMetadata metadata) {
        super(CareersRecordType.class, metadata);
    }
    
}
