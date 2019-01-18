package com.slk.main.learning.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.main.learning.async.AsyncTask;

@Component
public class ActionCaller {

	@Autowired
	AsyncTask task;

	public void test() {
		task.doAsyncTask();
		System.out.println("hello");
	}

}
