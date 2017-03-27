package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * A class to hold any common actions you would like available to all you PageObjects such as taking screenshots
 */
public class BasePage {

    public WebDriver driver;

    /**
     * Take a screenshot of the current web page visible on the Selenium WebDriver
     *
     * @param name   The name you wish to give the screenshot
     * @throws IOException File not created. produced by failed or interrupted I/O operations
     */
    public void takeScreenShot(String name) throws IOException {
        // java.util.Date date= new java.util.Date();
        long time = System.currentTimeMillis();
        File screenShotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File("screenshots/" + name + "_" + time + ".png"));
    }

}
