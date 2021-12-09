package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QILPInterviewType is a Querydsl query type for ILPInterviewType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QILPInterviewType extends EntityPathBase<ILPInterviewType> {
    
    private static final long serialVersionUID = 267947352L;
    
    public static final QILPInterviewType iLPInterviewType = new QILPInterviewType("iLPInterviewType");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath allowEmailRelatedStaff = createBoolean("allowEmailRelatedStaff");
    
    public final BooleanPath allowLipReferral = createBoolean("allowLipReferral");
    
    public final BooleanPath allowOfficeAction = createBoolean("allowOfficeAction");
    
    public final BooleanPath defaultToPrivate = createBoolean("defaultToPrivate");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath requireCourseGroupId = createBoolean("requireCourseGroupId");
    
    public final BooleanPath requireTarget = createBoolean("requireTarget");
    
    public final StringPath type = createString("type");
    
    public QILPInterviewType(
        String variable) {
        super(ILPInterviewType.class, forVariable(variable));
    }
    
    public QILPInterviewType(
        Path<? extends ILPInterviewType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QILPInterviewType(
        PathMetadata metadata) {
        super(ILPInterviewType.class, metadata);
    }
    
}
