package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QInterview is a Querydsl query type for Interview
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterview extends EntityPathBase<Interview> {
    
    private static final long serialVersionUID = 243314022L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QInterview interview = new QInterview("interview");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final DateTimePath<java.util.Date> interviewDate = createDateTime("interviewDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.QStaff interviewer;
    
    public final StringPath interviewNotes = createString("interviewNotes");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QOfferType offerType;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final uk.ac.reigate.domain.lookup.QStudentType studentType;
    
    public QInterview(
        String variable) {
        this(Interview.class, forVariable(variable), INITS);
    }
    
    public QInterview(
        Path<? extends Interview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QInterview(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QInterview(
        PathMetadata metadata,
        PathInits inits) {
        this(Interview.class, metadata, inits);
    }
    
    public QInterview(
        Class<? extends Interview> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.interviewer = inits.isInitialized("interviewer") ? new uk.ac.reigate.domain.QStaff(forProperty("interviewer"), inits.get("interviewer")) : null;
        this.offerType = inits.isInitialized("offerType") ? new QOfferType(forProperty("offerType")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.studentType = inits.isInitialized("studentType") ? new uk.ac.reigate.domain.lookup.QStudentType(forProperty("studentType")) : null;
    }
    
}
