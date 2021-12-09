package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QILPInterview is a Querydsl query type for ILPInterview
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QILPInterview extends EntityPathBase<ILPInterview> {
    
    private static final long serialVersionUID = -315541250L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QILPInterview iLPInterview = new QILPInterview("iLPInterview");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final uk.ac.reigate.domain.academic.QCourseGroup courseGroup;
    
    public final StringPath discussion = createString("discussion");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final DateTimePath<java.util.Date> interviewDate = createDateTime("interviewDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> interviewTime = createDateTime("interviewTime", java.util.Date.class);
    
    public final QLetter letter;
    
    public final BooleanPath letterSent = createBoolean("letterSent");
    
    public final DateTimePath<java.util.Date> lipReferDate = createDateTime("lipReferDate", java.util.Date.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QOfficeAction officeAction;
    
    public final StringPath officeActionString = createString("officeActionString");
    
    public final StringPath officeNotes = createString("officeNotes");
    
    public final BooleanPath privateEntry = createBoolean("privateEntry");
    
    public final BooleanPath referLip = createBoolean("referLip");
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath target = createString("target");
    
    public final DateTimePath<java.util.Date> targetByDate = createDateTime("targetByDate", java.util.Date.class);
    
    public final StringPath targetByWhen = createString("targetByWhen");
    
    public final NumberPath<Integer> targetProgress = createNumber("targetProgress", Integer.class);
    
    public final DateTimePath<java.util.Date> targetProgressDate = createDateTime("targetProgressDate", java.util.Date.class);
    
    public final BooleanPath toFile = createBoolean("toFile");
    
    public final QILPInterviewType type;
    
    public QILPInterview(
        String variable) {
        this(ILPInterview.class, forVariable(variable), INITS);
    }
    
    public QILPInterview(
        Path<? extends ILPInterview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QILPInterview(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QILPInterview(
        PathMetadata metadata,
        PathInits inits) {
        this(ILPInterview.class, metadata, inits);
    }
    
    public QILPInterview(
        Class<? extends ILPInterview> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.courseGroup = inits.isInitialized("courseGroup") ? new uk.ac.reigate.domain.academic.QCourseGroup(forProperty("courseGroup"), inits.get("courseGroup")) : null;
        this.letter = inits.isInitialized("letter") ? new QLetter(forProperty("letter"), inits.get("letter")) : null;
        this.officeAction = inits.isInitialized("officeAction") ? new QOfficeAction(forProperty("officeAction")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.type = inits.isInitialized("type") ? new QILPInterviewType(forProperty("type")) : null;
    }
    
}
