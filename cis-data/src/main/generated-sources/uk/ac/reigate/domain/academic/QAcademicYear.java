package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QAcademicYear is a Querydsl query type for AcademicYear
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAcademicYear extends EntityPathBase<AcademicYear> {
    
    private static final long serialVersionUID = 1689210178L;
    
    public static final QAcademicYear academicYear = new QAcademicYear("academicYear");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> enumerationDate = createDateTime("enumerationDate", java.util.Date.class);
    
    public final SetPath<Holiday, QHoliday> holidays = this.<Holiday, QHoliday> createSet("holidays", Holiday.class, QHoliday.class, PathInits.DIRECT2);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);
    
    public final NumberPath<Integer> startYear = createNumber("startYear", Integer.class);
    
    public final DateTimePath<java.util.Date> teachingEndDate = createDateTime("teachingEndDate", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> teachingStartDate = createDateTime("teachingStartDate", java.util.Date.class);
    
    public QAcademicYear(
        String variable) {
        super(AcademicYear.class, forVariable(variable));
    }
    
    public QAcademicYear(
        Path<? extends AcademicYear> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QAcademicYear(
        PathMetadata metadata) {
        super(AcademicYear.class, metadata);
    }
    
}
