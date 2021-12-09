package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QPersonAlias is a Querydsl query type for PersonAlias
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonAlias extends EntityPathBase<PersonAlias> {
    
    private static final long serialVersionUID = 157282898L;
    
    public static final QPersonAlias personAlias = new QPersonAlias("personAlias");
    
    public final StringPath aliasUsername = createString("aliasUsername");
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final StringPath personUsername = createString("personUsername");
    
    public QPersonAlias(
        String variable) {
        super(PersonAlias.class, forVariable(variable));
    }
    
    public QPersonAlias(
        Path<? extends PersonAlias> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QPersonAlias(
        PathMetadata metadata) {
        super(PersonAlias.class, metadata);
    }
    
}
