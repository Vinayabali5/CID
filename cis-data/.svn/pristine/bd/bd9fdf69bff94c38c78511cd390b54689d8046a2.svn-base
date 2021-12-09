package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPreReference is a Querydsl query type for PreReference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPreReference extends EntityPathBase<PreReference> {
    
    private static final long serialVersionUID = 2106483526L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QPreReference preReference = new QPreReference("preReference");
    
    public final QCourse course;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.lookup.QPossibleGrade predictedGrade;
    
    public final QStudent student;
    
    public QPreReference(
        String variable) {
        this(PreReference.class, forVariable(variable), INITS);
    }
    
    public QPreReference(
        Path<? extends PreReference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QPreReference(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QPreReference(
        PathMetadata metadata,
        PathInits inits) {
        this(PreReference.class, metadata, inits);
    }
    
    public QPreReference(
        Class<? extends PreReference> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
        this.predictedGrade = inits.isInitialized("predictedGrade") ? new uk.ac.reigate.domain.lookup.QPossibleGrade(forProperty("predictedGrade"), inits.get("predictedGrade")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
