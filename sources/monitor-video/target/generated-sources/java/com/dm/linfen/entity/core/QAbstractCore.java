package com.dm.linfen.entity.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAbstractCore is a Querydsl query type for AbstractCore
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractCore extends EntityPathBase<AbstractCore<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -925428131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAbstractCore abstractCore = new QAbstractCore("abstractCore");

    public final DateTimePath<java.time.ZonedDateTime> createDate = createDateTime("createDate", java.time.ZonedDateTime.class);

    public final com.dm.common.entity.QCreateAudit createdBy;

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    public final com.dm.common.entity.QModifyAudit lastModifiedBy;

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCore(String variable) {
        this((Class) AbstractCore.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCore(Path<? extends AbstractCore> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAbstractCore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractCore(PathMetadata metadata, PathInits inits) {
        this((Class) AbstractCore.class, metadata, inits);
    }

    public QAbstractCore(Class<? extends AbstractCore<? extends java.io.Serializable>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.dm.common.entity.QCreateAudit(forProperty("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new com.dm.common.entity.QModifyAudit(forProperty("lastModifiedBy")) : null;
    }

}

