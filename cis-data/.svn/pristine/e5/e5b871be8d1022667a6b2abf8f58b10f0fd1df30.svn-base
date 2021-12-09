package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QInsetCourse is a Querydsl query type for InsetCourse
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInsetCourse extends EntityPathBase<InsetCourse> {
    
    private static final long serialVersionUID = 54817441L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QInsetCourse insetCourse = new QInsetCourse("insetCourse");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final StringPath courseNotes = createString("courseNotes");
    
    public final StringPath courseTitle = createString("courseTitle");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public QInsetCourse(
        String variable) {
        this(InsetCourse.class, forVariable(variable), INITS);
    }
    
    public QInsetCourse(
        Path<? extends InsetCourse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QInsetCourse(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QInsetCourse(
        PathMetadata metadata,
        PathInits inits) {
        this(InsetCourse.class, metadata, inits);
    }
    
    public QInsetCourse(
        Class<? extends InsetCourse> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
    }
    
}
