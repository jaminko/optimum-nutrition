package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='main-header__logo']")
    private WebElement mainHeaderLogo;
    @FindBy(xpath = "//input[@placeholder='Search for products']")
    private WebElement searchInputForm;
    @FindBy(xpath = "//button[contains(@class,'search-form__button')]")
    private WebElement searchButton;
    @FindBy(xpath = "//span[contains(@class,'account-menu__text')]")
    private WebElement signInRegister;
    @FindBy(xpath = "//a[contains(@class,'nav-cart__link js-mini-cart-link')]")
    private WebElement basket;
    @FindBy(xpath = "//a[@title='Contact']")
    private WebElement contactUsFooterLink;
    @FindBy(xpath = "//a[@title='Shop by Product']")
    private WebElement shopByProductHeaderLink;
    @FindBy(xpath = "//a[@title='Energy']")
    public WebElement energySubPage;

    @FindBy(xpath = "//li[@class='active mobile-display']")
    public WebElement energySubPageBreadcrumbs;


    @FindBy(xpath = "//div[@class='empty-cart__message']")
    public WebElement emptyBasketTextMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void mainLogoClick() {
        mainHeaderLogo.click();
    }

    public void searchByKeyWord(final String keyword) {
        searchInputForm.sendKeys(keyword);
        searchButton.click();
    }

    public void setSignInRegisterClick() {
        signInRegister.click();
    }

    public void basketClick() {
        basket.click();
    }

    public void contactUsFooterLinkClick() {
        contactUsFooterLink.click();
    }

    public void shopByProductHeaderLinkHover() {
        Actions builder01 = new Actions(driver);
        builder01.moveToElement(shopByProductHeaderLink).pause(2000).
                click(energySubPage).pause(1000).build().perform(); // this method (test) fails without two pauses if we used FIREFOX - could not find another solution =(
    }
}
