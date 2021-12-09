package uk.ac.reigate.domain.cristal;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QMasterRegister is a Querydsl query type for MasterRegister
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMasterRegister extends EntityPathBase<MasterRegister> {
    
    private static final long serialVersionUID = 2040188982L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QMasterRegister masterRegister = new QMasterRegister("masterRegister");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final uk.ac.reigate.domain.register.QAttendanceCode attendance;
    
    public final StringPath group = createString("group");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath notes = createString("notes");
    
    public final NumberPath<Integer> sessionRef = createNumber("sessionRef", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath subjectCode = createString("subjectCode");
    
    public QMasterRegister(
        String variable) {
        this(MasterRegister.class, forVariable(variable), INITS);
    }
    
    public QMasterRegister(
        Path<? extends MasterRegister> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QMasterRegister(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QMasterRegister(
        PathMetadata metadata,
        PathInits inits) {
        this(MasterRegister.class, metadata, inits);
    }
    
    public QMasterRegister(
        Class<? extends MasterRegister> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.attendance = inits.isInitialized("attendance") ? new uk.ac.reigate.domain.register.QAttendanceCode(forProperty("attendance")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
