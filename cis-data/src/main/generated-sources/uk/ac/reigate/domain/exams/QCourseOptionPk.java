package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCourseOptionPk is a Querydsl query type for CourseOptionPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCourseOptionPk extends BeanPath<CourseOptionPk> {
    
    private static final long serialVersionUID = 1821429518L;
    
    public static final QCourseOptionPk courseOptionPk = new QCourseOptionPk("courseOptionPk");
    
    public final NumberPath<Integer> course = createNumber("course", Integer.class);
    
    public final NumberPath<Integer> examOption = createNumber("examOption", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public QCourseOptionPk(
        String variable) {
        super(CourseOptionPk.class, forVariable(variable));
    }
    
    public QCourseOptionPk(
        Path<? extends CourseOptionPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCourseOptionPk(
        PathMetadata metadata) {
        super(CourseOptionPk.class, metadata);
    }
    
}
