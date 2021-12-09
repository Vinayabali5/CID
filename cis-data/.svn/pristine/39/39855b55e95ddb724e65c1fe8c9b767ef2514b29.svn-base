package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QExternalResultsArchive is a Querydsl query type for ExternalResultsArchive
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExternalResultsArchive extends EntityPathBase<ExternalResultsArchive> {
    
    private static final long serialVersionUID = -2028634507L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QExternalResultsArchive externalResultsArchive = new QExternalResultsArchive("externalResultsArchive");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath courseSpec = createString("courseSpec");
    
    public final DateTimePath<java.util.Date> dateAchieved = createDateTime("dateAchieved", java.util.Date.class);
    
    public final StringPath examType = createString("examType");
    
    public final StringPath grade = createString("grade");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath levelDescription = createString("levelDescription");
    
    public final StringPath mark = createString("mark");
    
    public final StringPath maxMark = createString("maxMark");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath series = createString("series");
    
    public final QStudent student;
    
    public final StringPath subjectDescription = createString("subjectDescription");
    
    public final StringPath syllabus = createString("syllabus");
    
    public final StringPath year = createString("year");
    
    public QExternalResultsArchive(
        String variable) {
        this(ExternalResultsArchive.class, forVariable(variable), INITS);
    }
    
    public QExternalResultsArchive(
        Path<? extends ExternalResultsArchive> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QExternalResultsArchive(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QExternalResultsArchive(
        PathMetadata metadata,
        PathInits inits) {
        this(ExternalResultsArchive.class, metadata, inits);
    }
    
    public QExternalResultsArchive(
        Class<? extends ExternalResultsArchive> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
