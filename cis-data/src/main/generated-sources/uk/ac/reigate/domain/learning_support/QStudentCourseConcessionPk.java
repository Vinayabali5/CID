package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentCourseConcessionPk is a Querydsl query type for StudentCourseConcessionPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentCourseConcessionPk extends BeanPath<StudentCourseConcessionPk> {
    
    private static final long serialVersionUID = -852290178L;
    
    public static final QStudentCourseConcessionPk studentCourseConcessionPk = new QStudentCourseConcessionPk("studentCourseConcessionPk");
    
    public final NumberPath<Integer> concessionType = createNumber("concessionType", Integer.class);
    
    public final NumberPath<Integer> course = createNumber("course", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QStudentCourseConcessionPk(
        String variable) {
        super(StudentCourseConcessionPk.class, forVariable(variable));
    }
    
    public QStudentCourseConcessionPk(
        Path<? extends StudentCourseConcessionPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentCourseConcessionPk(
        PathMetadata metadata) {
        super(StudentCourseConcessionPk.class, metadata);
    }
    
}
