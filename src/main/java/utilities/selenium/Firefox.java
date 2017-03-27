package utilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by David-Scully on 06/09/2016.
 */
public class Firefox implements IBrowser {

    @Override
    public WebDriver create(URL seleniumHubUrl) {
        System.out.println("Creating a Firefox Remote Web Driver");
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setBrowserName("firefox");
        return new RemoteWebDriver(seleniumHubUrl, caps);
    }

}
