package uk.ac.reigate.domain.attendance;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentAttendance is a Querydsl query type for StudentAttendance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentAttendance extends EntityPathBase<StudentAttendance> {
    
    private static final long serialVersionUID = 1205344776L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentAttendance studentAttendance = new QStudentAttendance("studentAttendance");
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final NumberPath<Integer> sumOfAbsences = createNumber("sumOfAbsences", Integer.class);
    
    public final NumberPath<Integer> sumOfAdjAbs = createNumber("sumOfAdjAbs", Integer.class);
    
    public final NumberPath<Integer> sumOfLates = createNumber("sumOfLates", Integer.class);
    
    public final NumberPath<Integer> sumOfPeriods = createNumber("sumOfPeriods", Integer.class);
    
    public QStudentAttendance(
        String variable) {
        this(StudentAttendance.class, forVariable(variable), INITS);
    }
    
    public QStudentAttendance(
        Path<? extends StudentAttendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentAttendance(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentAttendance(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentAttendance.class, metadata, inits);
    }
    
    public QStudentAttendance(
        Class<? extends StudentAttendance> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
