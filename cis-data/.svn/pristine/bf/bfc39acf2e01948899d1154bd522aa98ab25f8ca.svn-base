package uk.ac.reigate.domain.exams.seatingplan;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QExamSeat is a Querydsl query type for ExamSeat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExamSeat extends EntityPathBase<ExamSeat> {
    
    private static final long serialVersionUID = -82333297L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QExamSeat examSeat = new QExamSeat("examSeat");
    
    public final NumberPath<Integer> col = createNumber("col", Integer.class);
    
    public final uk.ac.reigate.domain.exams.basedata.QExamComponent examComponent;
    
    public final QExamSeatingPlan examSeatingPlan;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> row = createNumber("row", Integer.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QExamSeat(
        String variable) {
        this(ExamSeat.class, forVariable(variable), INITS);
    }
    
    public QExamSeat(
        Path<? extends ExamSeat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QExamSeat(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QExamSeat(
        PathMetadata metadata,
        PathInits inits) {
        this(ExamSeat.class, metadata, inits);
    }
    
    public QExamSeat(
        Class<? extends ExamSeat> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examComponent = inits.isInitialized("examComponent") ? new uk.ac.reigate.domain.exams.basedata.QExamComponent(forProperty("examComponent"), inits.get("examComponent")) : null;
        this.examSeatingPlan = inits.isInitialized("examSeatingPlan") ? new QExamSeatingPlan(forProperty("examSeatingPlan"), inits.get("examSeatingPlan")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
