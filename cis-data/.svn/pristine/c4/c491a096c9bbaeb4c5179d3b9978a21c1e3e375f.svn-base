package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCourseGroupYearPk is a Querydsl query type for StudentCourseGroupYearPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentCourseGroupYearPk extends BeanPath<StudentCourseGroupYearPk> {
    
    private static final long serialVersionUID = -1592138561L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCourseGroupYearPk studentCourseGroupYearPk = new QStudentCourseGroupYearPk("studentCourseGroupYearPk");
    
    public final QCourseGroup courseGroup;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final QStudent student;
    
    public final QAcademicYear year;
    
    public QStudentCourseGroupYearPk(
        String variable) {
        this(StudentCourseGroupYearPk.class, forVariable(variable), INITS);
    }
    
    public QStudentCourseGroupYearPk(
        Path<? extends StudentCourseGroupYearPk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCourseGroupYearPk(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCourseGroupYearPk(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCourseGroupYearPk.class, metadata, inits);
    }
    
    public QStudentCourseGroupYearPk(
        Class<? extends StudentCourseGroupYearPk> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.courseGroup = inits.isInitialized("courseGroup") ? new QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
