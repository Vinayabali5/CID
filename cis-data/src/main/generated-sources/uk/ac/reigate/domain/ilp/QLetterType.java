package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QLetterType is a Querydsl query type for LetterType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLetterType extends EntityPathBase<LetterType> {
    
    private static final long serialVersionUID = 239718314L;
    
    public static final QLetterType letterType = new QLetterType("letterType");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath requireAuthorisation = createBoolean("requireAuthorisation");
    
    public final BooleanPath requireTarget = createBoolean("requireTarget");
    
    public final StringPath type = createString("type");
    
    public QLetterType(
        String variable) {
        super(LetterType.class, forVariable(variable));
    }
    
    public QLetterType(
        Path<? extends LetterType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QLetterType(
        PathMetadata metadata) {
        super(LetterType.class, metadata);
    }
    
}
