package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCourseYearPk is a Querydsl query type for StudentCourseYearPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentCourseYearPk extends BeanPath<StudentCourseYearPk> {
    
    private static final long serialVersionUID = 341115856L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCourseYearPk studentCourseYearPk = new QStudentCourseYearPk("studentCourseYearPk");
    
    public final QCourse course;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final QStudent student;
    
    public final QAcademicYear year;
    
    public QStudentCourseYearPk(
        String variable) {
        this(StudentCourseYearPk.class, forVariable(variable), INITS);
    }
    
    public QStudentCourseYearPk(
        Path<? extends StudentCourseYearPk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCourseYearPk(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCourseYearPk(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCourseYearPk.class, metadata, inits);
    }
    
    public QStudentCourseYearPk(
        Class<? extends StudentCourseYearPk> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
