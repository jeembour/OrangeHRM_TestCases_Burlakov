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

import java.util.concurrent.TimeUnit;

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
        logIn();
        verifyLogIn();
        goToEmployeePage();
        addNewEmployee();
        findEmployee();
//        deleteEmployee();
//        verifyEmployeeDeleted();
//        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeJobTitle();
//        editEmployeeEmpStatus();
//        editEmployeeJoinedDate();

//        logOut();
    }

    private void findEmployee() {
        goToEmployeePage();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-results\"]")));
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).sendKeys("testFirstName testLastName");
      //  driver.findElement(By.xpath("//strong/parent::li[@class=\"ac_even\"]")).click();
        driver.findElement(By.id("searchBtn")).click();
        System.out.println("OK!");

    }

    private void addNewEmployee() {
        goToEmployeePage();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("testFirstName");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("testLastName");
        driver.findElement(By.id("btnSave")).click();

    }

    private void goToEmployeePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
    }

    private void verifyLogIn() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
    }

    private void logIn() {
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
