package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentVolunteeringLog is a Querydsl query type for StudentVolunteeringLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentVolunteeringLog extends EntityPathBase<StudentVolunteeringLog> {
    
    private static final long serialVersionUID = 1101596207L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentVolunteeringLog studentVolunteeringLog = new QStudentVolunteeringLog("studentVolunteeringLog");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    public final NumberPath<Double> hours = createNumber("hours", Double.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath note = createString("note");
    
    public final QStudent student;
    
    public final uk.ac.reigate.domain.lookup.QStudentRole studentRole;
    
    public final uk.ac.reigate.domain.lookup.QVolunteeringExperience volunteeringExperience;
    
    public final uk.ac.reigate.domain.lookup.QVolunteeringType volunteeringType;
    
    public QStudentVolunteeringLog(
        String variable) {
        this(StudentVolunteeringLog.class, forVariable(variable), INITS);
    }
    
    public QStudentVolunteeringLog(
        Path<? extends StudentVolunteeringLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentVolunteeringLog(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentVolunteeringLog(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentVolunteeringLog.class, metadata, inits);
    }
    
    public QStudentVolunteeringLog(
        Class<? extends StudentVolunteeringLog> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.studentRole = inits.isInitialized("studentRole") ? new uk.ac.reigate.domain.lookup.QStudentRole(forProperty("studentRole")) : null;
        this.volunteeringExperience = inits.isInitialized("volunteeringExperience") ? new uk.ac.reigate.domain.lookup.QVolunteeringExperience(forProperty("volunteeringExperience")) : null;
        this.volunteeringType = inits.isInitialized("volunteeringType") ? new uk.ac.reigate.domain.lookup.QVolunteeringType(forProperty("volunteeringType")) : null;
    }
    
}
