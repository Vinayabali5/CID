package uk.ac.reigate.domain.academic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDepartment extends EntityPathBase<Department> {
    
    private static final long serialVersionUID = -1099566544L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QDepartment department = new QDepartment("department");
    
    public final uk.ac.reigate.domain.QNamedEntity _super = new uk.ac.reigate.domain.QNamedEntity(this);
    
    public final BooleanPath academic = createBoolean("academic");
    
    // inherited
    public final StringPath description = _super.description;
    
    public final QFaculty faculty;
    
    public final uk.ac.reigate.domain.QStaff hod;
    
    public final uk.ac.reigate.domain.QStaff hod2;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    // inherited
    public final StringPath name = _super.name;
    
    public QDepartment(
        String variable) {
        this(Department.class, forVariable(variable), INITS);
    }
    
    public QDepartment(
        Path<? extends Department> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QDepartment(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QDepartment(
        PathMetadata metadata,
        PathInits inits) {
        this(Department.class, metadata, inits);
    }
    
    public QDepartment(
        Class<? extends Department> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.faculty = inits.isInitialized("faculty") ? new QFaculty(forProperty("faculty"), inits.get("faculty")) : null;
        this.hod = inits.isInitialized("hod") ? new uk.ac.reigate.domain.QStaff(forProperty("hod"), inits.get("hod")) : null;
        this.hod2 = inits.isInitialized("hod2") ? new uk.ac.reigate.domain.QStaff(forProperty("hod2"), inits.get("hod2")) : null;
    }
    
}
