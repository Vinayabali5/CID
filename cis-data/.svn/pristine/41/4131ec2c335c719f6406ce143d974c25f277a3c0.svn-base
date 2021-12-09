package uk.ac.reigate.domain.register;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRegister is a Querydsl query type for Register
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegister extends EntityPathBase<Register> {
    
    private static final long serialVersionUID = 77830885L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QRegister register = new QRegister("register");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath completed = createBoolean("completed");
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final DateTimePath<java.util.Date> dateCompleted = createDateTime("dateCompleted", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QRegisteredSession session;
    
    public final uk.ac.reigate.domain.QStaff staffCompleted;
    
    public QRegister(
        String variable) {
        this(Register.class, forVariable(variable), INITS);
    }
    
    public QRegister(
        Path<? extends Register> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QRegister(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QRegister(
        PathMetadata metadata,
        PathInits inits) {
        this(Register.class, metadata, inits);
    }
    
    public QRegister(
        Class<? extends Register> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.session = inits.isInitialized("session") ? new QRegisteredSession(forProperty("session"), inits.get("session")) : null;
        this.staffCompleted = inits.isInitialized("staffCompleted") ? new uk.ac.reigate.domain.QStaff(forProperty("staffCompleted"), inits.get("staffCompleted")) : null;
    }
    
}
