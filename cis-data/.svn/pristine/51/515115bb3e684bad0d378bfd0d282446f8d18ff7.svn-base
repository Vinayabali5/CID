package uk.ac.reigate.domain.exams.basedata;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QExamComponent is a Querydsl query type for ExamComponent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExamComponent extends EntityPathBase<ExamComponent> {
    
    private static final long serialVersionUID = 1984422446L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QExamComponent examComponent = new QExamComponent("examComponent");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath code = createString("code");
    
    public final DateTimePath<java.util.Date> dueDate = createDateTime("dueDate", java.util.Date.class);
    
    public final QExamSeries examSeries;
    
    public final StringPath gradeset = createString("gradeset");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final NumberPath<Integer> maximumMark = createNumber("maximumMark", Integer.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final ListPath<OptionComponent, QOptionComponent> optionComponents = this.<OptionComponent, QOptionComponent> createList("optionComponents", OptionComponent.class, QOptionComponent.class, PathInits.DIRECT2);
    
    public final StringPath teacherMarks = createString("teacherMarks");
    
    public final NumberPath<Integer> timeAllowed = createNumber("timeAllowed", Integer.class);
    
    public final StringPath timetabled = createString("timetabled");
    
    public final DateTimePath<java.util.Date> timetableDate = createDateTime("timetableDate", java.util.Date.class);
    
    public final StringPath timetableSession = createString("timetableSession");
    
    public final StringPath title = createString("title");
    
    public QExamComponent(
        String variable) {
        this(ExamComponent.class, forVariable(variable), INITS);
    }
    
    public QExamComponent(
        Path<? extends ExamComponent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QExamComponent(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QExamComponent(
        PathMetadata metadata,
        PathInits inits) {
        this(ExamComponent.class, metadata, inits);
    }
    
    public QExamComponent(
        Class<? extends ExamComponent> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examSeries = inits.isInitialized("examSeries") ? new QExamSeries(forProperty("examSeries"), inits.get("examSeries")) : null;
    }
    
}
