package uk.ac.reigate.domain.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QSetting is a Querydsl query type for Setting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSetting extends EntityPathBase<Setting> {
    
    private static final long serialVersionUID = 259190682L;
    
    public static final QSetting setting1 = new QSetting("setting1");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath description = createString("description");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath setting = createString("setting");
    
    public final StringPath value = createString("value");
    
    public QSetting(
        String variable) {
        super(Setting.class, forVariable(variable));
    }
    
    public QSetting(
        Path<? extends Setting> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QSetting(
        PathMetadata metadata) {
        super(Setting.class, metadata);
    }
    
}
