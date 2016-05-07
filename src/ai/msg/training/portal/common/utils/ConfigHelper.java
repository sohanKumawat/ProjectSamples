package ai.msg.training.portal.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigRenderOptions;
import com.typesafe.config.ConfigValue;
import com.typesafe.config.ConfigValueType;

/**
 * Configuration management wrapper on top of com.typesafe.config.Config
 * 
 * @author Jay Gopalan
 */
public class ConfigHelper {
	private static String env = null;

	public static final String MSGAI_CONFIG_KEY = "msgai.config.file";
	public static final String DEFAULT_CONFIG_FILE = "conf/msgai/msgai.conf";

	public static final String SYSTEM_PROPERTIES = "__SYSTEM_PROPERTIES__";

	private static com.typesafe.config.Config CONFIG = null;

	public static com.typesafe.config.Config load() {
		com.typesafe.config.Config config = loadUsingSystemProperty(MSGAI_CONFIG_KEY, DEFAULT_CONFIG_FILE);
		return config;
	}
	    
	public static com.typesafe.config.Config loadUsingSystemProperty(String sysPropertyKey, String defaultValue) {
		String value = System.getProperty(sysPropertyKey);
		ConfigHelper.load(DEFAULT_CONFIG_FILE);
		if (StringUtility.isNullOrEmpty(value) && false == StringUtility.isNullOrEmpty(defaultValue)) {
			value = defaultValue;
		}

		if (StringUtility.isNullOrEmpty(value))
			return CONFIG;

		return load(value);
	}

	public static com.typesafe.config.Config getConfigUsingSystemProperty(
			String sysPropertyKey, String defaultValue, com.typesafe.config.Config configToBeMerged) {
		String value = System.getProperty(sysPropertyKey);

		if (StringUtility.isNullOrEmpty(value) && false == StringUtility.isNullOrEmpty(defaultValue)) {
			value = defaultValue;
		}

		if (StringUtility.isNullOrEmpty(value))
			return null;

		return getConfig(new File(value), configToBeMerged);
	}

	public static com.typesafe.config.Config load(String configFile) {
		return load(configFile, true);
	}

	public static com.typesafe.config.Config load(String configFile, boolean preferSysProperties) {
		try {
			if (preferSysProperties) {
				com.typesafe.config.Config sysConfig = ConfigFactory.parseProperties(System.getProperties());
				merge(sysConfig);
			}

			com.typesafe.config.Config config = null;
			if (false == StringUtility.isNullOrEmpty(configFile)) {
				File file = new File(configFile);

				if (false == file.exists()) {
					config = ConfigFactory.parseResources(configFile);
				} else {
					config = ConfigFactory.parseFile(file);
				}
				System.out.println("Config - loaded config file " + configFile);
			} else {
				System.err.println("Config - Supplied config file is invalid, hence loading only system properties");
			}

			merge(config);
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		if (false == preferSysProperties) {
			com.typesafe.config.Config sysConfig = ConfigFactory.parseProperties(System.getProperties());
			merge(sysConfig);
		}

//		ConfigObject configObject = handleCommands(CONFIG.root());
//		CONFIG = configObject.toConfig();

		if (null != CONFIG)
			CONFIG = CONFIG.resolve();
		
		return CONFIG;
	}

	public static com.typesafe.config.Config getConfig(File configFile) {
		return getConfig(configFile, null);
	}

	public static com.typesafe.config.Config getConfig(File configFile, com.typesafe.config.Config configToBeMerged) {
		return getConfig(configFile, false, configToBeMerged);
	}

	public static com.typesafe.config.Config getConfig(File configFile, 
			boolean loadSystemProperites, com.typesafe.config.Config configToBeMerged) {
		com.typesafe.config.Config config = null;
		try {
			if (loadSystemProperites) {
				com.typesafe.config.Config sysConfig = ConfigFactory.parseProperties(System.getProperties());
				config = doMerge(config, sysConfig);
			}

			com.typesafe.config.Config fileConfig = null;
			if (null != configFile) {
				if (false == configFile.exists()) {
					fileConfig = ConfigFactory.parseResources(configFile.toString());
				} else {
					fileConfig = ConfigFactory.parseFile(configFile);
				}
				System.out.println("getConfig - loaded config file " + configFile);
			} else {
				System.err.println("getConfig - Supplied config file is invalids");
			}

			config = doMerge(config, fileConfig, false);

			if (null != configToBeMerged) {
				config = doMerge(config, configToBeMerged, false);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}

//		ConfigObject configObject = handleCommands(config.root());
//		config = configObject.toConfig();

		if (null != config)
			config = config.resolve();

		return config;
	}

	public static com.typesafe.config.Config getConfig(String... configFiles) {
		com.typesafe.config.Config config = null;

		for(String configFile : configFiles) {
			if (StringUtility.isNullOrEmpty(configFile)) {
				System.err.printf("Config file %s is NULL or empty\n", configFile);
				continue;
			}

			com.typesafe.config.Config fileConfig = null;

			if (SYSTEM_PROPERTIES.equals(configFile)) {
				fileConfig = ConfigFactory.parseProperties(System.getProperties());
			} else {
				fileConfig = loadFromFile(new File(configFile));
			}

			if (null != config) {
				config = doMerge(config, fileConfig, false);
			} else {
				config = fileConfig;
			}
		}

		if (null != config)
			config = config.resolve();

		return config;
	}

	public static com.typesafe.config.Config loadFromFile(File configFile) {
		com.typesafe.config.Config config = null;

		if (null == configFile) {
			throw new IllegalArgumentException("Config file " + configFile + ", is NULL");
		}

		if (false == configFile.exists()) {
			config = ConfigFactory.parseResources(configFile.toString());
		} else {
			config = ConfigFactory.parseFile(configFile);
		}

		System.out.println("loadFromFile - loaded config file " + configFile);

		if (null != config) {
			config = config.resolve();
			System.out.println("Config from config file " + configFile + " is " + config.toString());
		} else {
			System.err.println("***ERROR*** Config from config file " + configFile + " is NULL");
		}

		return config;
	}

	public static com.typesafe.config.Config merge(com.typesafe.config.Config config) {
		CONFIG = doMerge(CONFIG, config); // now with nonEnvConfig
		return CONFIG;
	}

	public static com.typesafe.config.Config merge(Properties props) {
		CONFIG = doMerge(CONFIG, toConfig(props)); // now with nonEnvConfig
		return CONFIG;
	}

	private static com.typesafe.config.Config doMerge(com.typesafe.config.Config mainConfig, com.typesafe.config.Config configToBeMerged) {
		return doMerge(mainConfig, configToBeMerged, true);
	}

	private static com.typesafe.config.Config doMerge(com.typesafe.config.Config mainConfig, com.typesafe.config.Config configToBeMerged, boolean bResolve) {
		com.typesafe.config.ConfigObject nonEnvConfig = null;

		try {
			nonEnvConfig = configToBeMerged.getObject(getEnv());
		} catch(com.typesafe.config.ConfigException ignored) {
		}

		if (null != mainConfig && null != configToBeMerged)
			mainConfig = mainConfig.withFallback(configToBeMerged);
		else if (null == mainConfig && null != configToBeMerged)
			mainConfig = configToBeMerged;

		if (null != nonEnvConfig)
			mainConfig = mainConfig.withFallback(nonEnvConfig);

		if (null != mainConfig && bResolve)
			mainConfig = mainConfig.resolve();

		return mainConfig;
	}

	public static com.typesafe.config.ConfigObject mergeConfigObjects(
			com.typesafe.config.ConfigObject configObjectToMergeWith, 
			com.typesafe.config.ConfigObject configObjectToBeMerged) {
		com.typesafe.config.Config configToMergeWith = 
				(null != configObjectToMergeWith ? configObjectToMergeWith.toConfig() : null);
		com.typesafe.config.Config configToBeMerged = 
				(null != configObjectToBeMerged ? configObjectToBeMerged.toConfig() : null);

		com.typesafe.config.Config mergedConfig = mergeConfigs(configToMergeWith, configToBeMerged);

		return (null != mergedConfig ? mergedConfig.root() : null);
	}

	public static com.typesafe.config.Config mergeConfigs(
			com.typesafe.config.Config configToMergeWith, 
			com.typesafe.config.Config configToBeMerged) {
		com.typesafe.config.ConfigObject nonEnvConfig = null;

		if (null != configToBeMerged) {
			try {
				nonEnvConfig = configToBeMerged.getObject(getEnv());
			} catch(com.typesafe.config.ConfigException ignored) {
			}
		}

		if (null != configToMergeWith && null != configToBeMerged)
			configToMergeWith = configToMergeWith.withFallback(configToBeMerged);
		else if (null == configToMergeWith && null != configToBeMerged)
			configToMergeWith = configToBeMerged;

		if (null != nonEnvConfig)
			configToMergeWith = configToMergeWith.withFallback(nonEnvConfig);

		if (null != configToMergeWith)
			configToMergeWith = configToMergeWith.resolve();

		return configToMergeWith;
	}

	public static com.typesafe.config.Config getConfig() {
		return CONFIG;
	}
	
	public static com.typesafe.config.Config toConfig(Map<String, ? extends Object> map) {
		return ConfigFactory.parseMap(map).resolve();
	}

//	public static com.typesafe.config.ConfigObject handleCommands(com.typesafe.config.ConfigObject configObject) {
//		if (null == configObject) return configObject;
//
//		configObject = handleCommands(configObject, null);
//
//		return configObject;
//	}
//
//	private static com.typesafe.config.ConfigObject handleCommands(com.typesafe.config.ConfigObject configObject, String path) {
//		for (String key : configObject.unwrapped().keySet()) {
//			String childPath = null;
//
//			if (null != path)
//				childPath = path + "." + key;
//			else
//				childPath = key;
//
//			ConfigValue cv = configObject.get(key);
//
//			if (cv.valueType().equals(ConfigValueType.OBJECT)) {
//				handleCommands((com.typesafe.config.ConfigObject) cv, childPath);
//			} else {
//				if ("__IMPORT_CONFIG__".equals(key)) {
//					String importConfigFile = cv.unwrapped().toString();
//
//					com.typesafe.config.Config importConfigs = ConfigFactory.parseFile(new File(importConfigFile));
//
//					System.out.println("childPath = ["+path+"] importConfigs = " + importConfigs);
//
//					if (null != path)
//						configObject = configObject.atPath(path).withFallback(importConfigs).root();//.getObject(path);
//					else
//						configObject = configObject.withFallback(importConfigs);//.getObject(path);
//
//					System.out.println("childPath = ["+path+"] configObject = " + configObject);//.atPath(path).withFallback(importConfigs));
//				}
//			}
//		}
//
//		return configObject;
//	}

	public static String toString(com.typesafe.config.Config config) {
		return config.root().render(ConfigRenderOptions.concise());
	}

	public Map<String, Object> toMap() {
		return toMap(CONFIG);
	}

	public Properties toProperties() {
		Properties props = new Properties();
		props.putAll(toMap(CONFIG));
		return props;
	}

	public static String getEnv() {
		if (null == ConfigHelper.env) {
			if (null != System.getProperty("env")) {
				System.err.println("*** Environment set to " + System.getProperty("env"));
				env = System.getProperty("env");
			} else {
				System.err.println("*** NO environment set, hence assuming DEV");
				env = "dev";
			}
		}

		return env;
	}

	public static void setEnv(String env) {
		if (null != ConfigHelper.env)
			return;

		ConfigHelper.env = env;
	}

	public static Map<String, Object> toMap(com.typesafe.config.Config config) {
		return toMap(config.root());
	}

	public static Properties toProperties(com.typesafe.config.Config config) {
		Properties props = new Properties();
		props.putAll(toMap(config));
		return props;
	}

	public static Map<String, Object> toMap(com.typesafe.config.ConfigObject configObject) {
		Map<String, Object> configMap = new HashMap<String, Object>();

		if (null != configObject)
			configObject = configObject.toConfig().resolve().root();

		return toMap(configMap, configObject, null);
	}

	public static Properties toProperties(com.typesafe.config.ConfigObject configObject) {
		Properties props = new Properties();
		props.putAll(toMap(configObject));
		return props;
	}

	private static Map<String, Object> toMap(Map<String, Object> configMap, 
			com.typesafe.config.ConfigObject configObject, String path) {
		Map<String, Object> unwrapped = configObject.unwrapped();

		for (String key : unwrapped.keySet()) {
			String childPath = null;

			if (null != path)
				childPath = path + "." + key;
			else
				childPath = key;

			ConfigValue cv = configObject.get(key);

			if (cv.valueType().equals(ConfigValueType.OBJECT)) {
				toMap(configMap, (com.typesafe.config.ConfigObject) cv, childPath);
			} else if (cv.valueType().equals(ConfigValueType.LIST)) {
				configMap.put(childPath, ((com.typesafe.config.ConfigList) cv).unwrapped());
			} else {
				configMap.put(childPath, cv.unwrapped());
			}
		}

		return configMap;
	}

	public static com.typesafe.config.Config toConfig(Properties props) {
		return ConfigFactory.parseProperties(props).resolve();
	}

	public static boolean isDefined(String key) {
		return isDefined(CONFIG, key);
	}

	public static boolean isDefined(com.typesafe.config.Config config, String key) {
		return config.hasPath(key);
	}

	public static ConfigObject getObject(String key) {
		return CONFIG.getObject(key);
	}

	public static String getString(String key) {
		return getString(CONFIG, key);
	}

	public static String getString(com.typesafe.config.Config config, String key) {
		return config.getString(key);
	}

	public static String getSafeString(String key) {
		return getSafeString(CONFIG, key);
	}

	public static String getSafeString(com.typesafe.config.Config config, String key) {
		if (config.hasPath(key))
			return config.getString(key);

		return null;
	}

	public static String getStringSafe(String key, String defaultKey, String defaultValue) {
		return getStringSafe(CONFIG, key, defaultKey, defaultValue);
	}

	public static String getStringSafe(com.typesafe.config.Config config, String key, String defaultKey, String defaultValue) {
		if (config.hasPath(key))
			return config.getString(key);
		else if (config.hasPath(defaultKey))
			return config.getString(defaultKey);
		else
			return defaultValue;
	}

	public static int getIntSafe(String key, String defaultKey, int defaultValue) {
		if (CONFIG.hasPath(key))
			return CONFIG.getInt(key);
		else if (CONFIG.hasPath(defaultKey))
			return CONFIG.getInt(defaultKey);
		else
			return defaultValue;
	}

	public static List<Object> getList(String key) {
		return getList(CONFIG, key);
	}
	
	public static List<Object> getList(com.typesafe.config.Config config, String key) {
		return config.getList(key).unwrapped();
	}
	
	public static String getString(String key, String defaultValue) {
		return getString(CONFIG, key, defaultValue);
	}

	public static String getString(com.typesafe.config.Config config, String key, String defaultValue) {
		String value = getSafeString(config, key);

		if (null != value)
			return value;

		return defaultValue;
	}

    public static int getInt(String key) {
        return getInt(CONFIG, key);
    }

    public static int getInt(com.typesafe.config.Config config, String key) {
        return StringUtility.toInteger(config.getString(key));
    }

    public static int getInt(String key, int defaultValue) {
        return getInt(CONFIG, key, defaultValue);
    }

    public static int getInt(com.typesafe.config.Config config, String key, int defaultValue) {
        return StringUtility.toInteger(getSafeString(config, key), defaultValue);
    }

    public static boolean getBoolean(String key) {
        return StringUtility.toBoolean(getString(key));
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return StringUtility.toBoolean(getString(key), defaultValue);
    }

    public static boolean getBoolean(com.typesafe.config.Config config, String key, boolean defaultValue) {
        return StringUtility.toBoolean(getSafeString(config, key), defaultValue);
    }

	public static String[] getArray(String key, String delimiter) {
		return getArray(CONFIG, key, delimiter);
	}

	public static String[] getArray(com.typesafe.config.Config config, String key, String delimiter) {
		return getArray(config, key, null, delimiter);
	}

	public static String[] getArray(String key, String defaultValue, String delimiter) {
		return getArray(CONFIG, key, defaultValue, delimiter);
	}

	public static String[] getArray(com.typesafe.config.Config config, String key, String defaultValue, String delimiter) {
		String value = getString(config, key, defaultValue);

		if (StringUtility.isNullOrEmpty(value))
			return new String[0];

		return value.split(delimiter);
	}

	public static Object getObject(ConfigObject configObject, String key) {
		ConfigValue cv = configObject.get(key);

		if (null == cv) 
			return null;

		return configObject.get(key).unwrapped();
	}

	public static String getString(ConfigObject configObject, String key) {
		ConfigValue cv = configObject.get(key);

		if (null == cv) 
			return null;

		if (ConfigValueType.STRING.equals(cv.valueType()))
			return (String) configObject.get(key).unwrapped();
		else
			return configObject.get(key).unwrapped().toString();
	}
	
    public static int getInt(ConfigObject configObject, String key) {
        return StringUtility.toInteger(getString(configObject, key));
    }

    public static int getInt(ConfigObject configObject, String key, int defaultValue) {
        return StringUtility.toInteger(getString(configObject, key), defaultValue);
    }

	public static Boolean getBoolean(ConfigObject configObject, String key) {
		ConfigValue cv = configObject.get(key);

		if (null == cv) 
			return null;

		if (ConfigValueType.BOOLEAN.equals(cv.valueType()))
			return (Boolean) configObject.get(key).unwrapped();

		throw new IllegalArgumentException("Value of ConfigObject.getBoolean for key '" + key + "', is not of type Boolean");
	}
	
	public static Number getNumber(ConfigObject configObject, String key) {
		ConfigValue cv = configObject.get(key);

		if (null == cv) 
			return null;

		if (ConfigValueType.NUMBER.equals(cv.valueType()))
			return (Number) configObject.get(key).unwrapped();

		throw new IllegalArgumentException("Value of ConfigObject.getNumber for key '" + key + "', is not of type Number");
	}

	public static void main(String[] args) throws Exception {
		ConfigHelper.load("conf/msgai/msgai.conf");
		System.out.println("config => " + ConfigHelper.toMap(ConfigHelper.getConfig()));
	}
}
