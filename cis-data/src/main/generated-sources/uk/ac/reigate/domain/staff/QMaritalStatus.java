package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QMaritalStatus is a Querydsl query type for MaritalStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaritalStatus extends EntityPathBase<MaritalStatus> {
    
    private static final long serialVersionUID = 704259791L;
    
    public static final QMaritalStatus maritalStatus1 = new QMaritalStatus("maritalStatus1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath maritalStatus = createString("maritalStatus");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QMaritalStatus(
        String variable) {
        super(MaritalStatus.class, forVariable(variable));
    }
    
    public QMaritalStatus(
        Path<? extends MaritalStatus> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QMaritalStatus(
        PathMetadata metadata) {
        super(MaritalStatus.class, metadata);
    }
    
}
