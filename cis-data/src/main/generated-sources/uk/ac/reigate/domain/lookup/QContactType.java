package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QContactType is a Querydsl query type for ContactType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContactType extends EntityPathBase<ContactType> {
    
    private static final long serialVersionUID = -192552305L;
    
    public static final QContactType contactType = new QContactType("contactType");
    
    public final uk.ac.reigate.domain.QNamedEntity _super = new uk.ac.reigate.domain.QNamedEntity(this);
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    // inherited
    public final StringPath name = _super.name;
    
    public QContactType(
        String variable) {
        super(ContactType.class, forVariable(variable));
    }
    
    public QContactType(
        Path<? extends ContactType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QContactType(
        PathMetadata metadata) {
        super(ContactType.class, metadata);
    }
    
}
