package uk.ac.reigate.domain.exams.seatingplan;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QExamSession is a Querydsl query type for ExamSession
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExamSession extends EntityPathBase<ExamSession> {
    
    private static final long serialVersionUID = -348226868L;
    
    public static final QExamSession examSession = new QExamSession("examSession");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath session = createString("session");
    
    public QExamSession(
        String variable) {
        super(ExamSession.class, forVariable(variable));
    }
    
    public QExamSession(
        Path<? extends ExamSession> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QExamSession(
        PathMetadata metadata) {
        super(ExamSession.class, metadata);
    }
    
}
