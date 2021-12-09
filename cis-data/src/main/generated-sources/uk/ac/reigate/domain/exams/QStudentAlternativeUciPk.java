package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentAlternativeUciPk is a Querydsl query type for StudentAlternativeUciPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentAlternativeUciPk extends BeanPath<StudentAlternativeUciPk> {
    
    private static final long serialVersionUID = 1850984065L;
    
    public static final QStudentAlternativeUciPk studentAlternativeUciPk = new QStudentAlternativeUciPk("studentAlternativeUciPk");
    
    public final NumberPath<Integer> examBoard = createNumber("examBoard", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QStudentAlternativeUciPk(
        String variable) {
        super(StudentAlternativeUciPk.class, forVariable(variable));
    }
    
    public QStudentAlternativeUciPk(
        Path<? extends StudentAlternativeUciPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentAlternativeUciPk(
        PathMetadata metadata) {
        super(StudentAlternativeUciPk.class, metadata);
    }
    
}
