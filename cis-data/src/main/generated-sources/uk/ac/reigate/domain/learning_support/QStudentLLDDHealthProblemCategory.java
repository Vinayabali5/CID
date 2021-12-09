package uk.ac.reigate.domain.learning_support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStudentLLDDHealthProblemCategory is a Querydsl query type for StudentLLDDHealthProblemCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentLLDDHealthProblemCategory extends EntityPathBase<StudentLLDDHealthProblemCategory> {
    
    private static final long serialVersionUID = -893220259L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = new QStudentLLDDHealthProblemCategory("studentLLDDHealthProblemCategory");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final uk.ac.reigate.domain.ilr.QLLDDHealthProblemCategory lLDDHealthProblemCategory;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath primarylldd = createBoolean("primarylldd");
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public QStudentLLDDHealthProblemCategory(
        String variable) {
        this(StudentLLDDHealthProblemCategory.class, forVariable(variable), INITS);
    }
    
    public QStudentLLDDHealthProblemCategory(
        Path<? extends StudentLLDDHealthProblemCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStudentLLDDHealthProblemCategory(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStudentLLDDHealthProblemCategory(
        PathMetadata metadata,
        PathInits inits) {
        this(StudentLLDDHealthProblemCategory.class, metadata, inits);
    }
    
    public QStudentLLDDHealthProblemCategory(
        Class<? extends StudentLLDDHealthProblemCategory> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.lLDDHealthProblemCategory = inits.isInitialized("lLDDHealthProblemCategory") ? new uk.ac.reigate.domain.ilr.QLLDDHealthProblemCategory(forProperty("lLDDHealthProblemCategory")) : null;
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
