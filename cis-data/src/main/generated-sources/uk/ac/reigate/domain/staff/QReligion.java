package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QReligion is a Querydsl query type for Religion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReligion extends EntityPathBase<Religion> {
    
    private static final long serialVersionUID = -1904082232L;
    
    public static final QReligion religion1 = new QReligion("religion1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath religion = createString("religion");
    
    public QReligion(
        String variable) {
        super(Religion.class, forVariable(variable));
    }
    
    public QReligion(
        Path<? extends Religion> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QReligion(
        PathMetadata metadata) {
        super(Religion.class, metadata);
    }
    
}
