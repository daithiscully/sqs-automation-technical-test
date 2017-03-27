package utilities.selenium;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SeleniumFactory {

    private static List<WebDriver> drivers = new ArrayList<>();

    /**
     * Defaults to Chrome if the browserType parameter is not == "CHROME", "FIREFOX", or "IE"
     *
     * @param browserType
     * @param seleniumHubUrl
     * @return
     */
    public static WebDriver getDriver(String browserType, URL seleniumHubUrl) {
        if (browserType.equalsIgnoreCase("CHROME")) {
            WebDriver wd = new Chrome().create(seleniumHubUrl);
            drivers.add(wd);
            return wd;
        } else if (browserType.equalsIgnoreCase("FIREFOX")) {
            WebDriver wd = new Firefox().create(seleniumHubUrl);
            drivers.add(wd);
            return wd;
        } else if (browserType.equalsIgnoreCase("IE")) {
            WebDriver wd = new InternetExplorer().create(seleniumHubUrl);
            drivers.add(wd);
            return wd;
        } else {
            WebDriver wd = new Chrome().create(seleniumHubUrl);
            drivers.add(wd);
            return wd;
        }
    }

    public static void cleanUpDrivers() {
        drivers.forEach(webDriver -> {
            if (webDriver != null) {
                webDriver.quit();
            }
        });
    }


}
