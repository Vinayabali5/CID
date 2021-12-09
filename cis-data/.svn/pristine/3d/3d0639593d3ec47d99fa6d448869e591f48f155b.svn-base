package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QResults is a Querydsl query type for Results
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResults extends EntityPathBase<Results> {
    
    private static final long serialVersionUID = -2014876461L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QResults results = new QResults("results");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final NumberPath<Integer> candidateNo = createNumber("candidateNo", Integer.class);
    
    public final NumberPath<Integer> courseId = createNumber("courseId", Integer.class);
    
    public final StringPath ediFile = createString("ediFile");
    
    public final StringPath endorsementToFirstGrade = createString("endorsementToFirstGrade");
    
    public final StringPath endorsementToFirstGradePartialAbsence = createString("endorsementToFirstGradePartialAbsence");
    
    public final StringPath endorsementToSecondGrade = createString("endorsementToSecondGrade");
    
    public final StringPath endorsementToSecondGradePartialAbsence = createString("endorsementToSecondGradePartialAbsence");
    
    public final StringPath entryCode = createString("entryCode");
    
    public final QExamBoard examBoard;
    
    public final DateTimePath<java.util.Date> examDate = createDateTime("examDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.exams.basedata.QExamOption examOption;
    
    public final StringPath examSeries = createString("examSeries");
    
    public final StringPath examYear = createString("examYear");
    
    public final StringPath firstGradePartialAbsence = createString("firstGradePartialAbsence");
    
    public final StringPath grade = createString("grade");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final DateTimePath<java.util.Date> importDate = createDateTime("importDate", java.util.Date.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath notes = createString("notes");
    
    public final StringPath resultsCode = createString("resultsCode");
    
    public final StringPath resultsType = createString("resultsType");
    
    public final StringPath score = createString("score");
    
    public final StringPath secondGradePartialAbsence = createString("secondGradePartialAbsence");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath uci = createString("uci");
    
    public final StringPath uln = createString("uln");
    
    public QResults(
        String variable) {
        this(Results.class, forVariable(variable), INITS);
    }
    
    public QResults(
        Path<? extends Results> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QResults(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QResults(
        PathMetadata metadata,
        PathInits inits) {
        this(Results.class, metadata, inits);
    }
    
    public QResults(
        Class<? extends Results> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.examBoard = inits.isInitialized("examBoard") ? new QExamBoard(forProperty("examBoard")) : null;
        this.examOption = inits.isInitialized("examOption") ? new uk.ac.reigate.domain.exams.basedata.QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
