package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRequest is a Querydsl query type for Request
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequest extends EntityPathBase<Request> {
    
    private static final long serialVersionUID = 1819444148L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QRequest request1 = new QRequest("request1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final BooleanPath allocated = createBoolean("allocated");
    
    public final NumberPath<Integer> applicationId = createNumber("applicationId", Integer.class);
    
    public final BooleanPath broadeningSubject = createBoolean("broadeningSubject");
    
    public final BooleanPath chosenAgainstAdvice = createBoolean("chosenAgainstAdvice");
    
    public final BooleanPath coreAim = createBoolean("coreAim");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath request = createString("request");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QRequest(
        String variable) {
        this(Request.class, forVariable(variable), INITS);
    }
    
    public QRequest(
        Path<? extends Request> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QRequest(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QRequest(
        PathMetadata metadata,
        PathInits inits) {
        this(Request.class, metadata, inits);
    }
    
    public QRequest(
        Class<? extends Request> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
