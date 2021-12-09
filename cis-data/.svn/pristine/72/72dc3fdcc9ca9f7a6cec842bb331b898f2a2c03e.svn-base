package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStaffInsetCourse is a Querydsl query type for StaffInsetCourse
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffInsetCourse extends EntityPathBase<StaffInsetCourse> {
    
    private static final long serialVersionUID = -1446434001L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStaffInsetCourse staffInsetCourse = new QStaffInsetCourse("staffInsetCourse");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final NumberPath<Double> hours = createNumber("hours", Double.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final QInsetCourse insetCourse;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.QStaff staff;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public QStaffInsetCourse(
        String variable) {
        this(StaffInsetCourse.class, forVariable(variable), INITS);
    }
    
    public QStaffInsetCourse(
        Path<? extends StaffInsetCourse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStaffInsetCourse(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStaffInsetCourse(
        PathMetadata metadata,
        PathInits inits) {
        this(StaffInsetCourse.class, metadata, inits);
    }
    
    public QStaffInsetCourse(
        Class<? extends StaffInsetCourse> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.insetCourse = inits.isInitialized("insetCourse") ? new QInsetCourse(forProperty("insetCourse"), inits.get("insetCourse")) : null;
        this.staff = inits.isInitialized("staff") ? new uk.ac.reigate.domain.QStaff(forProperty("staff"), inits.get("staff")) : null;
    }
    
}
