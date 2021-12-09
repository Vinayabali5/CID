package uk.ac.reigate.domain.audit;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QApiAccessLog is a Querydsl query type for ApiAccessLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApiAccessLog extends EntityPathBase<ApiAccessLog> {
    
    private static final long serialVersionUID = 494901058L;
    
    public static final QApiAccessLog apiAccessLog = new QApiAccessLog("apiAccessLog");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> accessTime = createDateTime("accessTime", java.util.Date.class);
    
    public final StringPath content = createString("content");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath method = createString("method");
    
    public final StringPath params = createString("params");
    
    public final StringPath remoteHost = createString("remoteHost");
    
    public final StringPath uri = createString("uri");
    
    public final StringPath username = createString("username");
    
    public QApiAccessLog(
        String variable) {
        super(ApiAccessLog.class, forVariable(variable));
    }
    
    public QApiAccessLog(
        Path<? extends ApiAccessLog> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QApiAccessLog(
        PathMetadata metadata) {
        super(ApiAccessLog.class, metadata);
    }
    
}
