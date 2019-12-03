package com.dm.kpi.core.entity;

import java.time.ZonedDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import com.dm.common.entity.Audit;
import com.dm.common.entity.CreateAudit;
import com.dm.common.entity.ModifyAudit;

/**
 * 指标数据(KPI)抽象类
 * 
 * @author LiDong
 *
 * @param <V>
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AbstractIndex<V extends Number>
		implements Persistable<Long>, Auditable<Audit, Long, ZonedDateTime>, AreaData {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "value_")
	private V value;

	@Override
	@Nullable
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractIndex<?> other = (AbstractIndex<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@CreatedDate
	@Column(name = "create_time_")
	private ZonedDateTime createTime;

	@LastModifiedDate
	@Column(name = "update_time_")
	private ZonedDateTime updateTime;

	@Column(name = "region_code_", length = 50)
	private String regionCode;

	@Column(name = "region_name_", length = 100)
	private String regionName;

	@Embedded
	private CreateAudit createBy;

	@Embedded
	private ModifyAudit lastModifiedBy;

	@CreatedBy
	public void setCreatedBy(Audit createdBy) {
		this.createBy = new CreateAudit(createdBy);
	}

	@LastModifiedBy
	public void setLastModifiedBy(Audit lastModifiedBy) {
		this.lastModifiedBy = new ModifyAudit(lastModifiedBy);
	}

	@Override
	public Optional<Audit> getCreatedBy() {
		return Optional.ofNullable(this.createBy);
	}

	@Override
	public Optional<Audit> getLastModifiedBy() {
		return Optional.ofNullable(this.lastModifiedBy);
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String getRegionCode() {
		return regionCode;
	}

	@Override
	public String getRegionName() {
		return regionName;
	}

	@Override
	public Optional<ZonedDateTime> getCreatedDate() {
		return Optional.ofNullable(this.createTime);
	}

	@Override
	public void setCreatedDate(ZonedDateTime creationDate) {
		this.createTime = creationDate;
	}

	@Override
	public Optional<ZonedDateTime> getLastModifiedDate() {
		return Optional.ofNullable(this.updateTime);
	}

	@Override
	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.updateTime = lastModifiedDate;
	}

}
