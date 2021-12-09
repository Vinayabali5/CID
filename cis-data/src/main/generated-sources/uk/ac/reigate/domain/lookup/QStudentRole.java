package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentRole is a Querydsl query type for StudentRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentRole extends EntityPathBase<StudentRole> {
    
    private static final long serialVersionUID = 2120854630L;
    
    public static final QStudentRole studentRole = new QStudentRole("studentRole");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QStudentRole(
        String variable) {
        super(StudentRole.class, forVariable(variable));
    }
    
    public QStudentRole(
        Path<? extends StudentRole> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentRole(
        PathMetadata metadata) {
        super(StudentRole.class, metadata);
    }
    
}
