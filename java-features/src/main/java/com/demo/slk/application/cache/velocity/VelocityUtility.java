package com.demo.slk.application.cache.velocity;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityUtility {
	VelocityContext context;

	public VelocityUtility() {
		Velocity.init();
		context = new VelocityContext();
	}

	public void put(String key, Object value) {
		context.put(key, value);
	}

	public String execute(String value) {
		StringWriter writer = new StringWriter();
		Velocity.evaluate(context, writer, "TemplateName", value);
		return writer.toString();
	}

	public static void main(String str[]) {
		VelocityUtility vUtility = new VelocityUtility();
		vUtility.put("name", "sohan");
		String val = vUtility.execute("my name $name");
		System.out.println(val);

	}
}
