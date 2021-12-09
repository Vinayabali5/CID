package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentDukeOfEdinburgh is a Querydsl query type for StudentDukeOfEdinburgh
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentDukeOfEdinburgh extends EntityPathBase<StudentDukeOfEdinburgh> {
    
    private static final long serialVersionUID = -1451622531L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentDukeOfEdinburgh studentDukeOfEdinburgh = new QStudentDukeOfEdinburgh("studentDukeOfEdinburgh");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final NumberPath<Double> hours = createNumber("hours", Double.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath note = createString("note");
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QStudent student;
    
    public final StringPath voluntaryOrganisation = createString("voluntaryOrganisation");
    
    public QStudentDukeOfEdinburgh(
        String variable) {
        this(StudentDukeOfEdinburgh.class, forVariable(variable), INITS);
    }
    
    public QStudentDukeOfEdinburgh(
        Path<? extends StudentDukeOfEdinburgh> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentDukeOfEdinburgh(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentDukeOfEdinburgh(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentDukeOfEdinburgh.class, metadata, inits);
    }
    
    public QStudentDukeOfEdinburgh(
        Class<? extends StudentDukeOfEdinburgh> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
