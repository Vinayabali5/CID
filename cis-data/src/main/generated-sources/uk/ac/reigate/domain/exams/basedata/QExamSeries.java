package uk.ac.reigate.domain.exams.basedata;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QExamSeries is a Querydsl query type for ExamSeries
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExamSeries extends EntityPathBase<ExamSeries> {
    
    private static final long serialVersionUID = 1184739046L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QExamSeries examSeries1 = new QExamSeries("examSeries1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final BooleanPath entrySubmitted = createBoolean("entrySubmitted");
    
    public final uk.ac.reigate.domain.exams.QExamBoard examBoard;
    
    public final StringPath examSeries = createString("examSeries");
    
    public final StringPath examYear = createString("examYear");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final NumberPath<Integer> nextSequenceNo = createNumber("nextSequenceNo", Integer.class);
    
    public final ListPath<Syllabus, QSyllabus> syllabi = this.<Syllabus, QSyllabus> createList("syllabi", Syllabus.class, QSyllabus.class, PathInits.DIRECT2);
    
    public QExamSeries(
        String variable) {
        this(ExamSeries.class, forVariable(variable), INITS);
    }
    
    public QExamSeries(
        Path<? extends ExamSeries> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QExamSeries(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QExamSeries(
        PathMetadata metadata,
        PathInits inits) {
        this(ExamSeries.class, metadata, inits);
    }
    
    public QExamSeries(
        Class<? extends ExamSeries> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
        this.examBoard = inits.isInitialized("examBoard") ? new uk.ac.reigate.domain.exams.QExamBoard(forProperty("examBoard")) : null;
    }
    
}
