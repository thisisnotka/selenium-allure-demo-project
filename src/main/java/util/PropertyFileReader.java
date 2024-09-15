package util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyFileReader {
    private static final Logger LOGGER = Logger.getLogger(PropertyFileReader.class.getName());
    private static final Path CONFIG_FILE_PATH = Paths.get("./src/test/resources/config.properties");

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();

        try (InputStream input = Files.newInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading properties file: " + CONFIG_FILE_PATH, e);
            return null;
        }
    }
}
