package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QInterviewCategory is a Querydsl query type for InterviewCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterviewCategory extends EntityPathBase<InterviewCategory> {
    
    private static final long serialVersionUID = -408614780L;
    
    public static final QInterviewCategory interviewCategory = new QInterviewCategory("interviewCategory");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath category = createString("category");
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QInterviewCategory(
        String variable) {
        super(InterviewCategory.class, forVariable(variable));
    }
    
    public QInterviewCategory(
        Path<? extends InterviewCategory> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QInterviewCategory(
        PathMetadata metadata) {
        super(InterviewCategory.class, metadata);
    }
    
}
