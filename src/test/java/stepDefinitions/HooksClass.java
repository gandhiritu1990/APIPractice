package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class HooksClass {
   public static WebDriver driver;

    @Before
    public void launchBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        byte[] screenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot,"image/png","");
        driver.quit();
    }
}
