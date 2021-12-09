package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaffAbsence is a Querydsl query type for StaffAbsence
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffAbsence extends EntityPathBase<StaffAbsence> {
    
    private static final long serialVersionUID = 1749216596L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaffAbsence staffAbsence = new QStaffAbsence("staffAbsence");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final QAbsenceReason absenceReason;
    
    public final StringPath comment = createString("comment");
    
    public final NumberPath<Double> daysAbsence = createNumber("daysAbsence", Double.class);
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath reason = createString("reason");
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public QStaffAbsence(
        String variable) {
        this(StaffAbsence.class, forVariable(variable), INITS);
    }
    
    public QStaffAbsence(
        Path<? extends StaffAbsence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaffAbsence(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaffAbsence(
        PathMetadata metadata,
        PathInits inits) {
        this(StaffAbsence.class, metadata, inits);
    }
    
    public QStaffAbsence(
        Class<? extends StaffAbsence> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.absenceReason = inits.isInitialized("absenceReason") ? new QAbsenceReason(forProperty("absenceReason")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
    }
    
}
