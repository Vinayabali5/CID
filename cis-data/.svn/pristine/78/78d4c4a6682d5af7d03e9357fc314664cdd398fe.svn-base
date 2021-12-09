package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCourseConcession is a Querydsl query type for StudentCourseConcession
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentCourseConcession extends EntityPathBase<StudentCourseConcession> {
    
    private static final long serialVersionUID = 137660451L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCourseConcession studentCourseConcession = new QStudentCourseConcession("studentCourseConcession");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final QConcessionType concessionType;
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final NumberPath<Integer> extraTimePercentage = createNumber("extraTimePercentage", Integer.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentCourseConcession(
        String variable) {
        this(StudentCourseConcession.class, forVariable(variable), INITS);
    }
    
    public QStudentCourseConcession(
        Path<? extends StudentCourseConcession> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCourseConcession(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCourseConcession(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCourseConcession.class, metadata, inits);
    }
    
    public QStudentCourseConcession(
        Class<? extends StudentCourseConcession> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.concessionType = inits.isInitialized("concessionType") ? new QConcessionType(forProperty("concessionType")) : null;
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
