package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCorrespondence is a Querydsl query type for Correspondence
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCorrespondence extends EntityPathBase<Correspondence> {
    
    private static final long serialVersionUID = 870987204L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCorrespondence correspondence1 = new QCorrespondence("correspondence1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath attachmentsSent = createString("attachmentsSent");
    
    public final StringPath correspondence = createString("correspondence");
    
    public final uk.ac.reigate.domain.academic.QCourseGroup course;
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    public final StringPath from = createString("from");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final QLetter letter;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath privateEntry = createBoolean("privateEntry");
    
    public final NumberPath<Integer> processStage = createNumber("processStage", Integer.class);
    
    public final StringPath producedBy = createString("producedBy");
    
    public final DateTimePath<java.util.Date> staffAdvised = createDateTime("staffAdvised", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath title = createString("title");
    
    public final StringPath to = createString("to");
    
    public final QCorrespondenceType type;
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QCorrespondence(
        String variable) {
        this(Correspondence.class, forVariable(variable), INITS);
    }
    
    public QCorrespondence(
        Path<? extends Correspondence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCorrespondence(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCorrespondence(
        PathMetadata metadata,
        PathInits inits) {
        this(Correspondence.class, metadata, inits);
    }
    
    public QCorrespondence(
        Class<? extends Correspondence> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("course"), inits.get("course")) : null;
        this.letter = inits.isInitialized("letter") ? new QLetter(forProperty("letter"), inits.get("letter")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.type = inits.isInitialized("type") ? new QCorrespondenceType(forProperty("type")) : null;
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
