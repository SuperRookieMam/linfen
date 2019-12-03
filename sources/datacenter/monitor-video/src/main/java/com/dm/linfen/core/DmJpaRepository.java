package com.dm.linfen.core;

import com.dm.linfen.enums.NoEnums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;

public class DmJpaRepository<T, ID> extends SimpleJpaRepository<T, ID> {

	public DmJpaRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
	}

	/*
	 * 重写save,自动生成no
	 */
	@Override
	public <S extends T> S save(S entity) {
		super.save(entity);
		this.saveNo(entity);
		return entity;

	}

	private <S extends T> void saveNo(S entity) {
		Class<?> clazz = entity.getClass();
		try {
			Field noField = clazz.getSuperclass().getDeclaredField("no");
			if (noField != null) {
				noField.setAccessible(true);
				String no = (String) noField.get(entity);
				if (StringUtils.isBlank(no)) {
					// code编码
					Field regionField = clazz.getSuperclass().getDeclaredField("regionCode");
					regionField.setAccessible(true);
					String regionCode = (String) regionField.get(entity);
					// 资源code编码
					Field noEumnField = clazz.getSuperclass().getDeclaredField("noEnums");
					noEumnField.setAccessible(true);
					NoEnums noEnum = (NoEnums) noEumnField.get(entity);
					// ID编码
					Field idField = clazz.getSuperclass().getSuperclass().getDeclaredField("id");
					idField.setAccessible(true);
					@SuppressWarnings("unchecked")
					ID id = (ID) idField.get(entity);

					if (regionCode != null && noEnum != null && id != null) {
						// 拼装no
						String noString = regionCode + noEnum.getValue()
								+ String.format("%06d", Long.parseLong(id.toString()));
						// 重新组装更新
						noField.set(entity, noString);
						super.save(entity);
					}
				}
			}

		} catch (NoSuchFieldException e) {
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
