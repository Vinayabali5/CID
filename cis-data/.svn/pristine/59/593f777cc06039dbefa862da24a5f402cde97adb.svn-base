package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QLetter is a Querydsl query type for Letter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLetter extends EntityPathBase<Letter> {
    
    private static final long serialVersionUID = 1360294992L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QLetter letter = new QLetter("letter");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath attendance = createBoolean("attendance");
    
    public final DateTimePath<java.util.Date> authorisedDate = createDateTime("authorisedDate", java.util.Date.class);
    
    public final BooleanPath behaviour = createBoolean("behaviour");
    
    public final QCorrespondenceType correspondenceType;
    
    public final BooleanPath deadlines = createBoolean("deadlines");
    
    public final BooleanPath focus = createBoolean("focus");
    
    public final BooleanPath homework = createBoolean("homework");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath incompleteCoursework = createBoolean("incompleteCoursework");
    
    public final BooleanPath insufficientProgress = createBoolean("insufficientProgress");
    
    public final QILPInterview interview;
    
    public final BooleanPath irImproveAttendance = createBoolean("irImproveAttendance");
    
    public final BooleanPath irImproveEffort = createBoolean("irImproveEffort");
    
    public final BooleanPath irWillAddress = createBoolean("irWillAddress");
    
    public final DateTimePath<java.util.Date> letterDate = createDateTime("letterDate", java.util.Date.class);
    
    public final QLetterType letterType;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QLetterWarningParagraph nonEntryWarning;
    
    public final uk.ac.reigate.domain.QStaff pending;
    
    public final DateTimePath<java.util.Date> printedDate = createDateTime("printedDate", java.util.Date.class);
    
    public final NumberPath<Integer> processingFlag = createNumber("processingFlag", Integer.class);
    
    public final BooleanPath punctuality = createBoolean("punctuality");
    
    public final StringPath regarding = createString("regarding");
    
    public final uk.ac.reigate.domain.QStaff requestedBy;
    
    public final DateTimePath<java.util.Date> requestedDate = createDateTime("requestedDate", java.util.Date.class);
    
    public final BooleanPath reviewMeeting = createBoolean("reviewMeeting");
    
    public final DateTimePath<java.util.Date> sendAfter = createDateTime("sendAfter", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final BooleanPath studentCopiedIn = createBoolean("studentCopiedIn");
    
    public final StringPath subject = createString("subject");
    
    public final uk.ac.reigate.domain.QStaff writtenBy;
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QLetter(
        String variable) {
        this(Letter.class, forVariable(variable), INITS);
    }
    
    public QLetter(
        Path<? extends Letter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QLetter(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QLetter(
        PathMetadata metadata,
        PathInits inits) {
        this(Letter.class, metadata, inits);
    }
    
    public QLetter(
        Class<? extends Letter> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.correspondenceType = inits.isInitialized("correspondenceType") ? new QCorrespondenceType(forProperty("correspondenceType")) : null;
        this.interview = inits.isInitialized("interview") ? new QILPInterview(forProperty("interview"), inits.get("interview")) : null;
        this.letterType = inits.isInitialized("letterType") ? new QLetterType(forProperty("letterType")) : null;
        this.nonEntryWarning = inits.isInitialized("nonEntryWarning") ? new QLetterWarningParagraph(forProperty("nonEntryWarning")) : null;
        this.pending = inits.isInitialized("pending") ? new uk.ac.reigate.domain.QStaff(forProperty("pending"), inits.get("pending")) : null;
        this.requestedBy = inits.isInitialized("requestedBy") ? new uk.ac.reigate.domain.QStaff(forProperty("requestedBy"), inits.get("requestedBy")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.writtenBy = inits.isInitialized("writtenBy") ? new uk.ac.reigate.domain.QStaff(forProperty("writtenBy"), inits.get("writtenBy")) : null;
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
