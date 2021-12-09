package uk.ac.reigate.domain.lookup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPossibleGradeSet is a Querydsl query type for PossibleGradeSet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPossibleGradeSet extends EntityPathBase<PossibleGradeSet> {
    
    private static final long serialVersionUID = -1632794713L;
    
    public static final QPossibleGradeSet possibleGradeSet = new QPossibleGradeSet("possibleGradeSet");
    
    public final uk.ac.reigate.domain.QCodedEntity _super = new uk.ac.reigate.domain.QCodedEntity(this);
    
    // inherited
    public final StringPath code = _super.code;
    
    // inherited
    public final StringPath description = _super.description;
    
    public final ListPath<PossibleGrade, QPossibleGrade> grades = this.<PossibleGrade, QPossibleGrade> createList("grades", PossibleGrade.class, QPossibleGrade.class, PathInits.DIRECT2);
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public QPossibleGradeSet(
        String variable) {
        super(PossibleGradeSet.class, forVariable(variable));
    }
    
    public QPossibleGradeSet(
        Path<? extends PossibleGradeSet> path) {
        super(path.getType(), path.getMetadata());
    }
    
    public QPossibleGradeSet(
        PathMetadata metadata) {
        super(PossibleGradeSet.class, metadata);
    }
    
}
