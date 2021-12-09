package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourseComponent is a Querydsl query type for CourseComponent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseComponent extends EntityPathBase<CourseComponent> {
    
    private static final long serialVersionUID = 1679380223L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCourseComponent courseComponent = new QCourseComponent("courseComponent");
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.exams.basedata.QExamComponent examComponent;
    
    public final uk.ac.reigate.domain.exams.basedata.QExamOption examOption;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public QCourseComponent(
        String variable) {
        this(CourseComponent.class, forVariable(variable), INITS);
    }
    
    public QCourseComponent(
        Path<? extends CourseComponent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourseComponent(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourseComponent(
        PathMetadata metadata,
        PathInits inits) {
        this(CourseComponent.class, metadata, inits);
    }
    
    public QCourseComponent(
        Class<? extends CourseComponent> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.examComponent = inits.isInitialized("examComponent") ? new uk.ac.reigate.domain.exams.basedata.QExamComponent(forProperty("examComponent"), inits.get("examComponent")) : null;
        this.examOption = inits.isInitialized("examOption") ? new uk.ac.reigate.domain.exams.basedata.QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
    }
    
}
