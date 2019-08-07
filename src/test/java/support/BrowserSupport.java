package support;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserSupport {
    public String engine;
    public List<WebElement> resultsList = null;

    public void launchSearchEngine(WebDriver driver, String searchEngine) {
        engine = searchEngine;
        driver.get(searchEngine);
    }

    public void search(WebDriver driver, String content) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(content);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void getResultsList(WebDriver driver) {
        if (engine.contains("google")) {
            resultsList = driver.findElements(By.cssSelector(".r"));
        } else if (engine.contains("bing")) {
            resultsList = driver.findElements(By.cssSelector(".b_algo"));
        }
    }

    public int countDiffResults() {
        int count = 0;
        for (WebElement result : resultsList
        ) {
            if (!result.findElement(By.xpath(".//a")).getAttribute("href").contains("www.theguardian.com")) {
                count++;
            }
        }
        return count;
    }


}
