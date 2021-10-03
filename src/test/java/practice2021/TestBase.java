package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestBase {
    public static final String MAIN_PAGE = "https://opensource-demo.orangehrmlive.com/";
    public static final String GREEN_TEXT_COLOR = (char) 27 + "[92m";
    public static final String EMPLOYEE_LIST_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList";
    public static String loginId = "Admin";
    public static String loginPWD = "admin123";
    public static String testFirstName;
    public static String testLastName;
    public static String gender;
    public static String nationality;
    public static String maritalStatus;
    public static String doB;
    public static String bloodType;
    public static String dataFile = "D:\\Data.txt";
    public static List<String> inpData;
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
        getEmployeeNumber();
        getInputData();
    }

    private static int getEmployeeNumber() {
        Random rand = new Random();
        int empNumber = rand.nextInt((20) + 1);
        return empNumber;
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

    public void getInputData() {
        int n = getEmployeeNumber();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            for (int i = 0; i < n; i++)
                br.readLine();
            line = br.readLine();
            inpData = Arrays.asList(line.split("\\s*,\\s*"));
            testFirstName = inpData.get(0);
            testLastName = inpData.get(1);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
