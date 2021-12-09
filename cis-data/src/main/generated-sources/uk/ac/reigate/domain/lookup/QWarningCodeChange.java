package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QWarningCodeChange is a Querydsl query type for WarningCodeChange
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWarningCodeChange extends EntityPathBase<WarningCodeChange> {
    
    private static final long serialVersionUID = 1819535374L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QWarningCodeChange warningCodeChange = new QWarningCodeChange("warningCodeChange");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> changeDate = createDateTime("changeDate", java.util.Date.class);
    
    public final QAttendanceMonitoring currentAm;
    
    public final QPunctualityMonitoring currentPm;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QAttendanceMonitoring previousAm;
    
    public final QPunctualityMonitoring previousPm;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QWarningCodeChange(
        String variable) {
        this(WarningCodeChange.class, forVariable(variable), INITS);
    }
    
    public QWarningCodeChange(
        Path<? extends WarningCodeChange> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QWarningCodeChange(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QWarningCodeChange(
        PathMetadata metadata,
        PathInits inits) {
        this(WarningCodeChange.class, metadata, inits);
    }
    
    public QWarningCodeChange(
        Class<? extends WarningCodeChange> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.currentAm = inits.isInitialized("currentAm") ? new QAttendanceMonitoring(forProperty("currentAm")) : null;
        this.currentPm = inits.isInitialized("currentPm") ? new QPunctualityMonitoring(forProperty("currentPm")) : null;
        this.previousAm = inits.isInitialized("previousAm") ? new QAttendanceMonitoring(forProperty("previousAm")) : null;
        this.previousPm = inits.isInitialized("previousPm") ? new QPunctualityMonitoring(forProperty("previousPm")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
