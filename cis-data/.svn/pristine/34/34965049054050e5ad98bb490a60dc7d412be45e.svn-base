package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QContact is a Querydsl query type for Contact
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContact extends EntityPathBase<Contact> {
    
    private static final long serialVersionUID = -1962933769L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QContact contact1 = new QContact("contact1");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final BooleanPath alternativeAddress = createBoolean("alternativeAddress");
    
    public final QPerson contact;
    
    public final BooleanPath contactable = createBoolean("contactable");
    
    public final SimplePath<Object> contactId = createSimple("contactId", Object.class);
    
    public final uk.ac.reigate.domain.lookup.QContactType contactType;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QPerson person;
    
    public final BooleanPath preferred = createBoolean("preferred");
    
    public QContact(
        String variable) {
        this(Contact.class, forVariable(variable), INITS);
    }
    
    public QContact(
        Path<? extends Contact> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QContact(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QContact(
        PathMetadata metadata,
        PathInits inits) {
        this(Contact.class, metadata, inits);
    }
    
    public QContact(
        Class<? extends Contact> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.contact = inits.isInitialized("contact") ? new QPerson(forProperty("contact"), inits.get("contact")) : null;
        this.contactType = inits.isInitialized("contactType") ? new uk.ac.reigate.domain.lookup.QContactType(forProperty("contactType")) : null;
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person"), inits.get("person")) : null;
    }
    
}
