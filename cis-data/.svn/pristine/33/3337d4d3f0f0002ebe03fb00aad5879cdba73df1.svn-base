package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentOptionEntry is a Querydsl query type for StudentOptionEntry
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentOptionEntry extends EntityPathBase<StudentOptionEntry> {
    
    private static final long serialVersionUID = 1965696709L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentOptionEntry studentOptionEntry = new QStudentOptionEntry("studentOptionEntry");
    
    public final uk.ac.reigate.domain.exams.edi.QEdiStatusType ediStatusType;
    
    public final uk.ac.reigate.domain.exams.basedata.QExamOption examOption;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final BooleanPath privateStudent = createBoolean("privateStudent");
    
    public final BooleanPath resit = createBoolean("resit");
    
    public final uk.ac.reigate.domain.exams.edi.QStatusType statusType;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentOptionEntry(
        String variable) {
        this(StudentOptionEntry.class, forVariable(variable), INITS);
    }
    
    public QStudentOptionEntry(
        Path<? extends StudentOptionEntry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentOptionEntry(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentOptionEntry(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentOptionEntry.class, metadata, inits);
    }
    
    public QStudentOptionEntry(
        Class<? extends StudentOptionEntry> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.ediStatusType = inits.isInitialized("ediStatusType") ? new uk.ac.reigate.domain.exams.edi.QEdiStatusType(forProperty("ediStatusType")) : null;
        this.examOption = inits.isInitialized("examOption") ? new uk.ac.reigate.domain.exams.basedata.QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
        this.statusType = inits.isInitialized("statusType") ? new uk.ac.reigate.domain.exams.edi.QStatusType(forProperty("statusType")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
