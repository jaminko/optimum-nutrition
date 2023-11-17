package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage {
    @FindBy(xpath = "//h2[@class='forgotten-password__headline']")
    public WebElement resetPasswordText;

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }
}
