package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QSpecialCategory is a Querydsl query type for SpecialCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSpecialCategory extends EntityPathBase<SpecialCategory> {
    
    private static final long serialVersionUID = -1444707143L;
    
    public static final QSpecialCategory specialCategory = new QSpecialCategory("specialCategory");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final StringPath details = createString("details");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);
    
    public final BooleanPath sendEmail = createBoolean("sendEmail");
    
    public QSpecialCategory(
        String variable) {
        super(SpecialCategory.class, forVariable(variable));
    }
    
    public QSpecialCategory(
        Path<? extends SpecialCategory> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QSpecialCategory(
        PathMetadata metadata) {
        super(SpecialCategory.class, metadata);
    }
    
}
