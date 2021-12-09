package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentCareersRecord is a Querydsl query type for StudentCareersRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentCareersRecord extends EntityPathBase<StudentCareersRecord> {
    
    private static final long serialVersionUID = 1308933193L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentCareersRecord studentCareersRecord = new QStudentCareersRecord("studentCareersRecord");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final QCareersRecordType careersRecordType;
    
    public final StringPath employerInstitution = createString("employerInstitution");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath note = createString("note");
    
    public final StringPath organiser = createString("organiser");
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QStudent student;
    
    public QStudentCareersRecord(
        String variable) {
        this(StudentCareersRecord.class, forVariable(variable), INITS);
    }
    
    public QStudentCareersRecord(
        Path<? extends StudentCareersRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentCareersRecord(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentCareersRecord(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentCareersRecord.class, metadata, inits);
    }
    
    public QStudentCareersRecord(
        Class<? extends StudentCareersRecord> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.careersRecordType = inits.isInitialized("careersRecordType") ? new QCareersRecordType(forProperty("careersRecordType")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
