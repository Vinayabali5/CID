package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPossibleGrade is a Querydsl query type for PossibleGrade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPossibleGrade extends EntityPathBase<PossibleGrade> {
    
    private static final long serialVersionUID = -1463812421L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QPossibleGrade possibleGrade = new QPossibleGrade("possibleGrade");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    public final NumberPath<Float> alisPoints = createNumber("alisPoints", Float.class);
    
    public final NumberPath<Float> alpsPoints = createNumber("alpsPoints", Float.class);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final StringPath grade = createString("grade");
    
    public final QPossibleGradeSet gradeSet;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final NumberPath<Integer> ucasPoints = createNumber("ucasPoints", Integer.class);
    
    public final BooleanPath useForKeyAssessment = createBoolean("useForKeyAssessment");
    
    public QPossibleGrade(
        String variable) {
        this(PossibleGrade.class, forVariable(variable), INITS);
    }
    
    public QPossibleGrade(
        Path<? extends PossibleGrade> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QPossibleGrade(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QPossibleGrade(
        PathMetadata metadata,
        PathInits inits) {
        this(PossibleGrade.class, metadata, inits);
    }
    
    public QPossibleGrade(
        Class<? extends PossibleGrade> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.gradeSet = inits.isInitialized("gradeSet") ? new QPossibleGradeSet(forProperty("gradeSet")) : null;
    }
    
}
