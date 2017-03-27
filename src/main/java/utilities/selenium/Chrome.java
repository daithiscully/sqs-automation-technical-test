package utilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by David-Scully on 06/09/2016.
 */
public class Chrome implements IBrowser {

    @Override
    public WebDriver create(URL seleniumHubUrl) {
        System.out.println("Creating a Chrome Remote Web Driver");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // Disables the disable developer mode extensions pop up
        options.addArguments("--start-maximized"); // Starts the Driver in fullscreen
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return new RemoteWebDriver(seleniumHubUrl, caps);
    }

}
