package uk.ac.reigate.domain.exams.edi;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStatusType is a Querydsl query type for StatusType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatusType extends EntityPathBase<StatusType> {
    
    private static final long serialVersionUID = -1916194925L;
    
    public static final QStatusType statusType = new QStatusType("statusType");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QStatusType(
        String variable) {
        super(StatusType.class, forVariable(variable));
    }
    
    public QStatusType(
        Path<? extends StatusType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStatusType(
        PathMetadata metadata) {
        super(StatusType.class, metadata);
    }
    
}
