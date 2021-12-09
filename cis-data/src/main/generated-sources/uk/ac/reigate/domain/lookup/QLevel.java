package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QLevel is a Querydsl query type for Level
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLevel extends EntityPathBase<Level> {
    
    private static final long serialVersionUID = 48142937L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QLevel level = new QLevel("level");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    public final BooleanPath academic = createBoolean("academic");
    
    public final StringPath alisQualCode = createString("alisQualCode");
    
    // inherited
    public final StringPath code = _super.code;
    
    public final NumberPath<Integer> coreAimPriority = createNumber("coreAimPriority", Integer.class);
    
    // inherited
    public final StringPath description = _super.description;
    
    public final StringPath dfeQualName = createString("dfeQualName");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QPossibleGradeSet possibleGradeSet;
    
    public final NumberPath<Integer> progressionTo = createNumber("progressionTo", Integer.class);
    
    public final StringPath qualificationFramework = createString("qualificationFramework");
    
    public final NumberPath<Integer> rqfLevel = createNumber("rqfLevel", Integer.class);
    
    public final BooleanPath sarInclude = createBoolean("sarInclude");
    
    public QLevel(
        String variable) {
        this(Level.class, forVariable(variable), INITS);
    }
    
    public QLevel(
        Path<? extends Level> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QLevel(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QLevel(
        PathMetadata metadata,
        PathInits inits) {
        this(Level.class, metadata, inits);
    }
    
    public QLevel(
        Class<? extends Level> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.possibleGradeSet = inits.isInitialized("possibleGradeSet") ? new QPossibleGradeSet(forProperty("possibleGradeSet")) : null;
    }
    
}
