package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QFileCategory is a Querydsl query type for FileCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFileCategory extends EntityPathBase<FileCategory> {
    
    private static final long serialVersionUID = 135361061L;
    
    public static final QFileCategory fileCategory = new QFileCategory("fileCategory");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QFileCategory(
        String variable) {
        super(FileCategory.class, forVariable(variable));
    }
    
    public QFileCategory(
        Path<? extends FileCategory> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QFileCategory(
        PathMetadata metadata) {
        super(FileCategory.class, metadata);
    }
    
}
