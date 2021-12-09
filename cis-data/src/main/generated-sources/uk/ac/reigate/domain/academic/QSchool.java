package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QSchool is a Querydsl query type for School
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchool extends EntityPathBase<School> {
    
    private static final long serialVersionUID = -146855598L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QSchool school = new QSchool("school");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath contactEmail = createString("contactEmail");
    
    public final StringPath contactFirstName = createString("contactFirstName");
    
    public final StringPath contactSurname = createString("contactSurname");
    
    public final StringPath contactTitle = createString("contactTitle");
    
    public final StringPath headFirstName = createString("headFirstName");
    
    public final StringPath headSurname = createString("headSurname");
    
    public final StringPath headTitle = createString("headTitle");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath line1 = createString("line1");
    
    public final StringPath line2 = createString("line2");
    
    public final StringPath line3 = createString("line3");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public final StringPath postcode = createString("postcode");
    
    public final uk.ac.reigate.domain.lookup.QSchoolPriority priority;
    
    public final StringPath telephone = createString("telephone");
    
    public final uk.ac.reigate.domain.lookup.QSchoolType type;
    
    public final StringPath ukprn = createString("ukprn");
    
    public final StringPath urn = createString("urn");
    
    public QSchool(
        String variable) {
        this(School.class, forVariable(variable), INITS);
    }
    
    public QSchool(
        Path<? extends School> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QSchool(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QSchool(
        PathMetadata metadata,
        PathInits inits) {
        this(School.class, metadata, inits);
    }
    
    public QSchool(
        Class<? extends School> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.priority = inits.isInitialized("priority") ? new uk.ac.reigate.domain.lookup.QSchoolPriority(forProperty("priority")) : null;
        this.type = inits.isInitialized("type") ? new uk.ac.reigate.domain.lookup.QSchoolType(forProperty("type")) : null;
    }
    
}
