package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCourseGroup is a Querydsl query type for CourseGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseGroup extends EntityPathBase<CourseGroup> {
    
    private static final long serialVersionUID = -355980282L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCourseGroup courseGroup = new QCourseGroup("courseGroup");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath code = createString("code");
    
    public final QCourse course;
    
    public final uk.ac.reigate.domain.QStaff courseLeader;
    
    public final QDepartment department;
    
    public final BooleanPath displayOnTimetable = createBoolean("displayOnTimetable");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final ListPath<Enrolment, QEnrolment> enrolments = this.<Enrolment, QEnrolment> createList("enrolments", Enrolment.class, QEnrolment.class, PathInits.DIRECT2);
    
    public final BooleanPath excludeFromAllocation = createBoolean("excludeFromAllocation");
    
    public final BooleanPath excludeFromExams = createBoolean("excludeFromExams");
    
    public final BooleanPath excludeFromIR = createBoolean("excludeFromIR");
    
    public final BooleanPath hasRegister = createBoolean("hasRegister");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath ilrReturn = createBoolean("ilrReturn");
    
    public final StringPath learningAimReferenceOverride = createString("learningAimReferenceOverride");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath nested = createBoolean("nested");
    
    public final StringPath notes = createString("notes");
    
    public final NumberPath<Integer> peeph = createNumber("peeph", Integer.class);
    
    public final NumberPath<Integer> plh = createNumber("plh", Integer.class);
    
    public final StringPath spec = createString("spec");
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final ListPath<Timetable, QTimetable> timetable = this.<Timetable, QTimetable> createList("timetable", Timetable.class, QTimetable.class, PathInits.DIRECT2);
    
    public final QAcademicYear year;
    
    public final uk.ac.reigate.domain.lookup.QYearGroup yearGroup;
    
    public QCourseGroup(
        String variable) {
        this(CourseGroup.class, forVariable(variable), INITS);
    }
    
    public QCourseGroup(
        Path<? extends CourseGroup> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCourseGroup(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCourseGroup(
        PathMetadata metadata,
        PathInits inits) {
        this(CourseGroup.class, metadata, inits);
    }
    
    public QCourseGroup(
        Class<? extends CourseGroup> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseLeader = inits.isInitialized("courseLeader") ? new uk.ac.reigate.domain.QStaff(forProperty("courseLeader"), inits.get("courseLeader")) : null;
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department"), inits.get("department")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
        this.yearGroup = inits.isInitialized("yearGroup") ? new uk.ac.reigate.domain.lookup.QYearGroup(forProperty("yearGroup")) : null;
    }
    
}
