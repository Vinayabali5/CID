package uk.ac.reigate.domain.exams;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCourseComponentPk is a Querydsl query type for CourseComponentPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCourseComponentPk extends BeanPath<CourseComponentPk> {
    
    private static final long serialVersionUID = -1023306406L;
    
    public static final QCourseComponentPk courseComponentPk = new QCourseComponentPk("courseComponentPk");
    
    public final NumberPath<Integer> course = createNumber("course", Integer.class);
    
    public final NumberPath<Integer> examComponent = createNumber("examComponent", Integer.class);
    
    public final NumberPath<Integer> examOption = createNumber("examOption", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public QCourseComponentPk(
        String variable) {
        super(CourseComponentPk.class, forVariable(variable));
    }
    
    public QCourseComponentPk(
        Path<? extends CourseComponentPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCourseComponentPk(
        PathMetadata metadata) {
        super(CourseComponentPk.class, metadata);
    }
    
}
