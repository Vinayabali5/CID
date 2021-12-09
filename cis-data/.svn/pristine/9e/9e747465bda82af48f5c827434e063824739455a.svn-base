package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QFaculty is a Querydsl query type for Faculty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFaculty extends EntityPathBase<Faculty> {
    
    private static final long serialVersionUID = 1028098118L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QFaculty faculty = new QFaculty("faculty");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    public final uk.ac.reigate.domain.QStaff adol;
    
    public final uk.ac.reigate.domain.QStaff apd;
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final uk.ac.reigate.domain.QStaff dol;
    
    public final uk.ac.reigate.domain.QStaff hof;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final uk.ac.reigate.domain.QStaff pd;
    
    public final DateTimePath<java.util.Date> validFrom = createDateTime("validFrom", java.util.Date.class);
    
    public final DateTimePath<java.util.Date> validTo = createDateTime("validTo", java.util.Date.class);
    
    public QFaculty(
        String variable) {
        this(Faculty.class, forVariable(variable), INITS);
    }
    
    public QFaculty(
        Path<? extends Faculty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QFaculty(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QFaculty(
        PathMetadata metadata,
        PathInits inits) {
        this(Faculty.class, metadata, inits);
    }
    
    public QFaculty(
        Class<? extends Faculty> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.adol = inits.isInitialized("adol") ? new uk.ac.reigate.domain.QStaff(forProperty("adol"), inits.get("adol")) : null;
        this.apd = inits.isInitialized("apd") ? new uk.ac.reigate.domain.QStaff(forProperty("apd"), inits.get("apd")) : null;
        this.dol = inits.isInitialized("dol") ? new uk.ac.reigate.domain.QStaff(forProperty("dol"), inits.get("dol")) : null;
        this.hof = inits.isInitialized("hof") ? new uk.ac.reigate.domain.QStaff(forProperty("hof"), inits.get("hof")) : null;
        this.pd = inits.isInitialized("pd") ? new uk.ac.reigate.domain.QStaff(forProperty("pd"), inits.get("pd")) : null;
    }
    
}
