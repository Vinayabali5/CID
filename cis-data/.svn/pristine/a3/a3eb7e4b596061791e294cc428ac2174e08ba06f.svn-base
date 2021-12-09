package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentAlternativeUci is a Querydsl query type for StudentAlternativeUci
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentAlternativeUci extends EntityPathBase<StudentAlternativeUci> {
    
    private static final long serialVersionUID = -1866228250L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentAlternativeUci studentAlternativeUci = new QStudentAlternativeUci("studentAlternativeUci");
    
    public final StringPath alternativeUci = createString("alternativeUci");
    
    public final QExamBoard examBoard;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentAlternativeUci(
        String variable) {
        this(StudentAlternativeUci.class, forVariable(variable), INITS);
    }
    
    public QStudentAlternativeUci(
        Path<? extends StudentAlternativeUci> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentAlternativeUci(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentAlternativeUci(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentAlternativeUci.class, metadata, inits);
    }
    
    public QStudentAlternativeUci(
        Class<? extends StudentAlternativeUci> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examBoard = inits.isInitialized("examBoard") ? new QExamBoard(forProperty("examBoard")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
