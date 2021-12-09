package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentPredictedGrade is a Querydsl query type for StudentPredictedGrade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentPredictedGrade extends EntityPathBase<StudentPredictedGrade> {
    
    private static final long serialVersionUID = 997976316L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentPredictedGrade studentPredictedGrade = new QStudentPredictedGrade("studentPredictedGrade");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.exams.QExamBoard examBoard;
    
    public final StringPath grade = createString("grade");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QEntryQualification predictedGrade;
    
    public final QStudent student;
    
    public QStudentPredictedGrade(
        String variable) {
        this(StudentPredictedGrade.class, forVariable(variable), INITS);
    }
    
    public QStudentPredictedGrade(
        Path<? extends StudentPredictedGrade> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentPredictedGrade(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentPredictedGrade(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentPredictedGrade.class, metadata, inits);
    }
    
    public QStudentPredictedGrade(
        Class<? extends StudentPredictedGrade> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examBoard = inits.isInitialized("examBoard") ? new uk.ac.reigate.domain.exams.QExamBoard(forProperty("examBoard")) : null;
        this.predictedGrade = inits.isInitialized("predictedGrade") ? new QEntryQualification(forProperty("predictedGrade"), inits.get("predictedGrade")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
