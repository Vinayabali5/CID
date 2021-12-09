package uk.ac.reigate.domain.register;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRegisterMark is a Querydsl query type for RegisterMark
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegisterMark extends EntityPathBase<RegisterMark> {
    
    private static final long serialVersionUID = -2113529006L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QRegisterMark registerMark = new QRegisterMark("registerMark");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final QAttendanceCode attendanceCode;
    
    public final uk.ac.reigate.domain.academic.QCourse course;
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QRegister register;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QRegisterMark(
        String variable) {
        this(RegisterMark.class, forVariable(variable), INITS);
    }
    
    public QRegisterMark(
        Path<? extends RegisterMark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QRegisterMark(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QRegisterMark(
        PathMetadata metadata,
        PathInits inits) {
        this(RegisterMark.class, metadata, inits);
    }
    
    public QRegisterMark(
        Class<? extends RegisterMark> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.attendanceCode = inits.isInitialized("attendanceCode") ? new QAttendanceCode(forProperty("attendanceCode")) : null;
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourse(forProperty("course"), inits.get("course")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.register = inits.isInitialized("register") ? new QRegister(forProperty("register"), inits.get("register")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
