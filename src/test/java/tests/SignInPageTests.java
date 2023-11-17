package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends BaseTest {
    public static final String EXPECTED_QUERY_1 = "login?error=true";
    public static final String EXPECTED_SIGN_IN_REGISTER_PAGE_URL = "https://www.optimumnutrition.com/en-gb/login";

    @Test(description = "Sign-in page URL test", priority = 1)
    public void signInPageUrlTest() {
        getHomePage().setSignInRegisterClick();
        getDriver().getCurrentUrl().equals(EXPECTED_SIGN_IN_REGISTER_PAGE_URL);
    }

    @Test(description = "Forgotten your password link redirect test", priority = 2)
    public void clickOnForgottenYourPasswordLink() {
        getHomePage().setSignInRegisterClick();
        getSignInPage().forgottenYourPassword();
        getResetPasswordPage().implicitWait(10);
        Assert.assertTrue(getResetPasswordPage().resetPasswordText.isDisplayed());
    }

    @Test(description = "Sign-in with invalid credentials - URL error test", priority = 2)
    public void signInWithInvalidCredentialsUrlTest() {
        getHomePage().setSignInRegisterClick();
        getSignInPage().singInWithInvalidCredentials();
        getSignInPage().implicitWait(5);
        getSignInPage().signInButtonClick();
        getSignInPage().fluentWait(By.xpath("//span[contains(text(),'Invalid username or password.')]"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
        System.out.println(getDriver().getCurrentUrl());
    }

    @Test(description = "Sign-in with invalid credentials - Error Message test", priority = 2)
    public void signInWithInvalidCredentialsErrorMessageTest() {
        getHomePage().setSignInRegisterClick();
        getSignInPage().singInWithInvalidCredentials();
        getHomePage().implicitWait(5);
        getSignInPage().signInButtonClick();
        getHomePage().implicitWait(10);
        Assert.assertTrue(getSignInPage().invalidUsernameOrPasswordErrorMessage.isDisplayed());
    }

    @Test(description = "Sign-in with empty fields test", priority = 1)
    public void signInWithEmptyFieldsTest() {
        getHomePage().setSignInRegisterClick();
        getHomePage().implicitWait(5);
        getSignInPage().signInButtonClick();
        //Assert.assertTrue(getSignInPage().pleaseEnterYourEmailAddressErrorMessage.isDisplayed());
        //Assert.assertTrue(getSignInPage().pleaseEnterYourPasswordErrorMessage.isDisplayed());
    }

    @Test(description = " Sign-in with empty login field", priority = 3)
    public void signInWithEmptyLoginFieldTest() {
        getHomePage().setSignInRegisterClick();
        getHomePage().implicitWait(5);
        getSignInPage().signInWithEmptyLoginField();
        getSignInPage().signInButtonClick();
        Assert.assertTrue(getSignInPage().pleaseEnterYourEmailAddressErrorMessage.isDisplayed());
    }

    @Test(description = "Sign-in with empty password field", priority = 4)
    public void signInWithEmptyPassWordFieldTest() {
        getHomePage().setSignInRegisterClick();
        getHomePage().implicitWait(5);
        getSignInPage().signInWithEmptyPassWordField();
        getSignInPage().signInButtonClick();
        Assert.assertTrue(getSignInPage().pleaseEnterYourPasswordErrorMessage.isDisplayed());
    }
}