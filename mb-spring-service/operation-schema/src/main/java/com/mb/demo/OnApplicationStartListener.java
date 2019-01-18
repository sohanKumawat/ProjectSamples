package com.mb.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.picker.service.PickerRequestDataService;
import com.mb.demo.redis.StudentServie;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.utility.JsonUtility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OnApplicationStartListener implements ApplicationListener<ApplicationEvent> {
	@Autowired
	StudentServie studentService;
	@Autowired
	PickerRequestDataService pickerRequestService;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// log.info("event: " + event.getTimestamp());
	}

	public static int counter;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
	//	pickerProductBean();
		// studentService.add();
	}

	private void pickerProductBean() {
		List<PickerProductLocationBean> pickerProductBean = pickerRequestService
				.getPickerTeamProducts(OperationType.SAPICKER, 1, 1, null, "1", "1");
		log.info("pickerProductBean Json " + JsonUtility.toJson(pickerProductBean));
	}

}
