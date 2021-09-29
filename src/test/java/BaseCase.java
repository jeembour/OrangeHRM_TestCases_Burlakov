import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseCase {
    WebDriver driver;
    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testName() {
        openPage();
        logIN();
        verifyLogIn();
//        goToEmployeePage();
//        addNewEmployee();
//        logOut();
    }

    private void verifyLogIn() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
        boolean displayed = element.isDisplayed();
        Assert.assertEquals(displayed,true);
    }

    private void logIN() {
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

    }

    public void openPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
