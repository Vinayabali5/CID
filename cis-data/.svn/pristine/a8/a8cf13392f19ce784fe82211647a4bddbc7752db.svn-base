package uk.ac.reigate.domain.interimreport;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QInterimReport is a Querydsl query type for InterimReport
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterimReport extends EntityPathBase<InterimReport> {
    
    private static final long serialVersionUID = 1155272817L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QInterimReport interimReport = new QInterimReport("interimReport");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath active = createBoolean("active");
    
    public final StringPath description = createString("description");
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> publishDate = createDateTime("publishDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear year;
    
    public QInterimReport(
        String variable) {
        this(InterimReport.class, forVariable(variable), INITS);
    }
    
    public QInterimReport(
        Path<? extends InterimReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QInterimReport(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QInterimReport(
        PathMetadata metadata,
        PathInits inits) {
        this(InterimReport.class, metadata, inits);
    }
    
    public QInterimReport(
        Class<? extends InterimReport> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.year = inits.isInitialized("year") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("year")) : null;
    }
    
}
