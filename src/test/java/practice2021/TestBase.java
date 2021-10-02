package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static final String MAIN_PAGE = "https://opensource-demo.orangehrmlive.com/";
    public static final String GREEN_TEXT_COLOR = (char) 27 + "[92m";
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
    }
    public void sendKeysToField(String textToSend, String elementPathById) {
        driver.findElement(By.id(elementPathById)).click();
        driver.findElement(By.id(elementPathById)).clear();
        driver.findElement(By.id(elementPathById)).sendKeys(textToSend);
    }

    protected void logIn(String loginId, String loginPassword) {
        try {
            String usernameLocator = "txtUsername";
            String pwdLocator = "txtPassword";
            sendKeysToField(loginId, usernameLocator);
            sendKeysToField(loginPassword, pwdLocator);
            driver.findElement(By.id("btnLogin")).click();
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Logging in failed - cannot locate element on login page.");
            throw (e);
        }
    }

    protected void verifyLogIn() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
            boolean displayed = element.isDisplayed();
            Assert.assertTrue(displayed);
            System.out.println("Logged in successfully.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to log in.");
            throw (e);
        }
    }

    public void openPage() {
        try {
            driver.get(MAIN_PAGE);
            System.out.println("The main page seems to open.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "The main page is not found.");
            throw (e);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
