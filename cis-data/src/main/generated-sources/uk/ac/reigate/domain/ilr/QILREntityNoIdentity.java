package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QILREntityNoIdentity is a Querydsl query type for ILREntityNoIdentity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QILREntityNoIdentity extends EntityPathBase<ILREntityNoIdentity> {
    
    private static final long serialVersionUID = -766879031L;
    
    public static final QILREntityNoIdentity iLREntityNoIdentity = new QILREntityNoIdentity("iLREntityNoIdentity");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath shortDescription = createString("shortDescription");
    
    public final DateTimePath<java.util.Date> validFrom = createDateTime("validFrom", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> validTo = createDateTime("validTo", java.util.Date.class);
    
    public QILREntityNoIdentity(
        String variable) {
        super(ILREntityNoIdentity.class, forVariable(variable));
    }
    
    public QILREntityNoIdentity(
        Path<? extends ILREntityNoIdentity> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QILREntityNoIdentity(
        PathMetadata metadata) {
        super(ILREntityNoIdentity.class, metadata);
    }
    
}
