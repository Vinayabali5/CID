package uk.ac.reigate.domain.security;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {
    
    private static final long serialVersionUID = 1316024123L;
    
    public static final QRole role = new QRole("role");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath authority = createString("authority");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath roleDescription = createString("roleDescription");
    
    public final StringPath roleName = createString("roleName");
    
    public final SetPath<uk.ac.reigate.domain.Person, uk.ac.reigate.domain.QPerson> users = this.<uk.ac.reigate.domain.Person, uk.ac.reigate.domain.QPerson> createSet("users", uk.ac.reigate.domain.Person.class, uk.ac.reigate.domain.QPerson.class, PathInits.DIRECT2);
    
    public QRole(
        String variable) {
        super(Role.class, forVariable(variable));
    }
    
    public QRole(
        Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QRole(
        PathMetadata metadata) {
        super(Role.class, metadata);
    }
    
}
