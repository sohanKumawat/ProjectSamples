package ai.msg.training.portal.common.utils;

import org.springframework.core.env.PropertySource;

/**
 * Working with HOCON format (superset of JSON). 
 * For more info, https://github.com/typesafehub/config#using-hocon-the-json-superset
 * 
 * @author Jay Gopalan (gopalanj)
 */
public class HOCONPropertySource extends PropertySource<com.typesafe.config.Config> {
	public static final String NAME = "HOCONPropertySource";

	public HOCONPropertySource(String name, String configFile) {
		this(name, ConfigHelper.load(configFile, true));
	}

	public HOCONPropertySource(String name, com.typesafe.config.Config source) {
		super(name, source);
	}

	@Override
	public Object getProperty(String name) {
		return ConfigHelper.getSafeString(source, name);
	}

	@Override
	public boolean containsProperty(String name) {
		return ConfigHelper.isDefined(source, name);
	}

	public static HOCONPropertySource getInstance(String confFile) {
		return new HOCONPropertySource(NAME, confFile);
	}
}
