package utilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by David-Scully on 06/09/2016.
 */
public class InternetExplorer implements IBrowser {

    @Override
    public WebDriver create(URL seleniumHubUrl) {
        System.out.println("Creating an Internet Explorer Remote Web Driver");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability("nativeEvents", false);
        caps.setCapability("unexpectedAlertBehaviour", "accept");
        caps.setCapability("ignoreProtectedModeSettings", true);
        caps.setCapability("disable-popup-blocking", true);
        caps.setCapability("enablePersistentHover", false);
        caps.setBrowserName("internet explorer");
        return new RemoteWebDriver(seleniumHubUrl, caps);
    }

}
