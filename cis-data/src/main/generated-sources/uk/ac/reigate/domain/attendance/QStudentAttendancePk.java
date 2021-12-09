package uk.ac.reigate.domain.attendance;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentAttendancePk is a Querydsl query type for StudentAttendancePk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentAttendancePk extends BeanPath<StudentAttendancePk> {
    
    private static final long serialVersionUID = -1304837597L;
    
    public static final QStudentAttendancePk studentAttendancePk = new QStudentAttendancePk("studentAttendancePk");
    
    public final NumberPath<Integer> academicYear = createNumber("academicYear", Integer.class);
    
    public final NumberPath<Integer> course = createNumber("course", Integer.class);
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QStudentAttendancePk(
        String variable) {
        super(StudentAttendancePk.class, forVariable(variable));
    }
    
    public QStudentAttendancePk(
        Path<? extends StudentAttendancePk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentAttendancePk(
        PathMetadata metadata) {
        super(StudentAttendancePk.class, metadata);
    }
    
}
