package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {
    
    private static final long serialVersionUID = 1269573278L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QPerson person = new QPerson("person");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final BooleanPath accountNonExpired = createBoolean("accountNonExpired");
    
    public final BooleanPath accountNonLocked = createBoolean("accountNonLocked");
    
    public final QAddress address;
    
    public final CollectionPath<org.springframework.security.core.GrantedAuthority, SimplePath<org.springframework.security.core.GrantedAuthority>> authorities = this.<org.springframework.security.core.GrantedAuthority, SimplePath<org.springframework.security.core.GrantedAuthority>> createCollection("authorities", org.springframework.security.core.GrantedAuthority.class, SimplePath.class, PathInits.DIRECT2);
    
    public final ListPath<Contact, QContact> contacts = this.<Contact, QContact> createList("contacts", Contact.class, QContact.class, PathInits.DIRECT2);
    
    public final BooleanPath credentialsNonExpired = createBoolean("credentialsNonExpired");
    
    public final DateTimePath<java.util.Date> dob = createDateTime("dob", java.util.Date.class);
    
    public final StringPath email = createString("email");
    
    public final BooleanPath enabled = createBoolean("enabled");
    
    public final StringPath firstName = createString("firstName");
    
    public final uk.ac.reigate.domain.lookup.QGender gender;
    
    public final StringPath home = createString("home");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final uk.ac.reigate.domain.lookup.QLegalSex legalSex;
    
    public final StringPath legalSurname = createString("legalSurname");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath middleNames = createString("middleNames");
    
    public final StringPath mobile = createString("mobile");
    
    public final SetPath<Note, QNote> notes = this.<Note, QNote> createSet("notes", Note.class, QNote.class, PathInits.DIRECT2);
    
    public final StringPath password = createString("password");
    
    public final StringPath preferredName = createString("preferredName");
    
    public final StringPath previousSurname = createString("previousSurname");
    
    public final ArrayPath<byte[], Byte> rfidCardId = createArray("rfidCardId", byte[].class);
    
    public final SetPath<uk.ac.reigate.domain.security.Role, uk.ac.reigate.domain.security.QRole> roles = this.<uk.ac.reigate.domain.security.Role, uk.ac.reigate.domain.security.QRole> createSet("roles", uk.ac.reigate.domain.security.Role.class, uk.ac.reigate.domain.security.QRole.class, PathInits.DIRECT2);
    
    public final QStaff staff;
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final StringPath surname = createString("surname");
    
    public final uk.ac.reigate.domain.lookup.QTitle title;
    
    public final StringPath username = createString("username");
    
    public final StringPath work = createString("work");
    
    public QPerson(
        String variable) {
        this(Person.class, forVariable(variable), INITS);
    }
    
    public QPerson(
        Path<? extends Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QPerson(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QPerson(
        PathMetadata metadata,
        PathInits inits) {
        this(Person.class, metadata, inits);
    }
    
    public QPerson(
        Class<? extends Person> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.gender = inits.isInitialized("gender") ? new uk.ac.reigate.domain.lookup.QGender(forProperty("gender")) : null;
        this.legalSex = inits.isInitialized("legalSex") ? new uk.ac.reigate.domain.lookup.QLegalSex(forProperty("legalSex")) : null;
        this.staff = inits.isInitialized("staff") ? new QStaff(forProperty("staff"), inits.get("staff")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
        this.title = inits.isInitialized("title") ? new uk.ac.reigate.domain.lookup.QTitle(forProperty("title")) : null;
    }
    
}
