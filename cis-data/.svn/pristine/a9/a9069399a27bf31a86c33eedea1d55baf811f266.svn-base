package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QTutorGroup is a Querydsl query type for TutorGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTutorGroup extends EntityPathBase<TutorGroup> {
    
    private static final long serialVersionUID = -1338343628L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QTutorGroup tutorGroup = new QTutorGroup("tutorGroup");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final uk.ac.reigate.domain.academic.QFaculty faculty;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.QRoom room;
    
    public final uk.ac.reigate.domain.QStaff seniorTutor;
    
    public final uk.ac.reigate.domain.QStaff tutor;
    
    public QTutorGroup(
        String variable) {
        this(TutorGroup.class, forVariable(variable), INITS);
    }
    
    public QTutorGroup(
        Path<? extends TutorGroup> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QTutorGroup(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QTutorGroup(
        PathMetadata metadata,
        PathInits inits) {
        this(TutorGroup.class, metadata, inits);
    }
    
    public QTutorGroup(
        Class<? extends TutorGroup> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.faculty = inits.isInitialized("faculty") ? new uk.ac.reigate.domain.academic.QFaculty(forProperty("faculty"), inits.get("faculty")) : null;
        this.room = inits.isInitialized("room") ? new uk.ac.reigate.domain.QRoom(forProperty("room"), inits.get("room")) : null;
        this.seniorTutor = inits.isInitialized("seniorTutor") ? new uk.ac.reigate.domain.QStaff(forProperty("seniorTutor"), inits.get("seniorTutor")) : null;
        this.tutor = inits.isInitialized("tutor") ? new uk.ac.reigate.domain.QStaff(forProperty("tutor"), inits.get("tutor")) : null;
    }
    
}
