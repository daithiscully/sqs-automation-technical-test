package utilities.selenium;

import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by David-Scully on 06/09/2016.
 */
public interface IBrowser {
    WebDriver create(URL seleniumHubUrl);
}
