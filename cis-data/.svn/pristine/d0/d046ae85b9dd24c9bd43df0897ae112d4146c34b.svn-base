package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPeriod is a Querydsl query type for Period
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPeriod extends EntityPathBase<Period> {
    
    private static final long serialVersionUID = -230603873L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QPeriod period = new QPeriod("period");
    
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
    
    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final NumberPath<Integer> length = createNumber("length", Integer.class);
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);
    
    public QPeriod(
        String variable) {
        this(Period.class, forVariable(variable), INITS);
    }
    
    public QPeriod(
        Path<? extends Period> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QPeriod(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QPeriod(
        PathMetadata metadata,
        PathInits inits) {
        this(Period.class, metadata, inits);
    }
    
    public QPeriod(
        Class<? extends Period> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.block = inits.isInitialized("block") ? new QBlock(forProperty("block")) : null;
    }
    
}
