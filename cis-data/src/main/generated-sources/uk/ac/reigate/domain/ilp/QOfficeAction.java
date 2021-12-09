package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QOfficeAction is a Querydsl query type for OfficeAction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOfficeAction extends EntityPathBase<OfficeAction> {
    
    private static final long serialVersionUID = -217729860L;
    
    public static final QOfficeAction officeAction = new QOfficeAction("officeAction");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    public final StringPath action = createString("action");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QOfficeAction(
        String variable) {
        super(OfficeAction.class, forVariable(variable));
    }
    
    public QOfficeAction(
        Path<? extends OfficeAction> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QOfficeAction(
        PathMetadata metadata) {
        super(OfficeAction.class, metadata);
    }
    
}
