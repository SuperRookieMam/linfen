package com.dm.data.manager.entity.core;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

import com.dm.common.entity.Audit;
import com.dm.common.entity.CreateAudit;
import com.dm.common.entity.ModifyAudit;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractCore<T extends Serializable> implements Auditable<Audit, T, ZonedDateTime> {

    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private T id;

    @Override
    @Nullable
    public T getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public int hashCode() {
        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        AbstractCore<?> that = (AbstractCore<?>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    @CreatedDate
    @Column(name = "create_date_")
    private ZonedDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date_")
    private ZonedDateTime lastModifiedDate;

    private CreateAudit createdBy;

    private ModifyAudit lastModifiedBy;

    @Override
    public Optional<Audit> getCreatedBy() {
        return Optional.ofNullable(this.createdBy);
    }

    @Override
    public void setCreatedBy(Audit createdBy) {
        this.createdBy = new CreateAudit(createdBy);
    }

    @Override
    public Optional<ZonedDateTime> getCreatedDate() {
        return Optional.ofNullable(this.createDate);
    }

    @Override
    public void setCreatedDate(ZonedDateTime creationDate) {
        this.createDate = creationDate;
    }

    @Override
    public Optional<Audit> getLastModifiedBy() {
        return Optional.ofNullable(this.lastModifiedBy);
    }

    @Override
    public void setLastModifiedBy(Audit lastModifiedBy) {
        this.lastModifiedBy = new ModifyAudit(lastModifiedBy);
    }

    @Override
    public Optional<ZonedDateTime> getLastModifiedDate() {
        return Optional.ofNullable(this.lastModifiedDate);
    }

    @Override
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
