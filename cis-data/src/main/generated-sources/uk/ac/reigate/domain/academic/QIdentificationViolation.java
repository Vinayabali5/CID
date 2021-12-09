package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QIdentificationViolation is a Querydsl query type for IdentificationViolation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIdentificationViolation extends EntityPathBase<IdentificationViolation> {
    
    private static final long serialVersionUID = 62424121L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QIdentificationViolation identificationViolation = new QIdentificationViolation("identificationViolation");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final NumberPath<Integer> id_number = createNumber("id_number", Integer.class);
    
    public final BooleanPath lost = createBoolean("lost");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath printed = createBoolean("printed");
    
    public final BooleanPath replacementPaidFor = createBoolean("replacementPaidFor");
    
    public final BooleanPath returned = createBoolean("returned");
    
    public final QStudent student;
    
    public final QAcademicYear year;
    
    public QIdentificationViolation(
        String variable) {
        this(IdentificationViolation.class, forVariable(variable), INITS);
    }
    
    public QIdentificationViolation(
        Path<? extends IdentificationViolation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QIdentificationViolation(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QIdentificationViolation(
        PathMetadata metadata,
        PathInits inits) {
        this(IdentificationViolation.class, metadata, inits);
    }
    
    public QIdentificationViolation(
        Class<? extends IdentificationViolation> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
