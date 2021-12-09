package uk.ac.reigate.domain.attendance;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCourseGroupAttendance is a Querydsl query type for StudentCourseGroupAttendance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentCourseGroupAttendance extends EntityPathBase<StudentCourseGroupAttendance> {
    
    private static final long serialVersionUID = 384077998L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCourseGroupAttendance studentCourseGroupAttendance = new QStudentCourseGroupAttendance("studentCourseGroupAttendance");
    
    public final NumberPath<Integer> absent = createNumber("absent", Integer.class);
    
    public final NumberPath<Integer> authorisedAbsent = createNumber("authorisedAbsent", Integer.class);
    
    public final NumberPath<Integer> authorisedLate = createNumber("authorisedLate", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final StringPath courseSpec = createString("courseSpec");
    
    public final NumberPath<Integer> included = createNumber("included", Integer.class);
    
    public final NumberPath<Integer> late = createNumber("late", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> overallAbsent = createNumber("overallAbsent", Integer.class);
    
    public final NumberPath<Integer> overallAuthorisedAbsent = createNumber("overallAuthorisedAbsent", Integer.class);
    
    public final NumberPath<Integer> overallAuthorisedLate = createNumber("overallAuthorisedLate", Integer.class);
    
    public final NumberPath<Integer> overallIncluded = createNumber("overallIncluded", Integer.class);
    
    public final NumberPath<Integer> overallLate = createNumber("overallLate", Integer.class);
    
    public final NumberPath<Integer> overallPresent = createNumber("overallPresent", Integer.class);
    
    public final NumberPath<Integer> overallTotal = createNumber("overallTotal", Integer.class);
    
    public final DateTimePath<java.util.Date> periodEndDate = createDateTime("periodEndDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> periodStartDate = createDateTime("periodStartDate", java.util.Date.class);
    
    public final NumberPath<Integer> present = createNumber("present", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final NumberPath<Integer> total = createNumber("total", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QStudentCourseGroupAttendance(
        String variable) {
        this(StudentCourseGroupAttendance.class, forVariable(variable), INITS);
    }
    
    public QStudentCourseGroupAttendance(
        Path<? extends StudentCourseGroupAttendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCourseGroupAttendance(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCourseGroupAttendance(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCourseGroupAttendance.class, metadata, inits);
    }
    
    public QStudentCourseGroupAttendance(
        Class<? extends StudentCourseGroupAttendance> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
