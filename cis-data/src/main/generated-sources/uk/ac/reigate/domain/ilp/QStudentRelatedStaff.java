package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentRelatedStaff is a Querydsl query type for StudentRelatedStaff
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentRelatedStaff extends EntityPathBase<StudentRelatedStaff> {
    
    private static final long serialVersionUID = 504705894L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentRelatedStaff studentRelatedStaff = new QStudentRelatedStaff("studentRelatedStaff");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final StringPath relationship = createString("relationship");
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final StringPath staffInitials = createString("staffInitials");
    
    public final StringPath staffName = createString("staffName");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentRelatedStaff(
        String variable) {
        this(StudentRelatedStaff.class, forVariable(variable), INITS);
    }
    
    public QStudentRelatedStaff(
        Path<? extends StudentRelatedStaff> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentRelatedStaff(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentRelatedStaff(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentRelatedStaff.class, metadata, inits);
    }
    
    public QStudentRelatedStaff(
        Class<? extends StudentRelatedStaff> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
