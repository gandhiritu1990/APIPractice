package stepDefinitions;


import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MyStepdefs2 {

    WebDriver driver = HooksClass.driver;
    @And("Check second scenario")
    public void checkSecondScenario() {


        driver.get("https://www.amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipad", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs("Amazon.in : ipad"));
        driver.findElement(By.xpath("//span[@data-component-type='s-product-image']")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        Iterator<String> iterator = windows.iterator();
        String childWindow = null;
        while (iterator.hasNext()){
            childWindow = iterator.next();
        }
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//span[text()='With Exchange']")).click();




    }
}
