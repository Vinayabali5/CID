package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QInitialAssessmentLevel is a Querydsl query type for InitialAssessmentLevel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInitialAssessmentLevel extends EntityPathBase<InitialAssessmentLevel> {
    
    private static final long serialVersionUID = 1678626389L;
    
    public static final QInitialAssessmentLevel initialAssessmentLevel1 = new QInitialAssessmentLevel("initialAssessmentLevel1");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    public final StringPath abbrv = createString("abbrv");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath initialAssessmentLevel = createString("initialAssessmentLevel");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QInitialAssessmentLevel(
        String variable) {
        super(InitialAssessmentLevel.class, forVariable(variable));
    }
    
    public QInitialAssessmentLevel(
        Path<? extends InitialAssessmentLevel> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QInitialAssessmentLevel(
        PathMetadata metadata) {
        super(InitialAssessmentLevel.class, metadata);
    }
    
}
