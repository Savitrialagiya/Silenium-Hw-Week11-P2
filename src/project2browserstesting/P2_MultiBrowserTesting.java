package project2browserstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class P2_MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.get(baseUrl);

        //Maximise window
        driver.manage().window().maximize();

        //Give implicit time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get the title of the page
        System.out.println("the Page title is :" + driver.getTitle());

        //Get current URL
        System.out.println("The Current URL is :" + driver.getCurrentUrl());

        //Get Page Source
        System.out.println("The Page source is " + driver.getPageSource());

        //Find Username field and enter username
        WebElement enterUser = driver.findElement(By.name("username"));
        enterUser.sendKeys("admin@gmail.com");
        //Find Password Field and enter password
        WebElement enterPass = driver.findElement(By.name("password"));
        enterPass.sendKeys("admin123");

        //Close the browser
        // driver.quit();


    }
}
