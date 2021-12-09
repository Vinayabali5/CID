package uk.ac.reigate.domain.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QLetterTemplate is a Querydsl query type for LetterTemplate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLetterTemplate extends EntityPathBase<LetterTemplate> {
    
    private static final long serialVersionUID = -16857546L;
    
    public static final QLetterTemplate letterTemplate = new QLetterTemplate("letterTemplate");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath name = createString("name");
    
    public final StringPath templateText = createString("templateText");
    
    public QLetterTemplate(
        String variable) {
        super(LetterTemplate.class, forVariable(variable));
    }
    
    public QLetterTemplate(
        Path<? extends LetterTemplate> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QLetterTemplate(
        PathMetadata metadata) {
        super(LetterTemplate.class, metadata);
    }
    
}
