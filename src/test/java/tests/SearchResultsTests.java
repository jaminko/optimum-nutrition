package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends BaseTest {
    public static final String SEARCH_KEYWORD_1 = "Whey protein";
    public static final String EXPECTED_QUERY_1 = "text=Whey+protein";

    @Test(description = "Search results page URL test", priority = 1)
    public void searchResultsPageUrlTest() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_1);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
    }

    @Test(description = "Filter test - using Bundles facet", priority = 2)
    public void sortingProductsUsingBundlesFilterFacet() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_1);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
        getSearchResultsPage().implicitWait(5);
        getSearchResultsPage().sortingProductsUsingBundlesFilterFacet();
        Assert.assertTrue(getSearchResultsPage().resultFacetIemBundles.isDisplayed());
    }

    @Test(description = "Sorting test - sort products by descending prise", priority = 3)
    public void sortingProductsByDescendingPrise() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_1);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
        getSearchResultsPage().implicitWait(5);
        getSearchResultsPage().sortingPriceByDescending();
        Assert.assertTrue(getSearchResultsPage().priceDescending.isSelected());
    }

    @Test(description = "Sorting test - sort products by ascending prise", priority = 3)
    public void sortingProductsByAscendingPrise() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_1);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_1));
        getSearchResultsPage().implicitWait(5);
        getSearchResultsPage().sortingPriceByAscending();
        Assert.assertTrue(getSearchResultsPage().priceAscending.isSelected());
    }
}

