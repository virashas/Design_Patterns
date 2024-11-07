public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String property;

    private ConfigurationManager() {

        property = "defaultProperty";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}