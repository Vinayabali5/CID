package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QPunctualityMonitoring is a Querydsl query type for PunctualityMonitoring
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPunctualityMonitoring extends EntityPathBase<PunctualityMonitoring> {
    
    private static final long serialVersionUID = -4427195L;
    
    public static final QPunctualityMonitoring punctualityMonitoring = new QPunctualityMonitoring("punctualityMonitoring");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final StringPath htmlColour = createString("htmlColour");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath nonEntry = createBoolean("nonEntry");
    
    public final StringPath warningColour = createString("warningColour");
    
    public QPunctualityMonitoring(
        String variable) {
        super(PunctualityMonitoring.class, forVariable(variable));
    }
    
    public QPunctualityMonitoring(
        Path<? extends PunctualityMonitoring> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QPunctualityMonitoring(
        PathMetadata metadata) {
        super(PunctualityMonitoring.class, metadata);
    }
    
}
