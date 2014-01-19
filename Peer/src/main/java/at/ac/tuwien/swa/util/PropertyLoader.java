package at.ac.tuwien.swa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	private static PropertyLoader instance = null;
	private static Properties properties;

	protected PropertyLoader() {
		loadProperties();
	}

	public static PropertyLoader getInstance() {
		if (instance == null) {
			instance = new PropertyLoader();
		}
		return instance;
	}

	private void loadProperties() {
		// Get the inputStream
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("peer.properties");
		properties = new Properties();
		// load the inputStream using the Properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return properties;
	}

}
