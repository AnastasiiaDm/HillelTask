import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSiteRandomNumbers {

    WebDriver browser;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("https://www.random.org/integers/");
        Thread.sleep(1500);
    }

    @AfterTest
    public void closeBrowser() {
        browser.quit();
    }

    @Test
    public void getNumbers() throws InterruptedException {
        WebElement firstValue = browser.findElement(By.cssSelector("input[name='num']"));
        firstValue.clear();
        firstValue.sendKeys("1");
        Thread.sleep(1500);


        WebElement getNumbersButton = browser.findElement(By.cssSelector("input[value='Get Numbers']"));
        getNumbersButton.click();
        Thread.sleep(1500);

        WebElement numbers = browser.findElement(By.cssSelector("pre[class='data']"));
        String number = numbers.getText();
        int n = Integer.parseInt(number.trim());

        System.out.println(n);

        Assert.assertTrue(n>=1 & n<=100);

    }
}
