package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QLearningSupportCostCategory is a Querydsl query type for LearningSupportCostCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLearningSupportCostCategory extends EntityPathBase<LearningSupportCostCategory> {
    
    private static final long serialVersionUID = -1150321819L;
    
    public static final QLearningSupportCostCategory learningSupportCostCategory = new QLearningSupportCostCategory("learningSupportCostCategory");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath category = createString("category");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QLearningSupportCostCategory(
        String variable) {
        super(LearningSupportCostCategory.class, forVariable(variable));
    }
    
    public QLearningSupportCostCategory(
        Path<? extends LearningSupportCostCategory> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QLearningSupportCostCategory(
        PathMetadata metadata) {
        super(LearningSupportCostCategory.class, metadata);
    }
    
}
