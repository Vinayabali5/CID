package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStudentReferralReasonPk is a Querydsl query type for StudentReferralReasonPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStudentReferralReasonPk extends BeanPath<StudentReferralReasonPk> {
    
    private static final long serialVersionUID = -694679296L;
    
    public static final QStudentReferralReasonPk studentReferralReasonPk = new QStudentReferralReasonPk("studentReferralReasonPk");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> referralReason = createNumber("referralReason", Integer.class);
    
    public final NumberPath<Integer> student = createNumber("student", Integer.class);
    
    public QStudentReferralReasonPk(
        String variable) {
        super(StudentReferralReasonPk.class, forVariable(variable));
    }
    
    public QStudentReferralReasonPk(
        Path<? extends StudentReferralReasonPk> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStudentReferralReasonPk(
        PathMetadata metadata) {
        super(StudentReferralReasonPk.class, metadata);
    }
    
}
