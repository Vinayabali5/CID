package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QAlternativePeriod is a Querydsl query type for AlternativePeriod
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlternativePeriod extends EntityPathBase<AlternativePeriod> {
    
    private static final long serialVersionUID = 23580464L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QAlternativePeriod alternativePeriod = new QAlternativePeriod("alternativePeriod");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    public final QBlock block;
    
    public final NumberPath<Integer> boxNo = createNumber("boxNo", Integer.class);
    
    // inherited
    public final StringPath code = _super.code;
    
    public final NumberPath<Integer> cristalPeriod = createNumber("cristalPeriod", Integer.class);
    
    public final NumberPath<Integer> day = createNumber("day", Integer.class);
    
    public final NumberPath<Integer> dayPeriod = createNumber("dayPeriod", Integer.class);
    
    public final StringPath defaultPeriodText = createString("defaultPeriodText");
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final NumberPath<Integer> length = createNumber("length", Integer.class);
    
    public final DateTimePath<java.util.Date> LviEndTime = createDateTime("LviEndTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> lviEndTime = createDateTime("lviEndTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> LviStartTime = createDateTime("LviStartTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> lviStartTime = createDateTime("lviStartTime", java.util.Date.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> UviEndTime = createDateTime("UviEndTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> uviEndTime = createDateTime("uviEndTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> UviStartTime = createDateTime("UviStartTime", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> uviStartTime = createDateTime("uviStartTime", java.util.Date.class);
    
    public QAlternativePeriod(
        String variable) {
        this(AlternativePeriod.class, forVariable(variable), INITS);
    }
    
    public QAlternativePeriod(
        Path<? extends AlternativePeriod> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QAlternativePeriod(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QAlternativePeriod(
        PathMetadata metadata,
        PathInits inits) {
        this(AlternativePeriod.class, metadata, inits);
    }
    
    public QAlternativePeriod(
        Class<? extends AlternativePeriod> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.block = inits.isInitialized("block") ? new QBlock(forProperty("block")) : null;
    }
    
}
