package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QLearningSupportVisit is a Querydsl query type for LearningSupportVisit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLearningSupportVisit extends EntityPathBase<LearningSupportVisit> {
    
    private static final long serialVersionUID = 1298307857L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QLearningSupportVisit learningSupportVisit = new QLearningSupportVisit("learningSupportVisit");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    public final StringPath details = createString("details");
    
    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);
    
    public QLearningSupportVisit(
        String variable) {
        this(LearningSupportVisit.class, forVariable(variable), INITS);
    }
    
    public QLearningSupportVisit(
        Path<? extends LearningSupportVisit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QLearningSupportVisit(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QLearningSupportVisit(
        PathMetadata metadata,
        PathInits inits) {
        this(LearningSupportVisit.class, metadata, inits);
    }
    
    public QLearningSupportVisit(
        Class<? extends LearningSupportVisit> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
