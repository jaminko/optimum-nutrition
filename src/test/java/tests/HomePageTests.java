package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    public static final String CONTACT_US_PAGE_EXPECTED_QUERY = "contact";
    public static final String EXPECTED_ENERGY_PAGE_URL = "https://www.optimumnutrition.com/en-gb/energy";
    public static final String SEARCH_KEYWORD_1 = "Creatine";
    public static final String EXPECTED_QUERY_1 = "text=Creatine";
    public static final String EXPECTED_QUERY_2 = "login";

    @Test(description = "Click on the main logo icon from the any other page should navigate user to the home page", priority = 1)
    public void mainLogoTest() {
        getHomePage().contactUsFooterLinkClick();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(CONTACT_US_PAGE_EXPECTED_QUERY));
        getHomePage().mainLogoClick();
        Assert.assertEquals(getDriver().getCurrentUrl(), OPTINUM_NUTRITION_HOME_PAGE_URL);
    }

    @Test(description = "Test search function for keyword", priority = 1)
    public void searchFunctionTest() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_1);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
    }

    @Test(description = "Header shop by product drop-down test", priority = 1)
    public void shopByProductDropDownTest() {
        getHomePage().shopByProductHeaderLinkHover();
        System.out.println(getDriver().getCurrentUrl());
        Assert.assertTrue(getHomePage().energySubPageBreadcrumbs.isDisplayed());
        Assert.assertEquals(getDriver().getCurrentUrl(),EXPECTED_ENERGY_PAGE_URL);
    }

    @Test(description = "Navigate to sign in / register page", priority = 3)
    public void redirectToSignInRegisterPageTest() {
        getHomePage().setSignInRegisterClick();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_2));
    }

    @Test(description = "Check basket pop-up window", priority = 3)
    public void clickOnTheBasketIconHeaderTest() {
        getHomePage().basketClick();
        getHomePage().implicitWait(5);
        Assert.assertTrue(getHomePage().emptyBasketTextMessage.isDisplayed());
    }
}
