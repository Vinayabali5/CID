package uk.ac.reigate.domain.cristal;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QCristalRoom is a Querydsl query type for CristalRoom
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCristalRoom extends EntityPathBase<CristalRoom> {
    
    private static final long serialVersionUID = -257234512L;
    
    public static final QCristalRoom cristalRoom = new QCristalRoom("cristalRoom");
    
    public final BooleanPath autoStart = createBoolean("autoStart");
    
    public final StringPath computerName = createString("computerName");
    
    public final BooleanPath confirmRoomChange = createBoolean("confirmRoomChange");
    
    public final BooleanPath confirmStaffChange = createBoolean("confirmStaffChange");
    
    public final BooleanPath confirmTimeChange = createBoolean("confirmTimeChange");
    
    public final BooleanPath mayPrint = createBoolean("mayPrint");
    
    public final SimplePath<groovy.lang.MetaClass> metaClass = createSimple("metaClass", groovy.lang.MetaClass.class);
    
    public final NumberPath<Integer> roomId = createNumber("roomId", Integer.class);
    
    public final StringPath roomName = createString("roomName");
    
    public final BooleanPath securityCodeNotRequired = createBoolean("securityCodeNotRequired");
    
    public final BooleanPath tutorOffice = createBoolean("tutorOffice");
    
    public QCristalRoom(
        String variable) {
        super(CristalRoom.class, forVariable(variable));
    }
    
    public QCristalRoom(
        Path<? extends CristalRoom> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QCristalRoom(
        PathMetadata metadata) {
        super(CristalRoom.class, metadata);
    }
    
}
