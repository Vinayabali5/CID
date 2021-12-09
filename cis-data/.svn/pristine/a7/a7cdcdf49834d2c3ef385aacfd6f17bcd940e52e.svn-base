package uk.ac.reigate.domain.admissions;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCollegeFundPayment is a Querydsl query type for CollegeFundPayment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCollegeFundPayment extends EntityPathBase<CollegeFundPayment> {
    
    private static final long serialVersionUID = 1385879333L;
    
    private static final PathInits INITS = PathInits.DIRECT2;
    
    public static final QCollegeFundPayment collegeFundPayment = new QCollegeFundPayment("collegeFundPayment");
    
    public final uk.ac.reigate.domain.QBaseEntity _super = new uk.ac.reigate.domain.QBaseEntity(this);
    
    public final NumberPath<Float> amount = createNumber("amount", Float.class);
    
    public final BooleanPath cash = createBoolean("cash");
    
    public final DateTimePath<java.util.Date> chequeDate = createDateTime("chequeDate", java.util.Date.class);
    
    public final BooleanPath giftAid = createBoolean("giftAid");
    
    // inherited
    public final NumberPath<Integer> id = _super.id;
    
    // inherited
    public final SimplePath<groovy.lang.MetaClass> metaClass = _super.metaClass;
    
    public final StringPath payee = createString("payee");
    
    public final DateTimePath<java.util.Date> paymentDate = createDateTime("paymentDate", java.util.Date.class);
    
    public final uk.ac.reigate.domain.academic.QStudent student;
    
    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);
    
    public QCollegeFundPayment(
        String variable) {
        this(CollegeFundPayment.class, forVariable(variable), INITS);
    }
    
    public QCollegeFundPayment(
        Path<? extends CollegeFundPayment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }
    
    public QCollegeFundPayment(
        PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }
    
    public QCollegeFundPayment(
        PathMetadata metadata,
        PathInits inits) {
        this(CollegeFundPayment.class, metadata, inits);
    }
    
    public QCollegeFundPayment(
        Class<? extends CollegeFundPayment> type,
        PathMetadata metadata,
        PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new uk.ac.reigate.domain.academic.QStudent(forProperty("student"), inits.get("student")) : null;
    }
    
}
