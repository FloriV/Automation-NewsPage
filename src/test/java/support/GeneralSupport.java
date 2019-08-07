package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralSupport {
    public WebDriver setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
