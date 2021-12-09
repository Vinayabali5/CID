package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QStatementBank is a Querydsl query type for StatementBank
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatementBank extends EntityPathBase<StatementBank> {
    
    private static final long serialVersionUID = 348807393L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QStatementBank statementBank = new QStatementBank("statementBank");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final StringPath discussion = createString("discussion");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    public final BooleanPath inUse = createBoolean("inUse");
    
    public final StringPath letterType = createString("letterType");
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final QStatementBankType statementBankType;
    
    public final StringPath target = createString("target");
    
    public final StringPath topic = createString("topic");
    
    public final BooleanPath useForMassLetters = createBoolean("useForMassLetters");
    
    public QStatementBank(
        String variable) {
        this(StatementBank.class, forVariable(variable), INITS);
    }
    
    public QStatementBank(
        Path<? extends StatementBank> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QStatementBank(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QStatementBank(
        PathMetadata metadata,
        PathInits inits) {
        this(StatementBank.class, metadata, inits);
    }
    
    public QStatementBank(
        Class<? extends StatementBank> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.statementBankType = inits.isInitialized("statementBankType") ? new QStatementBankType(forProperty("statementBankType")) : null;
    }
    
}
