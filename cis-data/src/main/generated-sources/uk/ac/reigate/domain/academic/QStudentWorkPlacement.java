package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentWorkPlacement is a Querydsl query type for StudentWorkPlacement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentWorkPlacement extends EntityPathBase<StudentWorkPlacement> {
    
    private static final long serialVersionUID = -509385289L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentWorkPlacement studentWorkPlacement = new QStudentWorkPlacement("studentWorkPlacement");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath employer = createString("employer");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final StringPath extraDetails = createString("extraDetails");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final NumberPath<Float> placementHours = createNumber("placementHours", Float.class);
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QStudent student;
    
    public final QWorkPlacementMode workPlacementMode;
    
    public QStudentWorkPlacement(
        String variable) {
        this(StudentWorkPlacement.class, forVariable(variable), INITS);
    }
    
    public QStudentWorkPlacement(
        Path<? extends StudentWorkPlacement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentWorkPlacement(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentWorkPlacement(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentWorkPlacement.class, metadata, inits);
    }
    
    public QStudentWorkPlacement(
        Class<? extends StudentWorkPlacement> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.workPlacementMode = inits.isInitialized("workPlacementMode") ? new QWorkPlacementMode(forProperty("workPlacementMode")) : null;
    }
    
}
