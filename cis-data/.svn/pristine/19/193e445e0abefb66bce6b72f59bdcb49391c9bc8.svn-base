package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QTimetable is a Querydsl query type for Timetable
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimetable extends EntityPathBase<Timetable> {
    
    private static final long serialVersionUID = 1516674691L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QTimetable timetable = new QTimetable("timetable");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final SetPath<uk.ac.reigate.domain.Staff, uk.ac.reigate.domain.QStaff> additionalStaff = this.<uk.ac.reigate.domain.Staff, uk.ac.reigate.domain.QStaff> createSet("additionalStaff", uk.ac.reigate.domain.Staff.class, uk.ac.reigate.domain.QStaff.class, PathInits.DIRECT2);
    
    public final QAlternativePeriod alternativePeriod;
    
    public final QCourseGroup courseGroup;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.QRoom room;
    
    public final uk.ac.reigate.domain.QStaff teacher;
    
    public final DateTimePath<java.util.Date> validFrom = createDateTime("validFrom", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> validTo = createDateTime("validTo", java.util.Date.class);
    
    public QTimetable(
        String variable) {
        this(Timetable.class, forVariable(variable), INITS);
    }
    
    public QTimetable(
        Path<? extends Timetable> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QTimetable(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QTimetable(
        PathMetadata metadata,
        PathInits inits) {
        this(Timetable.class, metadata, inits);
    }
    
    public QTimetable(
        Class<? extends Timetable> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.alternativePeriod = inits.isInitialized("alternativePeriod") ? new QAlternativePeriod(forProperty("alternativePeriod"), inits.get("alternativePeriod")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.room = inits.isInitialized("room") ? new uk.ac.reigate.domain.QRoom(forProperty("room"), inits.get("room")) : null;
        this.teacher = inits.isInitialized("teacher") ? new uk.ac.reigate.domain.QStaff(forProperty("teacher"), inits.get("teacher")) : null;
    }
    
}
