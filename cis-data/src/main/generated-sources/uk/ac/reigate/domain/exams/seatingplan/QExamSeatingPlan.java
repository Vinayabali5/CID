package uk.ac.reigate.domain.exams.seatingplan;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QExamSeatingPlan is a Querydsl query type for ExamSeatingPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExamSeatingPlan extends EntityPathBase<ExamSeatingPlan> {
    
    private static final long serialVersionUID = -674490948L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QExamSeatingPlan examSeatingPlan = new QExamSeatingPlan("examSeatingPlan");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final NumberPath<Integer> cols = createNumber("cols", Integer.class);
    
    public final QExamSession examSession;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.QRoom room;
    
    public final NumberPath<Integer> rows = createNumber("rows", Integer.class);
    
    public QExamSeatingPlan(
        String variable) {
        this(ExamSeatingPlan.class, forVariable(variable), INITS);
    }
    
    public QExamSeatingPlan(
        Path<? extends ExamSeatingPlan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QExamSeatingPlan(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QExamSeatingPlan(
        PathMetadata metadata,
        PathInits inits) {
        this(ExamSeatingPlan.class, metadata, inits);
    }
    
    public QExamSeatingPlan(
        Class<? extends ExamSeatingPlan> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examSession = inits.isInitialized("examSession") ? new QExamSession(forProperty("examSession")) : null;
        this.room = inits.isInitialized("room") ? new uk.ac.reigate.domain.QRoom(forProperty("room"), inits.get("room")) : null;
    }
    
}
