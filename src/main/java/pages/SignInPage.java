package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='j_username']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='j_password']")
    private WebElement passWordField;
    @FindBy(xpath = "//a[@class='form-element__link']")
    private WebElement forgottenYourPasswordLink;
    @FindBy(xpath = "(//button[@class='btn btn__primary btn--full js-cta-animate'])[1]")
    private WebElement signInButton;
    @FindBy(xpath = "//span[contains(text(),'Invalid username or password.')]")
    public WebElement invalidUsernameOrPasswordErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Please enter your email address')]")
    public WebElement pleaseEnterYourEmailAddressErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Please enter your password')]")
    public WebElement pleaseEnterYourPasswordErrorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void singInWithInvalidCredentials() {
        UUID.randomUUID().toString();
        String arr[] = UUID.randomUUID().toString().split("-"); //Random text
        loginField.sendKeys(arr[0] + "@gmail.com");
        int pass = (int) (Math.random() * 20000); //Random number
        String password = String.valueOf(pass + arr[0]);
        passWordField.sendKeys(password);
    }

    public void signInWithEmptyLoginField() {
        UUID.randomUUID().toString();
        String arr[] = UUID.randomUUID().toString().split("-");
        int pass = (int) (Math.random() * 6000);
        String password = String.valueOf(pass + arr[0]);
        passWordField.sendKeys(password);
    }

    public void signInWithEmptyPassWordField() {
        UUID.randomUUID().toString();
        String arr[] = UUID.randomUUID().toString().split("-");
        loginField.sendKeys(arr[0] + "@gmail.com");
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void forgottenYourPassword() {
        Actions builder = new Actions(driver);
        builder.moveToElement(forgottenYourPasswordLink).doubleClick(forgottenYourPasswordLink).build().perform();
    }
}
