package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentOptionEntryPk is a Querydsl query type for StudentOptionEntryPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentOptionEntryPk extends BeanPath<StudentOptionEntryPk> {
    
    private static final long serialVersionUID = -751070304L;
    
    public static final QStudentOptionEntryPk studentOptionEntryPk = new QStudentOptionEntryPk("studentOptionEntryPk");
    
    public final NumberPath<Integer> examOption = createNumber("examOption", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QStudentOptionEntryPk(
        String variable) {
        super(StudentOptionEntryPk.class, forVariable(variable));
    }
    
    public QStudentOptionEntryPk(
        Path<? extends StudentOptionEntryPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentOptionEntryPk(
        PathMetadata metadata) {
        super(StudentOptionEntryPk.class, metadata);
    }
    
}
