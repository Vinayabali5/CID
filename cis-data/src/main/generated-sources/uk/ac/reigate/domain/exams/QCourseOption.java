package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourseOption is a Querydsl query type for CourseOption
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseOption extends EntityPathBase<CourseOption> {
    
    private static final long serialVersionUID = 332621235L;
    
    private static final PathInits INITS = new PathInits("*", "course.syllabus.code", "examOption.syllabus.examSeries.academicYear");
    
    public static final QCourseOption courseOption = new QCourseOption("courseOption");
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.exams.basedata.QExamOption examOption;
    
    public final BooleanPath intermediateEntry = createBoolean("intermediateEntry");
    
    public final BooleanPath lowerEntry = createBoolean("lowerEntry");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final BooleanPath upperEntry = createBoolean("upperEntry");
    
    public QCourseOption(
        String variable) {
        this(CourseOption.class, forVariable(variable), INITS);
    }
    
    public QCourseOption(
        Path<? extends CourseOption> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourseOption(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourseOption(
        PathMetadata metadata,
        PathInits inits) {
        this(CourseOption.class, metadata, inits);
    }
    
    public QCourseOption(
        Class<? extends CourseOption> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.examOption = inits.isInitialized("examOption") ? new uk.ac.reigate.domain.exams.basedata.QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
    }
    
}
