package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ResetPasswordPage;
import pages.SearchResultsPage;
import pages.SignInPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static final String OPTINUM_NUTRITION_HOME_PAGE_URL = "https://www.optimumnutrition.com/en-gb";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.214:4444/wd/hub"), capabilityFactory.getCapabilities(browser))); // MyHome WiFi IPv4 Address
//        driver.set(new RemoteWebDriver(new URL("http://192.168.56.254:4444/wd/hub"), capabilityFactory.getCapabilities(browser))); // 4g Kyivstar IPv4 Address
        getDriver().manage().window().maximize();
        getDriver().get(OPTINUM_NUTRITION_HOME_PAGE_URL);
    }

    @AfterMethod
    public void closeDriver() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SignInPage getSignInPage() {
        return new SignInPage(getDriver());
    }

    public ResetPasswordPage getResetPasswordPage() {
        return new ResetPasswordPage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }
}
