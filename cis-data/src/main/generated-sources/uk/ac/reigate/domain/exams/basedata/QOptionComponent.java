package uk.ac.reigate.domain.exams.basedata;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QOptionComponent is a Querydsl query type for OptionComponent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionComponent extends EntityPathBase<OptionComponent> {
    
    private static final long serialVersionUID = -1904038248L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QOptionComponent optionComponent = new QOptionComponent("optionComponent");
    
    public final QExamComponent examComponent;
    
    public final QExamOption examOption;
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public QOptionComponent(
        String variable) {
        this(OptionComponent.class, forVariable(variable), INITS);
    }
    
    public QOptionComponent(
        Path<? extends OptionComponent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QOptionComponent(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QOptionComponent(
        PathMetadata metadata,
        PathInits inits) {
        this(OptionComponent.class, metadata, inits);
    }
    
    public QOptionComponent(
        Class<? extends OptionComponent> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.examComponent = inits.isInitialized("examComponent") ? new QExamComponent(forProperty("examComponent"), inits.get("examComponent")) : null;
        this.examOption = inits.isInitialized("examOption") ? new QExamOption(forProperty("examOption"), inits.get("examOption")) : null;
    }
    
}
