package uk.ac.reigate.domain.exams.edi;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEdiAuditEntryLog is a Querydsl query type for EdiAuditEntryLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEdiAuditEntryLog extends EntityPathBase<EdiAuditEntryLog> {
    
    private static final long serialVersionUID = 809577194L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QEdiAuditEntryLog ediAuditEntryLog = new QEdiAuditEntryLog("ediAuditEntryLog");
    
    public final QEdiAuditFileLog ediAuditFileLog;
    
    public final uk.ac.reigate.domain.exams.basedata.QExamOption examOption;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QEdiAuditEntryLog(
        String variable) {
        this(EdiAuditEntryLog.class, forVariable(variable), INITS);
    }
    
    public QEdiAuditEntryLog(
        Path<? extends EdiAuditEntryLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QEdiAuditEntryLog(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QEdiAuditEntryLog(
        PathMetadata metadata,
        PathInits inits) {
        this(EdiAuditEntryLog.class, metadata, inits);
    }
    
    public QEdiAuditEntryLog(
        Class<? extends EdiAuditEntryLog> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.ediAuditFileLog = inits.isInitialized("ediAuditFileLog") ? new QEdiAuditFileLog(forProperty("ediAuditFileLog"), inits.get("ediAuditFileLog")) : null;
        this.examOption = inits.isInitialized("examOption") ? new uk.ac.reigate.domain.exams.basedata.QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
