package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentYearPk is a Querydsl query type for StudentYearPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentYearPk extends BeanPath<StudentYearPk> {
    
    private static final long serialVersionUID = -1200125547L;
    
    public static final QStudentYearPk studentYearPk = new QStudentYearPk("studentYearPk");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public final NumberPath<Integer> year = createNumber("year", Integer.class);
    
    public QStudentYearPk(
        String variable) {
        super(StudentYearPk.class, forVariable(variable));
    }
    
    public QStudentYearPk(
        Path<? extends StudentYearPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentYearPk(
        PathMetadata metadata) {
        super(StudentYearPk.class, metadata);
    }
    
}
