package uk.ac.reigate.domain.risk_assessment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QRiskLevel is a Querydsl query type for RiskLevel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRiskLevel extends EntityPathBase<RiskLevel> {
    
    private static final long serialVersionUID = -1638566064L;
    
    public static final QRiskLevel riskLevel = new QRiskLevel("riskLevel");
    
    public final uk.ac.reigate.domain.QCodedEntityNoIdentity _super = new uk.ac.reigate.domain.QCodedEntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);
    
    public final BooleanPath sendEmail = createBoolean("sendEmail");
    
    public final BooleanPath sendEmailSafeguarding = createBoolean("sendEmailSafeguarding");
    
    public QRiskLevel(
        String variable) {
        super(RiskLevel.class, forVariable(variable));
    }
    
    public QRiskLevel(
        Path<? extends RiskLevel> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QRiskLevel(
        PathMetadata metadata) {
        super(RiskLevel.class, metadata);
    }
    
}
