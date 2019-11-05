package com.dm.linfen.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMonitorManager is a Querydsl query type for MonitorManager
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMonitorManager extends EntityPathBase<MonitorManager> {

    private static final long serialVersionUID = 1847108294L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMonitorManager monitorManager = new QMonitorManager("monitorManager");

    public final com.dm.linfen.entity.core.QAbstractCurrency _super;

    public final NumberPath<Integer> audioSwitch = createNumber("audioSwitch", Integer.class);

    public final StringPath cameraUrl = createString("cameraUrl");

    public final StringPath coverPhoto = createString("coverPhoto");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate;

    // inherited
    public final com.dm.common.entity.QCreateAudit createdBy;

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    // inherited
    public final com.dm.common.entity.QModifyAudit lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate;

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath monitorName = createString("monitorName");

    public final StringPath monitorPullUrl = createString("monitorPullUrl");

    public final StringPath monitorPushUrl = createString("monitorPushUrl");

    //inherited
    public final StringPath no;

    //inherited
    public final EnumPath<com.dm.linfen.enums.NoEnums> noEnums;

    public final StringPath pullPassword = createString("pullPassword");

    public final StringPath pushPassword = createString("pushPassword");

    //inherited
    public final StringPath regionCode;

    public final StringPath roomNumber = createString("roomNumber");

    public final BooleanPath run = createBoolean("run");

    public final StringPath scenic = createString("scenic");

    public final StringPath transformType = createString("transformType");

    public final NumberPath<Integer> width = createNumber("width", Integer.class);

    public QMonitorManager(String variable) {
        this(MonitorManager.class, forVariable(variable), INITS);
    }

    public QMonitorManager(Path<? extends MonitorManager> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMonitorManager(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMonitorManager(PathMetadata metadata, PathInits inits) {
        this(MonitorManager.class, metadata, inits);
    }

    public QMonitorManager(Class<? extends MonitorManager> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.dm.linfen.entity.core.QAbstractCurrency(type, metadata, inits);
        this.createDate = _super.createDate;
        this.createdBy = _super.createdBy;
        this.lastModifiedBy = _super.lastModifiedBy;
        this.lastModifiedDate = _super.lastModifiedDate;
        this.no = _super.no;
        this.noEnums = _super.noEnums;
        this.regionCode = _super.regionCode;
    }

}

