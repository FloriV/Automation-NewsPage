package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPageSupport {
    public String articleTitle;

    public void launchNewsPage(WebDriver driver) {
        driver.get("https://www.theguardian.com/tone/news");
        // Verify correct page was loaded
        WebElement title = driver.findElement(By.className("index-page-header__title"));
        Assert.assertEquals("Launched page title is not correct!", "News", title.getText());
    }

    public List<WebElement> getNewsList(WebDriver driver) {
        WebElement newsSection = driver.findElement(By.xpath("//ul[@class='u-unstyled l-row  l-row--cols-3 fc-slice fc-slice--t-t-t']"));
        return newsSection.findElements(By.xpath("./*"));
    }

    public void setNewsTitle(WebElement news) {
        articleTitle = news.findElement(By.xpath("//li[1]/div/div/a")).getAttribute("innerHTML");
        // For better results remove 'live' and other special characters from title
        articleTitle = articleTitle.replace("live", "").replaceAll("[^A-Za-z0-9\\s]", " ");
        System.out.println("Article title after trim:" + articleTitle);
    }
}
