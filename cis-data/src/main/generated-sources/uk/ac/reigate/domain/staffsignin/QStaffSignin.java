package uk.ac.reigate.domain.staffsignin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaffSignin is a Querydsl query type for StaffSignin
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffSignin extends EntityPathBase<StaffSignin> {
    
    private static final long serialVersionUID = 717563149L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaffSignin staffSignin = new QStaffSignin("staffSignin");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> signinTime = createDateTime("signinTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> signoutTime = createDateTime("signoutTime", java.util.Date.class);
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public QStaffSignin(
        String variable) {
        this(StaffSignin.class, forVariable(variable), INITS);
    }
    
    public QStaffSignin(
        Path<? extends StaffSignin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaffSignin(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaffSignin(
        PathMetadata metadata,
        PathInits inits) {
        this(StaffSignin.class, metadata, inits);
    }
    
    public QStaffSignin(
        Class<? extends StaffSignin> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
    }
    
}
