package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QAttendanceMonitoring is a Querydsl query type for AttendanceMonitoring
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAttendanceMonitoring extends EntityPathBase<AttendanceMonitoring> {
    
    private static final long serialVersionUID = 1808232604L;
    
    public static final QAttendanceMonitoring attendanceMonitoring = new QAttendanceMonitoring("attendanceMonitoring");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final StringPath htmlColour = createString("htmlColour");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath nonEntry = createBoolean("nonEntry");
    
    public final StringPath warningColour = createString("warningColour");
    
    public QAttendanceMonitoring(
        String variable) {
        super(AttendanceMonitoring.class, forVariable(variable));
    }
    
    public QAttendanceMonitoring(
        Path<? extends AttendanceMonitoring> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QAttendanceMonitoring(
        PathMetadata metadata) {
        super(AttendanceMonitoring.class, metadata);
    }
    
}
