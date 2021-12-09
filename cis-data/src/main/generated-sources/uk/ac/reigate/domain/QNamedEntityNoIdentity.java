package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QNamedEntityNoIdentity is a Querydsl query type for NamedEntityNoIdentity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QNamedEntityNoIdentity extends EntityPathBase<NamedEntityNoIdentity> {
    
    private static final long serialVersionUID = -1962609454L;
    
    public static final QNamedEntityNoIdentity namedEntityNoIdentity = new QNamedEntityNoIdentity("namedEntityNoIdentity");
    
    public final QBaseEntityNoIdentity _super = new QBaseEntityNoIdentity(this);
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public QNamedEntityNoIdentity(
        String variable) {
        super(NamedEntityNoIdentity.class, forVariable(variable));
    }
    
    public QNamedEntityNoIdentity(
        Path<? extends NamedEntityNoIdentity> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QNamedEntityNoIdentity(
        PathMetadata metadata) {
        super(NamedEntityNoIdentity.class, metadata);
    }
    
}
