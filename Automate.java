import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Automate {

public static WebDriver driver;

private static final String Search = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input";

private static final String Name = "///body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]]";

private static final String cart = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]";
private static final String rate = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/section[6]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]";

private static final String ViewCart = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[9]/div[3]/div[1]/div[2]/div[2]/div[2]/button[1]";
System.setProperty("webdriver.chrome.driver","C:\\Users\\91901\\Downloads\\data\\eclipse\\eclipse\\chromedriver_win32.exe");
}
public static void main(String[] args) throws InterruptedException {
 WebDriver driver=new ChromeDriver();
 driver.navigate().to("http://www.flipkart.com");
 driver.manage().window().maximize();
 log();
 driver.findElement(By.xpath("//div[@class='_3OO5Xc']")).sendKeys("Iphone");
 driver.manage().window().maximize();
 WebElement sr = getElement(By.xpath(Search));
 sr.click();
 WebDriverWait wait = new WebDriverWait(driver, 20);
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Name))).click();
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cart))).click();
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rate))).click();
 getElement(By.xpath(ViewCart)).click();
 Thread.sleep(1000);
 end();

}



public static WebElement getElement(final By locator) {

FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)

.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);



WebElement element = wait.until(new Function<WebDriver, WebElement>() {



public WebElement apply(WebDriver arg0) {

return arg0.findElement(locator);

}



});



return element;

}



public static void log() {

getElement(By.xpath("//a[contains(text(),'Login')]")).click();

getElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys("abc@gmail.com");

getElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")).sendKeys("abc123");

getElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")).click();



try {

Thread.sleep(1000);

} catch (InterruptedException e) {

e.printStackTrace();

}

}

public static void end() {

driver.close();

driver.quit();

}

}