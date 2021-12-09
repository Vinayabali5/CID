package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCodedEntity is a Querydsl query type for CodedEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCodedEntity extends EntityPathBase<CodedEntity> {
    
    private static final long serialVersionUID = -1321906895L;
    
    public static final QCodedEntity codedEntity = new QCodedEntity("codedEntity");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final StringPath code = createString("code");
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QCodedEntity(
        String variable) {
        super(CodedEntity.class, forVariable(variable));
    }
    
    public QCodedEntity(
        Path<? extends CodedEntity> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCodedEntity(
        PathMetadata metadata) {
        super(CodedEntity.class, metadata);
    }
    
}
