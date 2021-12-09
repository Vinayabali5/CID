package uk.ac.reigate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoom extends EntityPathBase<Room> {
    
    private static final long serialVersionUID = 1762282084L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QRoom room = new QRoom("room");
    
    public final QCodedEntity _super = new QCodedEntity(this);
    
    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);
    
    // inherited
    public final StringPath code = _super.code;
    
    public final StringPath codeNLZ = createString("codeNLZ");
    
    public final NumberPath<Integer> defaultCols = createNumber("defaultCols", Integer.class);
    
    public final NumberPath<Integer> defaultRows = createNumber("defaultRows", Integer.class);
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath newCode = createString("newCode");
    
    public final QRoomType roomType;
    
    public QRoom(
        String variable) {
        this(Room.class, forVariable(variable), INITS);
    }
    
    public QRoom(
        Path<? extends Room> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QRoom(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QRoom(
        PathMetadata metadata,
        PathInits inits) {
        this(Room.class, metadata, inits);
    }
    
    public QRoom(
        Class<? extends Room> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.roomType = inits.isInitialized("roomType") ? new QRoomType(forProperty("roomType")) : null;
    }
    
}
