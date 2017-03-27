package currencyConversionTests;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObjects.ConversionResultPage;
import pageObjects.CurrencyConverterPage;
import utilities.NumberFormatter;
import utilities.Retry;
import utilities.selenium.SeleniumFactory;
import utilities.RetrieveTestData;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCorrectCurrencyConversion {

    @Rule
    public Retry retry = new Retry(3);

    @Parameterized.Parameter
    public JSONObject json;

    @Parameterized.Parameters
    public static Collection data() throws IOException, ParseException {
        return RetrieveTestData.data();
    }

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        String browserName = "CHROME";
        URL hubURL = new URL("http://localhost:4444/wd/hub");
        driver = SeleniumFactory.getDriver(browserName, hubURL);
    }

    @Test
    public void convertCurrency() throws Exception {
        // Retrieve the test data from the json file in /src/main/resources/test-data.json
        String testName = String.valueOf(json.get("test_name"));
        String fromCurrency = String.valueOf(json.get("fromCurrency"));
        String toCurrency = String.valueOf(json.get("toCurrency"));
        double amount = Double.parseDouble(String.valueOf(json.get("amount")));

        // Open the web page to the XE currency conversion page
        CurrencyConverterPage currencyConverterPage = new CurrencyConverterPage(driver);

        // Get the exchange rate from the table found on the landing page above and multiply it by the amount to convert
        double expectedConvertedValue = amount * currencyConverterPage.getCurrentExchangeRate(fromCurrency, toCurrency);
        double formattedExpectedConvertedValue = NumberFormatter.formatNumberToTwoDecimalPlaces(expectedConvertedValue);

        System.out.println("The expected amount converted and rounded: " + formattedExpectedConvertedValue);

        driver = currencyConverterPage.convert(
                amount,
                fromCurrency,
                toCurrency
        );

        ConversionResultPage conversionResultPage = new ConversionResultPage(driver);
        System.out.println("The actual amount converted and rounded: " + conversionResultPage.getConversionResult());

        Assert.assertEquals(formattedExpectedConvertedValue, conversionResultPage.getConversionResult(), 0.02);

    }

    @AfterClass
    public static void tearDown() {
        SeleniumFactory.cleanUpDrivers();
    }
}
