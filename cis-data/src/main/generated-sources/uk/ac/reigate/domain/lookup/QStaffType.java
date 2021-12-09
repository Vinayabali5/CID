package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStaffType is a Querydsl query type for StaffType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaffType extends EntityPathBase<StaffType> {
    
    private static final long serialVersionUID = -1315052913L;
    
    public static final QStaffType staffType = new QStaffType("staffType");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final BooleanPath needInitials = createBoolean("needInitials");
    
    public QStaffType(
        String variable) {
        super(StaffType.class, forVariable(variable));
    }
    
    public QStaffType(
        Path<? extends StaffType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStaffType(
        PathMetadata metadata) {
        super(StaffType.class, metadata);
    }
    
}
