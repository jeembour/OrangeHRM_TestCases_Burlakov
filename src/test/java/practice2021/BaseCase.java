package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public static final String GREENTEXTCOLOR = (char) 27 + "[92m";
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/browsers/chromedriver (2).exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testMain() {
        openPage();
        logIn(LOGIN_ID, LOGIN_PASSWORD);
        verifyLogIn();
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

    private void logIn(String loginId, String loginPassword) {
        try {
            driver.findElement(By.id("txtUsername")).click();
            driver.findElement(By.id("txtUsername")).clear();
            driver.findElement(By.id("txtUsername")).sendKeys(loginId);
            driver.findElement(By.id("txtPassword")).click();
            driver.findElement(By.id("txtPassword")).clear();
            driver.findElement(By.id("txtPassword")).sendKeys(loginPassword);
            driver.findElement(By.id("btnLogin")).click();
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "Logging in failed - cannot locate element on login page.");
            throw (e);
        }
    }

    private void verifyEmployeeExists() {
        findEmployee();
        try {
            driver.findElement(By.xpath("//td[text()=\"No Records Found\"]"));
            System.out.println(TEST_FIRST_NAME + " " + TEST_LAST_NAME + " is not found in the Employee list.");
        } catch (Exception e) {
            System.out.println(TEST_FIRST_NAME + " " + TEST_LAST_NAME + " is found in the Employee list.");
        }
    }

    private void deleteEmployee() {
        findEmployee();
        try {
            driver.findElement(By.xpath("//a[text()=\"" + TEST_FIRST_NAME + "\"]/../../child::td/input")).click();
            driver.findElement(By.id("btnDelete")).click();
            driver.findElement(By.id("dialogDeleteBtn")).click();
            System.out.println(TEST_FIRST_NAME + " " + TEST_LAST_NAME + " successfully deleted from the employee list.");
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "Failed to delete " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " from the employee list.");
            throw (e);
        }
    }

    private void findEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).sendKeys(TEST_FIRST_NAME + " " + TEST_LAST_NAME);
            driver.findElement(By.id("searchBtn")).click();
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "Failed to locate elements on the Employee page");
            throw (e);
        }
    }

    private void waitForEmployeePageJSExecution() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"ac_input inputFormatHint\"]")));
        } catch (Exception e) {
        }
    }

    private void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("firstName")).click();
            driver.findElement(By.id("firstName")).clear();
            driver.findElement(By.id("firstName")).sendKeys(TEST_FIRST_NAME);
            driver.findElement(By.id("lastName")).click();
            driver.findElement(By.id("lastName")).clear();
            driver.findElement(By.id("lastName")).sendKeys(TEST_LAST_NAME);
            driver.findElement(By.id("btnSave")).click();
            System.out.println("Employee " + TEST_FIRST_NAME + " " + TEST_LAST_NAME + " added to the Employee list.");
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "Failed to add a new employee to the Employee list.");
            throw (e);
        }
    }

    private void goToEmployeePage() {
        try {
            driver.get(TEST_SOURCE_PAGE_EMPLOYEE);
            driver.findElement(By.id("searchBtn"));
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "The Employee list page is not found.");
            throw (e);
        }
    }

    private void verifyLogIn() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
            boolean displayed = element.isDisplayed();
            Assert.assertTrue(displayed);
            System.out.println("Logged in successfully.");
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "Failed to log in.");
            throw (e);
        }
    }

    public void openPage() {
        try {
            driver.get(TEST_SOURCE_PAGE);
            System.out.println("The main page seems to open.");
        } catch (Exception e) {
            System.out.println(GREENTEXTCOLOR + "The main page is not found.");
            throw (e);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
