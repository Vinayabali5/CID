package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QHoliday is a Querydsl query type for Holiday
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHoliday extends EntityPathBase<Holiday> {
    
    private static final long serialVersionUID = -1083107782L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QHoliday holiday = new QHoliday("holiday");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath description = createString("description");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final BooleanPath halfTerm = createBoolean("halfTerm");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final QAcademicYear year;
    
    public QHoliday(
        String variable) {
        this(Holiday.class, forVariable(variable), INITS);
    }
    
    public QHoliday(
        Path<? extends Holiday> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QHoliday(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QHoliday(
        PathMetadata metadata,
        PathInits inits) {
        this(Holiday.class, metadata, inits);
    }
    
    public QHoliday(
        Class<? extends Holiday> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.year = inits.isInitialized("year") ? new QAcademicYear(forProperty("year")) : null;
    }
    
}
