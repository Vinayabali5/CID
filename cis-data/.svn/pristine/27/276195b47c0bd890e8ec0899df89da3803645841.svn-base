package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentLearningSupport is a Querydsl query type for StudentLearningSupport
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentLearningSupport extends EntityPathBase<StudentLearningSupport> {
    
    private static final long serialVersionUID = -2048024723L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentLearningSupport studentLearningSupport = new QStudentLearningSupport("studentLearningSupport");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    public final DateTimePath<java.util.Date> assessmentDate = createDateTime("assessmentDate", java.util.Date.class);
    
    public final BooleanPath btecConcessionApproved = createBoolean("btecConcessionApproved");
    
    public final BooleanPath concessionApplication = createBoolean("concessionApplication");
    
    public final BooleanPath examConcessionApproved = createBoolean("examConcessionApproved");
    
    public final BooleanPath fsConcessionApproved = createBoolean("fsConcessionApproved");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath previousConcession = createString("previousConcession");
    
    public final StringPath referralNotes = createString("referralNotes");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath supportNotes = createString("supportNotes");
    
    public final QSupportType supportType;
    
    public QStudentLearningSupport(
        String variable) {
        this(StudentLearningSupport.class, forVariable(variable), INITS);
    }
    
    public QStudentLearningSupport(
        Path<? extends StudentLearningSupport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentLearningSupport(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentLearningSupport(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentLearningSupport.class, metadata, inits);
    }
    
    public QStudentLearningSupport(
        Class<? extends StudentLearningSupport> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.supportType = inits.isInitialized("supportType") ? new QSupportType(forProperty("supportType")) : null;
    }
    
}
