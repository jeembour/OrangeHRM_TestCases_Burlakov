import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseCase {
    public static final String TEST_FIRST_NAME = "testFistName";
    public static final String TEST_LAST_NAME = "testLastName";
    public static final String TEST_SOURCE_PAGE = "https://opensource-demo.orangehrmlive.com/";
    public static final String LOGIN_ID = "Admin";
    public static final String LOGIN_PASSWORD = "admin123";
    public static final String TEST_SOURCE_PAGE_EMPLOYEE = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList";
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testName() {
        openPage();
        logIn();
        verifyLogIn();
        goToEmployeePage();
        addNewEmployee();
        verifyEmployeeExists();
        deleteEmployee();
        verifyEmployeeExists();
//        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeJobTitle();
//        editEmployeeEmpStatus();
//        editEmployeeJoinedDate();

//        logOut();
    }

    private void verifyEmployeeExists() {
        findEmployee();
        try {
            driver.findElement(By.xpath("//td[text()=\"No Records Found\"]"));
            System.out.println("Employee " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " NOT found!");
        } catch (Exception e) {
            System.out.println("Employee " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " found!");
        }
    }

    private void deleteEmployee() {
        findEmployee();
        driver.findElement(By.xpath("//a[text()=\"" + TEST_FIRST_NAME + "\"]/../../child::td/input")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
        System.out.println("Employee " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " successfully deleted.");
    }

    private void findEmployee() {
        goToEmployeePage();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"ac_input inputFormatHint\"]")));
        } catch (Exception e) {
        }
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).sendKeys(TEST_FIRST_NAME + " " + TEST_LAST_NAME);
//        driver.findElement(By.xpath("//strong/parent::li[@class=\"ac_even\"]")).click();
        driver.findElement(By.id("searchBtn")).click();
    }

    private void addNewEmployee() {
        goToEmployeePage();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(TEST_FIRST_NAME);
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(TEST_LAST_NAME);
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Employee " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " added.");
    }

    private void goToEmployeePage() {
        driver.get(TEST_SOURCE_PAGE_EMPLOYEE);
    }

    private void verifyLogIn() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
    }

    private void logIn() {
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys(LOGIN_ID);
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys(LOGIN_PASSWORD);
        driver.findElement(By.id("btnLogin")).click();

    }

    public void openPage() {
        driver.get(TEST_SOURCE_PAGE);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
