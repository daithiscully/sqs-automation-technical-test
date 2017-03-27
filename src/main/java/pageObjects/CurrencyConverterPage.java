package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CurrencyConverterPage extends BasePage {

    private final String URL = "http://www.xe.com/currencyconverter/";

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "from")
    private WebElement fromCurrency; // Maybe use the hidden input with id=from_var and set the value

    @FindBy(id = "to")
    private WebElement toCurrency; // Maybe use the hidden input with id=from_var and set the value

    @FindBy(id = "ucc_go_btn_svg")
    private WebElement convertButton;

    @FindBy()
    private WebElement currentExchangeRate;


    public CurrencyConverterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
        this.driver.get(this.URL);
    }

    public WebDriver convert(Double amount, String from, String to) {
        System.out.println("The current exchange rate from " + from + " to " + to + " is = " + getCurrentExchangeRate(from, to));
        setAmount(amount)
                .setFromCurrency(from)
                .setToCurrency(to)
                .clickConvertButton();
        return this.driver;
    }


    private CurrencyConverterPage setAmount(Double amount) {
        amountInput.clear();
        amountInput.sendKeys(amount.toString());
        return this;
    }

    private CurrencyConverterPage setFromCurrency(String from) {
        fromCurrency.sendKeys(from);
        fromCurrency.sendKeys(Keys.ENTER);

        return this;
    }

    private CurrencyConverterPage setToCurrency(String to) {
        toCurrency.sendKeys(to);
        toCurrency.sendKeys(Keys.ENTER);
        return this;
    }

    private CurrencyConverterPage clickConvertButton() {
        convertButton.click();
        return this;
    }

    public Double getCurrentExchangeRate(String fromCurrency, String toCurrency) {
        WebElement exchangeRate = this.driver.findElement(
                By.xpath("//*[@id=\"xRatesBxTable\"]//*[(@href='/currencycharts/?from=" + fromCurrency + "&to=" + toCurrency + "')]"));
        return Double.parseDouble(exchangeRate.getText());
    }

}
