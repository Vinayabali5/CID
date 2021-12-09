package uk.ac.reigate.domain.interimreport;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourseGroupInterimReport is a Querydsl query type for CourseGroupInterimReport
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseGroupInterimReport extends EntityPathBase<CourseGroupInterimReport> {
    
    private static final long serialVersionUID = -1572966573L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCourseGroupInterimReport courseGroupInterimReport = new QCourseGroupInterimReport("courseGroupInterimReport");
    
    public final BooleanPath complete = createBoolean("complete");
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final QInterimReport interimReport;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.QStaff staffCompleted;
    
    public QCourseGroupInterimReport(
        String variable) {
        this(CourseGroupInterimReport.class, forVariable(variable), INITS);
    }
    
    public QCourseGroupInterimReport(
        Path<? extends CourseGroupInterimReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourseGroupInterimReport(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourseGroupInterimReport(
        PathMetadata metadata,
        PathInits inits) {
        this(CourseGroupInterimReport.class, metadata, inits);
    }
    
    public QCourseGroupInterimReport(
        Class<? extends CourseGroupInterimReport> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.interimReport = inits.isInitialized("interimReport") ? new QInterimReport(forProperty("interimReport"), inits.get("interimReport")) : null;
        this.staffCompleted = inits.isInitialized("staffCompleted") ? new uk.ac.reigate.domain.QStaff(forProperty("staffCompleted"), inits.get("staffCompleted")) : null;
    }
    
}
