package uk.ac.reigate.domain.register;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRegisteredSession is a Querydsl query type for RegisteredSession
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegisteredSession extends EntityPathBase<RegisteredSession> {
    
    private static final long serialVersionUID = 586826674L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QRegisteredSession registeredSession = new QRegisteredSession("registeredSession");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.academic.QPeriod period;
    
    public QRegisteredSession(
        String variable) {
        this(RegisteredSession.class, forVariable(variable), INITS);
    }
    
    public QRegisteredSession(
        Path<? extends RegisteredSession> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QRegisteredSession(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QRegisteredSession(
        PathMetadata metadata,
        PathInits inits) {
        this(RegisteredSession.class, metadata, inits);
    }
    
    public QRegisteredSession(
        Class<? extends RegisteredSession> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.period = inits.isInitialized("period") ? new uk.ac.reigate.domain.academic.QPeriod(forProperty("period"), inits.get("period")) : null;
    }
    
}
