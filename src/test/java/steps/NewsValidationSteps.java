package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.BrowserSupport;
import support.GeneralSupport;
import support.NewsPageSupport;

import java.util.List;

public class NewsValidationSteps {
    private GeneralSupport support = new GeneralSupport();
    private BrowserSupport browser = new BrowserSupport();
    private NewsPageSupport news = new NewsPageSupport();
    private WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = support.setup();
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    @Given("I launch News | The Guardian")
    public void iLaunchNewsTheGuardian() {
        news.launchNewsPage(driver);
    }

    @Given("I take the newest article post")
    public void iTakeTheNewestArticlePost() {
        // Get news list web element
        List<WebElement> newsList = news.getNewsList(driver);
        // Get 1st news title from the list
        WebElement latestNews = newsList.get(0);
        news.setNewsTitle(latestNews);
    }

    @When("I search (.*) for the article title")
    public void iSearchSourceForTheArticleTitle(String source) {
        // Go to search engine and search article title
        browser.launchSearchEngine(driver, source);
        browser.search(driver, news.articleTitle);
    }

    @Then("I should receive some related articles")
    public void iShouldReceiveSomeRelatedArticlesFromOtherSites() {
        browser.getResultsList(driver);
        Assert.assertFalse("List result is empty", browser.resultsList.isEmpty());
        System.out.println("results returned:" + browser.resultsList.size());
    }

    @Then("at least 2 different sources should be found")
    public void atLeastToDifferentSourcesShouldBeFound() {
        Assert.assertTrue("At least 2 other sources where not found", browser.countDiffResults() > 2);
    }
}
