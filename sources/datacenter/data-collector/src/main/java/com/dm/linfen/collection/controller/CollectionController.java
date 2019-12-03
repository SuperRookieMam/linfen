package com.dm.linfen.collection.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.linfen.collection.dto.TaskDto;

/**
 * 
 * @author LiDong
 *
 */
@RestController
@RequestMapping("schedule/collections")
public class CollectionController implements ApplicationContextAware {

	private ApplicationContext ac;

	@Autowired
	private TaskExecutor taskExecutor;

	@PostMapping
	public String executeTask(@RequestBody TaskDto task) {
		Object runable = ac.getBean(task.getName());
		if (runable instanceof Runnable) {
			taskExecutor.execute((Runnable) runable);
		}
		return "success";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ac = applicationContext;
	}

}
