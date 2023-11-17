package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='results-grid__refinements-heading results-grid__refinements-heading--desktop']")
    public WebElement refineByText;
    @FindBy(xpath = "//select[@name='sort']")
    public WebElement sortByDropDown;
    @FindBy(xpath = "//span[@class='facet-value__name' and contains(text(),'Bundles')]")
    public WebElement checkBoxBundles;
    @FindBy(xpath = "//span[@class='result-facet__item-name']")
    public WebElement resultFacetIemBundles;
    @FindBy(xpath = "//option[@value='price_desc']")
    public WebElement priceDescending;
    @FindBy(xpath = "//option[@value='price_asc']")
    public WebElement priceAscending;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void sortingPriceByDescending() {
        Actions builder = new Actions(driver);
        builder.moveToElement(sortByDropDown).doubleClick(sortByDropDown).
                sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
    }

    public void sortingPriceByAscending() {
        Actions builder = new Actions(driver);
        builder.moveToElement(sortByDropDown).doubleClick(sortByDropDown).
                sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
        sortByDropDown.click();
        sortByDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void sortingProductsUsingBundlesFilterFacet() {
        Actions builder = new Actions(driver);
        builder.moveToElement(checkBoxBundles).doubleClick(checkBoxBundles).build().perform();
    }
}
