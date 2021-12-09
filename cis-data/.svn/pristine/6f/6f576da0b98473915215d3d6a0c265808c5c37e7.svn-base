package uk.ac.reigate.domain.interimreport;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QInterimReportsDue is a Querydsl query type for InterimReportsDue
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterimReportsDue extends EntityPathBase<InterimReportsDue> {
    
    private static final long serialVersionUID = 1589757042L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QInterimReportsDue interimReportsDue = new QInterimReportsDue("interimReportsDue");
    
    public final BooleanPath complete = createBoolean("complete");
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final StringPath CourseGroupSpec = createString("CourseGroupSpec");
    
    public final StringPath courseGroupSpec = createString("courseGroupSpec");
    
    public final QInterimReport interimReport;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public QInterimReportsDue(
        String variable) {
        this(InterimReportsDue.class, forVariable(variable), INITS);
    }
    
    public QInterimReportsDue(
        Path<? extends InterimReportsDue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QInterimReportsDue(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QInterimReportsDue(
        PathMetadata metadata,
        PathInits inits) {
        this(InterimReportsDue.class, metadata, inits);
    }
    
    public QInterimReportsDue(
        Class<? extends InterimReportsDue> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.interimReport = inits.isInitialized("interimReport") ? new QInterimReport(forProperty("interimReport"), inits.get("interimReport")) : null;
    }
    
}
