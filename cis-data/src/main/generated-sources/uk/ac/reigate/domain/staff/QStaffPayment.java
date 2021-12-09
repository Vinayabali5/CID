package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaffPayment is a Querydsl query type for StaffPayment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffPayment extends EntityPathBase<StaffPayment> {
    
    private static final long serialVersionUID = -2140955363L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaffPayment staffPayment = new QStaffPayment("staffPayment");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QPaymentReason paymentReason;
    
    public final NumberPath<Double> ratePerSession = createNumber("ratePerSession", Double.class);
    
    public final NumberPath<Double> sessions = createNumber("sessions", Double.class);
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public QStaffPayment(
        String variable) {
        this(StaffPayment.class, forVariable(variable), INITS);
    }
    
    public QStaffPayment(
        Path<? extends StaffPayment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaffPayment(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaffPayment(
        PathMetadata metadata,
        PathInits inits) {
        this(StaffPayment.class, metadata, inits);
    }
    
    public QStaffPayment(
        Class<? extends StaffPayment> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.paymentReason = inits.isInitialized("paymentReason") ? new QPaymentReason(forProperty("paymentReason")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
    }
    
}
