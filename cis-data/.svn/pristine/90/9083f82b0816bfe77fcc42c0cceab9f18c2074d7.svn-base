package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaff is a Querydsl query type for Staff
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaff extends EntityPathBase<Staff> {
    
    private static final long serialVersionUID = -1202771337L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaff staff = new QStaff("staff");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> continualServiceStartDate = createDateTime("continualServiceStartDate", java.util.Date.class);
    
    public final StringPath dfeNumber = createString("dfeNumber");
    
    public final uk.ac.reigate.domain.staff.QDisability disability;
    
    public final StringPath emergencyContactName = createString("emergencyContactName");
    
    public final StringPath emergencyContactNumber = createString("emergencyContactNumber");
    
    public final StringPath emergencyContactRelationship = createString("emergencyContactRelationship");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.lookup.QEthnicity ethnicity;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final StringPath initials = createString("initials");
    
    public final StringPath knownAs = createString("knownAs");
    
    public final uk.ac.reigate.domain.staff.QMaritalStatus maritalStatus;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath nationality = createString("nationality");
    
    public final StringPath networkLogin = createString("networkLogin");
    
    public final StringPath niNumber = createString("niNumber");
    
    public final BooleanPath onTimetable = createBoolean("onTimetable");
    
    public final QPerson person;
    
    public final uk.ac.reigate.domain.staff.QReligion religion;
    
    public final uk.ac.reigate.domain.staff.QSexualOrientation sexualOrientation;
    
    public final StringPath signature = createString("signature");
    
    public final NumberPath<Integer> staffDetailsId = createNumber("staffDetailsId", Integer.class);
    
    public final StringPath staffEmail = createString("staffEmail");
    
    public final NumberPath<Integer> staffRef = createNumber("staffRef", Integer.class);
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.lookup.QStaffType type;
    
    public QStaff(
        String variable) {
        this(Staff.class, forVariable(variable), INITS);
    }
    
    public QStaff(
        Path<? extends Staff> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaff(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaff(
        PathMetadata metadata,
        PathInits inits) {
        this(Staff.class, metadata, inits);
    }
    
    public QStaff(
        Class<? extends Staff> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.disability = inits.isInitialized("disability") ? new uk.ac.reigate.domain.staff.QDisability(forProperty("disability")) : null;
        this.ethnicity = inits.isInitialized("ethnicity") ? new uk.ac.reigate.domain.lookup.QEthnicity(forProperty("ethnicity")) : null;
        this.maritalStatus = inits.isInitialized("maritalStatus") ? new uk.ac.reigate.domain.staff.QMaritalStatus(forProperty("maritalStatus")) : null;
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person"), inits.get("person")) : null;
        this.religion = inits.isInitialized("religion") ? new uk.ac.reigate.domain.staff.QReligion(forProperty("religion")) : null;
        this.sexualOrientation = inits.isInitialized("sexualOrientation") ? new uk.ac.reigate.domain.staff.QSexualOrientation(forProperty("sexualOrientation")) : null;
        this.type = inits.isInitialized("type") ? new uk.ac.reigate.domain.lookup.QStaffType(forProperty("type")) : null;
    }
    
}
