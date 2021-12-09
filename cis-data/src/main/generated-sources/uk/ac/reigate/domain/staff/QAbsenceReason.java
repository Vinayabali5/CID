package uk.ac.reigate.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QAbsenceReason is a Querydsl query type for AbsenceReason
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbsenceReason extends EntityPathBase<AbsenceReason> {
    
    private static final long serialVersionUID = -1466282070L;
    
    public static final QAbsenceReason absenceReason = new QAbsenceReason("absenceReason");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath reason = createString("reason");
    
    public QAbsenceReason(
        String variable) {
        super(AbsenceReason.class, forVariable(variable));
    }
    
    public QAbsenceReason(
        Path<? extends AbsenceReason> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QAbsenceReason(
        PathMetadata metadata) {
        super(AbsenceReason.class, metadata);
    }
    
}
