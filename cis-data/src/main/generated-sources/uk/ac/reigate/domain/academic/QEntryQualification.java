package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEntryQualification is a Querydsl query type for EntryQualification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEntryQualification extends EntityPathBase<EntryQualification> {
    
    private static final long serialVersionUID = 131956603L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QEntryQualification entryQualification = new QEntryQualification("entryQualification");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final BooleanPath basicList = createBoolean("basicList");
    
    public final StringPath dataMatchCode = createString("dataMatchCode");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath OLDID = createString("OLDID");
    
    public final BooleanPath shortCourse = createBoolean("shortCourse");
    
    public final StringPath title = createString("title");
    
    public final QEntryQualificationType type;
    
    public final NumberPath<Integer> webLinkCode = createNumber("webLinkCode", Integer.class);
    
    public QEntryQualification(
        String variable) {
        this(EntryQualification.class, forVariable(variable), INITS);
    }
    
    public QEntryQualification(
        Path<? extends EntryQualification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QEntryQualification(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QEntryQualification(
        PathMetadata metadata,
        PathInits inits) {
        this(EntryQualification.class, metadata, inits);
    }
    
    public QEntryQualification(
        Class<? extends EntryQualification> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.type = inits.isInitialized("type") ? new QEntryQualificationType(forProperty("type"), inits.get("type")) : null;
    }
    
}
