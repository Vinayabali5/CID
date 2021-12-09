package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QApplicationStatus is a Querydsl query type for ApplicationStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicationStatus extends EntityPathBase<ApplicationStatus> {
    
    private static final long serialVersionUID = -694047673L;
    
    public static final QApplicationStatus applicationStatus = new QApplicationStatus("applicationStatus");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    public final BooleanPath considerWithdrawn = createBoolean("considerWithdrawn");
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QApplicationStatus(
        String variable) {
        super(ApplicationStatus.class, forVariable(variable));
    }
    
    public QApplicationStatus(
        Path<? extends ApplicationStatus> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QApplicationStatus(
        PathMetadata metadata) {
        super(ApplicationStatus.class, metadata);
    }
    
}
