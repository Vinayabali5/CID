package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QDisability is a Querydsl query type for Disability
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDisability extends EntityPathBase<Disability> {
    
    private static final long serialVersionUID = 310821043L;
    
    public static final QDisability disability1 = new QDisability("disability1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath disability = createString("disability");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QDisability(
        String variable) {
        super(Disability.class, forVariable(variable));
    }
    
    public QDisability(
        Path<? extends Disability> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QDisability(
        PathMetadata metadata) {
        super(Disability.class, metadata);
    }
    
}
