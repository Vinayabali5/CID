package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QNote is a Querydsl query type for Note
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNote extends EntityPathBase<Note> {
    
    private static final long serialVersionUID = 1762163067L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QNote note1 = new QNote("note1");
    
    public final QBaseEntity _super = new QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath note = createString("note");
    
    public final BooleanPath pastoral = createBoolean("pastoral");
    
    public final QPerson person;
    
    public final QNoteType type;
    
    public QNote(
        String variable) {
        this(Note.class, forVariable(variable), INITS);
    }
    
    public QNote(
        Path<? extends Note> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QNote(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QNote(
        PathMetadata metadata,
        PathInits inits) {
        this(Note.class, metadata, inits);
    }
    
    public QNote(
        Class<? extends Note> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person"), inits.get("person")) : null;
        this.type = inits.isInitialized("type") ? new QNoteType(forProperty("type")) : null;
    }
    
}
