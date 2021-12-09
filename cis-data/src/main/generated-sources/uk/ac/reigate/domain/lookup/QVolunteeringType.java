package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QVolunteeringType is a Querydsl query type for VolunteeringType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVolunteeringType extends EntityPathBase<VolunteeringType> {
    
    private static final long serialVersionUID = 900041085L;
    
    public static final QVolunteeringType volunteeringType = new QVolunteeringType("volunteeringType");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QVolunteeringType(
        String variable) {
        super(VolunteeringType.class, forVariable(variable));
    }
    
    public QVolunteeringType(
        Path<? extends VolunteeringType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QVolunteeringType(
        PathMetadata metadata) {
        super(VolunteeringType.class, metadata);
    }
    
}
