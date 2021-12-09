package uk.ac.reigate.domain.exams.edi;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEdiAuditFileLog is a Querydsl query type for EdiAuditFileLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEdiAuditFileLog extends EntityPathBase<EdiAuditFileLog> {
    
    private static final long serialVersionUID = -345722960L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QEdiAuditFileLog ediAuditFileLog = new QEdiAuditFileLog("ediAuditFileLog");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath ediFileName = createString("ediFileName");
    
    public final uk.ac.reigate.domain.exams.basedata.QExamSeries examSeries;
    
    public final DateTimePath<java.util.Date> fileTimeStamp = createDateTime("fileTimeStamp", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QEdiAuditFileLog(
        String variable) {
        this(EdiAuditFileLog.class, forVariable(variable), INITS);
    }
    
    public QEdiAuditFileLog(
        Path<? extends EdiAuditFileLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QEdiAuditFileLog(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QEdiAuditFileLog(
        PathMetadata metadata,
        PathInits inits) {
        this(EdiAuditFileLog.class, metadata, inits);
    }
    
    public QEdiAuditFileLog(
        Class<? extends EdiAuditFileLog> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examSeries = inits.isInitialized("examSeries") ? new uk.ac.reigate.domain.exams.basedata.QExamSeries(forProperty("examSeries"), inits.get("examSeries")) : null;
    }
    
}
