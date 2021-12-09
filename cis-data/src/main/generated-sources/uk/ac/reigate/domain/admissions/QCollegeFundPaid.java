package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCollegeFundPaid is a Querydsl query type for CollegeFundPaid
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCollegeFundPaid extends EntityPathBase<CollegeFundPaid> {
    
    private static final long serialVersionUID = -216929779L;
    
    public static final QCollegeFundPaid collegeFundPaid1 = new QCollegeFundPaid("collegeFundPaid1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath collegeFundPaid = createString("collegeFundPaid");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QCollegeFundPaid(
        String variable) {
        super(CollegeFundPaid.class, forVariable(variable));
    }
    
    public QCollegeFundPaid(
        Path<? extends CollegeFundPaid> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCollegeFundPaid(
        PathMetadata metadata) {
        super(CollegeFundPaid.class, metadata);
    }
    
}
