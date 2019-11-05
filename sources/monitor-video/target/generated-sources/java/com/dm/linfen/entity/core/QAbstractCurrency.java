package com.dm.linfen.entity.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAbstractCurrency is a Querydsl query type for AbstractCurrency
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractCurrency extends EntityPathBase<AbstractCurrency<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -20527153L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAbstractCurrency abstractCurrency = new QAbstractCurrency("abstractCurrency");

    public final QAbstractCore _super;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate;

    // inherited
    public final com.dm.common.entity.QCreateAudit createdBy;

    //inherited
    public final SimplePath<java.io.Serializable> id;

    // inherited
    public final com.dm.common.entity.QModifyAudit lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate;

    public final StringPath no = createString("no");

    public final EnumPath<com.dm.linfen.enums.NoEnums> noEnums = createEnum("noEnums", com.dm.linfen.enums.NoEnums.class);

    public final StringPath regionCode = createString("regionCode");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCurrency(String variable) {
        this((Class) AbstractCurrency.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCurrency(Path<? extends AbstractCurrency> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAbstractCurrency(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCurrency(PathMetadata metadata, PathInits inits) {
        this((Class) AbstractCurrency.class, metadata, inits);
    }

    public QAbstractCurrency(Class<? extends AbstractCurrency<? extends java.io.Serializable>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAbstractCore(type, metadata, inits);
        this.createDate = _super.createDate;
        this.createdBy = _super.createdBy;
        this.id = _super.id;
        this.lastModifiedBy = _super.lastModifiedBy;
        this.lastModifiedDate = _super.lastModifiedDate;
    }

}

