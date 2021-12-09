package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentEntryQualification is a Querydsl query type for StudentEntryQualification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentEntryQualification extends EntityPathBase<StudentEntryQualification> {
    
    private static final long serialVersionUID = 1826278810L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentEntryQualification studentEntryQualification = new QStudentEntryQualification("studentEntryQualification");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath checked = createBoolean("checked");
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    public final uk.ac.reigate.domain.exams.QExamBoard examBoard;
    
    public final StringPath grade = createString("grade");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QEntryQualification qualification;
    
    public final QStudent student;
    
    public QStudentEntryQualification(
        String variable) {
        this(StudentEntryQualification.class, forVariable(variable), INITS);
    }
    
    public QStudentEntryQualification(
        Path<? extends StudentEntryQualification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentEntryQualification(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentEntryQualification(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentEntryQualification.class, metadata, inits);
    }
    
    public QStudentEntryQualification(
        Class<? extends StudentEntryQualification> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examBoard = inits.isInitialized("examBoard") ? new uk.ac.reigate.domain.exams.QExamBoard(forProperty("examBoard")) : null;
        this.qualification = inits.isInitialized("qualification") ? new QEntryQualification(forProperty("qualification"), inits.get("qualification")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
