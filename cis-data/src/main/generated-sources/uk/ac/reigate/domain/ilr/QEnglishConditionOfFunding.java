package uk.ac.reigate.domain.ilr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QEnglishConditionOfFunding is a Querydsl query type for EnglishConditionOfFunding
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnglishConditionOfFunding extends EntityPathBase<EnglishConditionOfFunding> {
    
    private static final long serialVersionUID = 668808691L;
    
    public static final QEnglishConditionOfFunding englishConditionOfFunding = new QEnglishConditionOfFunding("englishConditionOfFunding");
    
    public final QILREntityNoIdentity _super = new QILREntityNoIdentity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    // inherited
    public final StringPath shortDescription = _super.shortDescription;
    
    // inherited
    public final DateTimePath<java.util.Date> validFrom = _super.validFrom;
    
    // inherited
    public final DateTimePath<java.util.Date> validTo = _super.validTo;
    
    public QEnglishConditionOfFunding(
        String variable) {
        super(EnglishConditionOfFunding.class, forVariable(variable));
    }
    
    public QEnglishConditionOfFunding(
        Path<? extends EnglishConditionOfFunding> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QEnglishConditionOfFunding(
        PathMetadata metadata) {
        super(EnglishConditionOfFunding.class, metadata);
    }
    
}
