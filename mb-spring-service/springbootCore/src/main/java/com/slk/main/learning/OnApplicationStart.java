package com.slk.main.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.slk.main.learning.action.ActionCaller;

//@Slf4j
@Component
/**
 * <p>
 * OnApplicationStart class.
 * </p>
 *
 * @author sohankumawat
 * @version $Id: $Id
 */
public class OnApplicationStart {

	@Autowired
	ActionCaller caller;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			caller.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
