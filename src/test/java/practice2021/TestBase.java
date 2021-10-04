package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public static final String MAIN_PAGE_TEXT = "Main page";
    public static final String GREEN_TEXT_COLOR = (char) 27 + "[92m";
    public static final String EMPLOYEE_LIST_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList";
    public static String loginId = "Admin";
    public static String loginPWD = "admin123";
    public static String empFirstName;
    public static String empLastName;
    public static String empGender;
    public static String empId;
    public static String empNationality;
    public static String empMaritalStatus;
    public static String empDoB;
    public static String empBloodType;
    public static String dataFile = "src/data/Data";
    public static List<String> inpData;
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
        getInputData();
        driver.manage().window().maximize();
    }

    private static int getEmployeeNumber() {
        Random rand = new Random();
        int empNumber = rand.nextInt((20) + 1);
        System.out.println("Employee number "+ empNumber + " selected.");
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
            String xPathOfPage = "//*[@id=\"welcome\"]";
            sendKeysToField(loginId, usernameLocator);
            sendKeysToField(loginPassword, pwdLocator);
            driver.findElement(By.id("btnLogin")).click();
            driver.findElement(By.xpath(xPathOfPage));
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Logging in failed - cannot locate element on login page.");
            throw (e);
        }
    }

//    protected void verifyCurrentURL(String xPathToVerifyPageOpened, String pageUnderTest) {
//        try {
//            WebElement element = driver.findElement(By.xpath(xPathToVerifyPageOpened));
//            boolean displayed = element.isDisplayed();
//            Assert.assertTrue(displayed);
//            System.out.println(pageUnderTest + " opened successfully.");
//        } catch (Exception e) {
//            System.out.println(GREEN_TEXT_COLOR + "Failed to open " + pageUnderTest);
//            throw (e);
//        }
//    }

    public void openPage(String pageToOpen, String pageName, String xPathOfPageUnderTest) {
        try {
            driver.get(pageToOpen);
            driver.findElement(By.xpath(xPathOfPageUnderTest));
            System.out.println(pageName + " opened.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + pageName + " is not found.");
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
            empId = inpData.get(0);
            empFirstName = inpData.get(1);
            empLastName = inpData.get(2);
            empGender = inpData.get(3);
            empNationality = inpData.get(4);
            empMaritalStatus = inpData.get(5);
            empDoB = inpData.get(6);
            empBloodType = inpData.get(7);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
