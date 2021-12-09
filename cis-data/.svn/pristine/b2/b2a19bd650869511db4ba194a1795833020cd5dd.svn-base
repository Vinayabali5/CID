package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCourseSupportType is a Querydsl query type for StudentCourseSupportType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentCourseSupportType extends EntityPathBase<StudentCourseSupportType> {
    
    private static final long serialVersionUID = -2069455318L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCourseSupportType studentCourseSupportType = new QStudentCourseSupportType("studentCourseSupportType");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final DateTimePath<java.util.Date> EndDate = createDateTime("EndDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> StartDate = createDateTime("StartDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final QSupportType supportType;
    
    public QStudentCourseSupportType(
        String variable) {
        this(StudentCourseSupportType.class, forVariable(variable), INITS);
    }
    
    public QStudentCourseSupportType(
        Path<? extends StudentCourseSupportType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCourseSupportType(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCourseSupportType(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCourseSupportType.class, metadata, inits);
    }
    
    public QStudentCourseSupportType(
        Class<? extends StudentCourseSupportType> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.supportType = inits.isInitialized("supportType") ? new QSupportType(forProperty("supportType")) : null;
    }
    
}
