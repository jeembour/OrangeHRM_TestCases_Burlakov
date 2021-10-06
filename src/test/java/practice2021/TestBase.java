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
    public static final String MAIN_PAGE_TEXT = "Main page";
    public static final String GREEN_TEXT_COLOR = (char) 27 + "[92m";
    public static final String EMPLOYEE_LIST_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList";
    public static final String CANDIDATE_PAGE = "https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates";
    public static final String X_PATH_OF_MAIN_PAGE = "//*[@id=\"logInPanelHeading\"]";
    public static final String PATH_TO_PHOTO = "C:\\Users\\Jeemb\\IdeaProjects\\OrangeHRM_TestCases_Burlakov\\src\\data\\kotofey.jpg";
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
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
        getInputData();
        driver.manage().window().maximize();
    }

    private static int getEmployeeNumber() {
        Random rand = new Random();
        int empNumber = rand.nextInt(20) + 1;
        System.out.println("Employee number " + empNumber + " selected.");
        return empNumber;
    }

    public static void sendKeysToField(String textToSend, String elementPathById) {
        driver.findElement(By.id(elementPathById)).click();
        driver.findElement(By.id(elementPathById)).clear();
        driver.findElement(By.id(elementPathById)).sendKeys(textToSend);
    }

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
            List<String> inpData = Arrays.asList(br.readLine().split("\\s*,\\s*"));
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
    public void verification(String xPathOfElementToBeVerified) {
        WebElement element = driver.findElement(By.xpath(xPathOfElementToBeVerified));
        boolean isDisplayed = element.isDisplayed();
        Assert.assertEquals(isDisplayed, true);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
