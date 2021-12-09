package uk.ac.reigate.domain.exams.edi;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QEdiAuditEntryLogPk is a Querydsl query type for EdiAuditEntryLogPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QEdiAuditEntryLogPk extends BeanPath<EdiAuditEntryLogPk> {
    
    private static final long serialVersionUID = 614605445L;
    
    public static final QEdiAuditEntryLogPk ediAuditEntryLogPk = new QEdiAuditEntryLogPk("ediAuditEntryLogPk");
    
    public final NumberPath<Integer> ediAuditFileLog = createNumber("ediAuditFileLog", Integer.class);
    
    public final NumberPath<Integer> examOption = createNumber("examOption", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QEdiAuditEntryLogPk(
        String variable) {
        super(EdiAuditEntryLogPk.class, forVariable(variable));
    }
    
    public QEdiAuditEntryLogPk(
        Path<? extends EdiAuditEntryLogPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QEdiAuditEntryLogPk(
        PathMetadata metadata) {
        super(EdiAuditEntryLogPk.class, metadata);
    }
    
}
