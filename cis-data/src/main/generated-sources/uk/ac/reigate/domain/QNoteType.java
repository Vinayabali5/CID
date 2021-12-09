package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QNoteType is a Querydsl query type for NoteType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNoteType extends EntityPathBase<NoteType> {
    
    private static final long serialVersionUID = 1427195733L;
    
    public static final QNoteType noteType = new QNoteType("noteType");
    
    public final QCodedEntity _super = new QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QNoteType(
        String variable) {
        super(NoteType.class, forVariable(variable));
    }
    
    public QNoteType(
        Path<? extends NoteType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QNoteType(
        PathMetadata metadata) {
        super(NoteType.class, metadata);
    }
    
}
