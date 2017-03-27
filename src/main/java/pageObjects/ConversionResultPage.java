package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.NumberFormatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ConversionResultPage extends BasePage {

    @FindBy(xpath = "//*[@id='ucc-container']//span[@class='uccResultAmount']")
    private WebElement resultAmount;


    public ConversionResultPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    /**
     * Retrieve the result of the currency conversion from the result page
     * @return The result formatted (as a double) to two decimal places
     * @throws ParseException
     */
    public double getConversionResult() throws ParseException {
        String actualConvertedValueString = resultAmount.getText();
        NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        Number number = format.parse(actualConvertedValueString);
        double actualConvertedValue = number.doubleValue();

        return NumberFormatter.formatNumberToTwoDecimalPlaces(actualConvertedValue);
    }


}
