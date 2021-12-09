package uk.ac.reigate.domain.exams.basedata;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QSyllabus is a Querydsl query type for Syllabus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSyllabus extends EntityPathBase<Syllabus> {
    
    private static final long serialVersionUID = -578483883L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QSyllabus syllabus = new QSyllabus("syllabus");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath code = createString("code");
    
    public final ListPath<ExamOption, QExamOption> examOptions = this.<ExamOption, QExamOption> createList("examOptions", ExamOption.class, QExamOption.class, PathInits.DIRECT2);
    
    public final QExamSeries examSeries;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath title = createString("title");
    
    public QSyllabus(
        String variable) {
        this(Syllabus.class, forVariable(variable), INITS);
    }
    
    public QSyllabus(
        Path<? extends Syllabus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QSyllabus(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QSyllabus(
        PathMetadata metadata,
        PathInits inits) {
        this(Syllabus.class, metadata, inits);
    }
    
    public QSyllabus(
        Class<? extends Syllabus> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examSeries = inits.isInitialized("examSeries") ? new QExamSeries(forProperty("examSeries"), inits.get("examSeries")) : null;
    }
    
}
