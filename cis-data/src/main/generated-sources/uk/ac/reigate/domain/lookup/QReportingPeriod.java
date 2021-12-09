package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QReportingPeriod is a Querydsl query type for ReportingPeriod
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReportingPeriod extends EntityPathBase<ReportingPeriod> {
    
    private static final long serialVersionUID = 634095140L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QReportingPeriod reportingPeriod = new QReportingPeriod("reportingPeriod");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final uk.ac.reigate.domain.academic.QAcademicYear academicYear;
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public QReportingPeriod(
        String variable) {
        this(ReportingPeriod.class, forVariable(variable), INITS);
    }
    
    public QReportingPeriod(
        Path<? extends ReportingPeriod> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QReportingPeriod(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QReportingPeriod(
        PathMetadata metadata,
        PathInits inits) {
        this(ReportingPeriod.class, metadata, inits);
    }
    
    public QReportingPeriod(
        Class<? extends ReportingPeriod> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.academicYear = inits.isInitialized("academicYear") ? new uk.ac.reigate.domain.academic.QAcademicYear(forProperty("academicYear")) : null;
    }
    
}
