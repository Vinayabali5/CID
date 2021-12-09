package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QSimilarNamedStudent is a Querydsl query type for SimilarNamedStudent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimilarNamedStudent extends EntityPathBase<SimilarNamedStudent> {
    
    private static final long serialVersionUID = 188755247L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QSimilarNamedStudent similarNamedStudent = new QSimilarNamedStudent("similarNamedStudent");
    
    public final QAcademicYear academicYear;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> numberSimilarNames = createNumber("numberSimilarNames", Integer.class);
    
    public final QStudent student;
    
    public QSimilarNamedStudent(
        String variable) {
        this(SimilarNamedStudent.class, forVariable(variable), INITS);
    }
    
    public QSimilarNamedStudent(
        Path<? extends SimilarNamedStudent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QSimilarNamedStudent(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QSimilarNamedStudent(
        PathMetadata metadata,
        PathInits inits) {
        this(SimilarNamedStudent.class, metadata, inits);
    }
    
    public QSimilarNamedStudent(
        Class<? extends SimilarNamedStudent> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new QAcademicYear(forProperty("academicYear")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
