package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QConcessionType is a Querydsl query type for ConcessionType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcessionType extends EntityPathBase<ConcessionType> {
    
    private static final long serialVersionUID = -265666699L;
    
    public static final QConcessionType concessionType = new QConcessionType("concessionType");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath onExamTimetable = createBoolean("onExamTimetable");
    
    public QConcessionType(
        String variable) {
        super(ConcessionType.class, forVariable(variable));
    }
    
    public QConcessionType(
        Path<? extends ConcessionType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QConcessionType(
        PathMetadata metadata) {
        super(ConcessionType.class, metadata);
    }
    
}
