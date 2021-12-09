package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentConcessionType is a Querydsl query type for StudentConcessionType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentConcessionType extends EntityPathBase<StudentConcessionType> {
    
    private static final long serialVersionUID = -194421758L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentConcessionType studentConcessionType = new QStudentConcessionType("studentConcessionType");
    
    public final QConcessionType concessionType;
    
    public final NumberPath<Integer> extraTimePercentage = createNumber("extraTimePercentage", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentConcessionType(
        String variable) {
        this(StudentConcessionType.class, forVariable(variable), INITS);
    }
    
    public QStudentConcessionType(
        Path<? extends StudentConcessionType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentConcessionType(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentConcessionType(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentConcessionType.class, metadata, inits);
    }
    
    public QStudentConcessionType(
        Class<? extends StudentConcessionType> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.concessionType = inits.isInitialized("concessionType") ? new QConcessionType(forProperty("concessionType")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
