package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEntryQualificationType is a Querydsl query type for EntryQualificationType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEntryQualificationType extends EntityPathBase<EntryQualificationType> {
    
    private static final long serialVersionUID = -705475243L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QEntryQualificationType entryQualificationType = new QEntryQualificationType("entryQualificationType");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.lookup.QPossibleGradeSet possibleGradeSet;
    
    public final NumberPath<Float> size = createNumber("size", Float.class);
    
    public final BooleanPath useOfRoe = createBoolean("useOfRoe");
    
    public QEntryQualificationType(
        String variable) {
        this(EntryQualificationType.class, forVariable(variable), INITS);
    }
    
    public QEntryQualificationType(
        Path<? extends EntryQualificationType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QEntryQualificationType(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QEntryQualificationType(
        PathMetadata metadata,
        PathInits inits) {
        this(EntryQualificationType.class, metadata, inits);
    }
    
    public QEntryQualificationType(
        Class<? extends EntryQualificationType> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.possibleGradeSet = inits.isInitialized("possibleGradeSet") ? new uk.ac.reigate.domain.lookup.QPossibleGradeSet(forProperty("possibleGradeSet")) : null;
    }
    
}
