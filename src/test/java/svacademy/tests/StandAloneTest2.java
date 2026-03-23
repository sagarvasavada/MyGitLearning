package svacademy.tests;

import java.time.Duration;
//import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StandAloneTest2 {

    public static void main(String[] args) throws InterruptedException {
        
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.findElement(By.id("userEmail")).sendKeys("sagarvasavada99@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Sagar@7994");
        driver.findElement(By.id("login")).click();
        // List <WebElement> buttons = driver.findElements(By.cssSelector("button.btn.w-10.rounded"));
        // buttons.get(1).click();
        driver.findElement(By.xpath("//b[text()='ZARA COAT 3']/following::button[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        driver.findElement(By.cssSelector(".totalRow button")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("737");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("sagar vasavada");
        Actions a =  new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        
       driver.findElement(By.xpath("(//a[normalize-space()='Place Order'])[1]")).click();
       System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());

       System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());

       System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());

       System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());
       
       



        
        
    }

}
