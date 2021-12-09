package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaffInterestedInStudent is a Querydsl query type for StaffInterestedInStudent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffInterestedInStudent extends EntityPathBase<StaffInterestedInStudent> {
    
    private static final long serialVersionUID = -953383573L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaffInterestedInStudent staffInterestedInStudent = new QStaffInterestedInStudent("staffInterestedInStudent");
    
    public final StringPath courseGroupSpec = createString("courseGroupSpec");
    
    public final BooleanPath departmental = createBoolean("departmental");
    
    public final StringPath interest = createString("interest");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final BooleanPath pastoral = createBoolean("pastoral");
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final StringPath staffEmail = createString("staffEmail");
    
    public final StringPath staffInitials = createString("staffInitials");
    
    public final StringPath staffKnownAs = createString("staffKnownAs");
    
    public final QStudent student;
    
    public QStaffInterestedInStudent(
        String variable) {
        this(StaffInterestedInStudent.class, forVariable(variable), INITS);
    }
    
    public QStaffInterestedInStudent(
        Path<? extends StaffInterestedInStudent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaffInterestedInStudent(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaffInterestedInStudent(
        PathMetadata metadata,
        PathInits inits) {
        this(StaffInterestedInStudent.class, metadata, inits);
    }
    
    public QStaffInterestedInStudent(
        Class<? extends StaffInterestedInStudent> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
