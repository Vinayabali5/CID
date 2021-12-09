package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QTextLookup is a Querydsl query type for TextLookup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTextLookup extends EntityPathBase<TextLookup> {
    
    private static final long serialVersionUID = -716078254L;
    
    public static final QTextLookup textLookup = new QTextLookup("textLookup");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public final StringPath text = createString("text");
    
    public QTextLookup(
        String variable) {
        super(TextLookup.class, forVariable(variable));
    }
    
    public QTextLookup(
        Path<? extends TextLookup> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QTextLookup(
        PathMetadata metadata) {
        super(TextLookup.class, metadata);
    }
    
}
