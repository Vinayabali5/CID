package uk.ac.reigate.domain.ilp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QStatementBankType is a Querydsl query type for StatementBankType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatementBankType extends EntityPathBase<StatementBankType> {
    
    private static final long serialVersionUID = -182121541L;
    
    public static final QStatementBankType statementBankType = new QStatementBankType("statementBankType");
    
    public final uk.ac.reigate.domain.QBaseEntityNoIdentity _super = new uk.ac.reigate.domain.QBaseEntityNoIdentity(this);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath type = createString("type");
    
    public QStatementBankType(
        String variable) {
        super(StatementBankType.class, forVariable(variable));
    }
    
    public QStatementBankType(
        Path<? extends StatementBankType> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QStatementBankType(
        PathMetadata metadata) {
        super(StatementBankType.class, metadata);
    }
    
}
