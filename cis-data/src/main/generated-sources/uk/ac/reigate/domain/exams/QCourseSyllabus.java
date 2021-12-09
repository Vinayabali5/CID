package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourseSyllabus is a Querydsl query type for CourseSyllabus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseSyllabus extends EntityPathBase<CourseSyllabus> {
    
    private static final long serialVersionUID = -626355293L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCourseSyllabus courseSyllabus = new QCourseSyllabus("courseSyllabus");
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.exams.basedata.QSyllabus syllabus;
    
    public QCourseSyllabus(
        String variable) {
        this(CourseSyllabus.class, forVariable(variable), INITS);
    }
    
    public QCourseSyllabus(
        Path<? extends CourseSyllabus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourseSyllabus(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourseSyllabus(
        PathMetadata metadata,
        PathInits inits) {
        this(CourseSyllabus.class, metadata, inits);
    }
    
    public QCourseSyllabus(
        Class<? extends CourseSyllabus> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.syllabus = inits.isInitialized("syllabus") ? new uk.ac.reigate.domain.exams.basedata.QSyllabus(forProperty("syllabus"), inits.get("syllabus")) : null;
    }
    
}
