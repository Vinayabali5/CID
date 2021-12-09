package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QNamedEntity is a Querydsl query type for NamedEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QNamedEntity extends EntityPathBase<NamedEntity> {
    
    private static final long serialVersionUID = -244534573L;
    
    public static final QNamedEntity namedEntity = new QNamedEntity("namedEntity");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public QNamedEntity(
        String variable) {
        super(NamedEntity.class, forVariable(variable));
    }
    
    public QNamedEntity(
        Path<? extends NamedEntity> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QNamedEntity(
        PathMetadata metadata) {
        super(NamedEntity.class, metadata);
    }
    
}
