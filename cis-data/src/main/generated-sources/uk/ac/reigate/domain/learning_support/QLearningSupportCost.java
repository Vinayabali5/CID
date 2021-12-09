package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QLearningSupportCost is a Querydsl query type for LearningSupportCost
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLearningSupportCost extends EntityPathBase<LearningSupportCost> {
    
    private static final long serialVersionUID = 179867975L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QLearningSupportCost learningSupportCost = new QLearningSupportCost("learningSupportCost");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final QLearningSupportCostCategory costCategory;
    
    public final StringPath description = createString("description");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final NumberPath<Double> hoursPerWeek = createNumber("hoursPerWeek", Double.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath periodDescription = createString("periodDescription");
    
    public final NumberPath<Double> rate = createNumber("rate", Double.class);
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final NumberPath<Double> weeks = createNumber("weeks", Double.class);
    
    public QLearningSupportCost(
        String variable) {
        this(LearningSupportCost.class, forVariable(variable), INITS);
    }
    
    public QLearningSupportCost(
        Path<? extends LearningSupportCost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QLearningSupportCost(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QLearningSupportCost(
        PathMetadata metadata,
        PathInits inits) {
        this(LearningSupportCost.class, metadata, inits);
    }
    
    public QLearningSupportCost(
        Class<? extends LearningSupportCost> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.costCategory = inits.isInitialized("costCategory") ? new QLearningSupportCostCategory(forProperty("costCategory")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
