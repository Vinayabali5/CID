package uk.ac.reigate.domain.register;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentOverallAttendance is a Querydsl query type for StudentOverallAttendance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentOverallAttendance extends EntityPathBase<StudentOverallAttendance> {
    
    private static final long serialVersionUID = -2140642723L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentOverallAttendance studentOverallAttendance = new QStudentOverallAttendance("studentOverallAttendance");
    
    public final NumberPath<Double> adjustedAttendance = createNumber("adjustedAttendance", Double.class);
    
    public final NumberPath<Double> adjustedPunctuality = createNumber("adjustedPunctuality", Double.class);
    
    public final NumberPath<Double> attendance = createNumber("attendance", Double.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Double> punctuality = createNumber("punctuality", Double.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final NumberPath<Integer> totalAbsence = createNumber("totalAbsence", Integer.class);
    
    public final NumberPath<Integer> totalAdjusted = createNumber("totalAdjusted", Integer.class);
    
    public final NumberPath<Integer> totalAuthorisedAbsence = createNumber("totalAuthorisedAbsence", Integer.class);
    
    public final NumberPath<Integer> totalAuthorisedLate = createNumber("totalAuthorisedLate", Integer.class);
    
    public final NumberPath<Integer> totalLate = createNumber("totalLate", Integer.class);
    
    public final NumberPath<Integer> totalSessions = createNumber("totalSessions", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QStudentOverallAttendance(
        String variable) {
        this(StudentOverallAttendance.class, forVariable(variable), INITS);
    }
    
    public QStudentOverallAttendance(
        Path<? extends StudentOverallAttendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentOverallAttendance(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentOverallAttendance(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentOverallAttendance.class, metadata, inits);
    }
    
    public QStudentOverallAttendance(
        Class<? extends StudentOverallAttendance> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
