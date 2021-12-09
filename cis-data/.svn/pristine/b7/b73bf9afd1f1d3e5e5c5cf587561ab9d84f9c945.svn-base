package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QGCSEScore is a Querydsl query type for GCSEScore
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGCSEScore extends EntityPathBase<GCSEScore> {
    
    private static final long serialVersionUID = -810333050L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QGCSEScore gCSEScore = new QGCSEScore("gCSEScore");
    
    public final NumberPath<Double> average = createNumber("average", Double.class);
    
    public final NumberPath<Integer> countOfGCSEs = createNumber("countOfGCSEs", Integer.class);
    
    public final NumberPath<Integer> countOfQualifications = createNumber("countOfQualifications", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> passes = createNumber("passes", Integer.class);
    
    public final NumberPath<Integer> passesAToC = createNumber("passesAToC", Integer.class);
    
    public final NumberPath<Double> score = createNumber("score", Double.class);
    
    public final QStudent student;
    
    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);
    
    public QGCSEScore(
        String variable) {
        this(GCSEScore.class, forVariable(variable), INITS);
    }
    
    public QGCSEScore(
        Path<? extends GCSEScore> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QGCSEScore(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QGCSEScore(
        PathMetadata metadata,
        PathInits inits) {
        this(GCSEScore.class, metadata, inits);
    }
    
    public QGCSEScore(
        Class<? extends GCSEScore> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
