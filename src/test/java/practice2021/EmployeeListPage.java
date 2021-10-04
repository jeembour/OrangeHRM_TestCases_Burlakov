package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmployeeListPage extends TestBase {

    @Test
    public void testMain() {
        String xPathOfPageUnderTest = "//form[@id=\"search_form\" and @name=\"frmEmployeeSearch\"]";
        String xPathOfMainPage = "//*[@id=\"logInPanelHeading\"]";
        String pageUnderTest = "Employee list page";
        openPage(MAIN_PAGE, MAIN_PAGE_TEXT, xPathOfMainPage);
        logIn(loginId, loginPWD);
        openPage(EMPLOYEE_LIST_PAGE, pageUnderTest, xPathOfPageUnderTest);
      //  verifyCurrentURL(xPathOfPageUnderTest, pageUnderTest);
        addNewEmployee(empFirstName, empLastName);
        verifyEmployeeExists(empFirstName, empLastName);
        deleteEmployee(empFirstName, empLastName);
        verifyEmployeeExists(empFirstName, empLastName);


//        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeGender();
//        editEmployeeDoB();
//        editEmployeePhoto();
//
//        logOut();
    }

    private void verifyEmployeeExists(String testFirstName, String testLastName) {
        findEmployee(testFirstName, testLastName);
        try {
            String elementPath = "//td[text()=\"No Records Found\"]";
            driver.findElement(By.xpath(elementPath));
            System.out.println(testFirstName + " " + testLastName + " is not found in the Employee list.");
        } catch (Exception e) {
            System.out.println(testFirstName + " " + testLastName + " is found in the Employee list.");
        }
    }

    private void deleteEmployee(String testFirstName, String testLastName) {
        findEmployee(testFirstName, testLastName);
        try {
            driver.findElement(By.xpath("//a[text()=\"" + testFirstName + "\"]/../../child::td/input")).click();    // path to checkbox
            driver.findElement(By.id("btnDelete")).click();
            driver.findElement(By.id("dialogDeleteBtn")).click();
            System.out.println(testFirstName + " " + testLastName + " successfully deleted from the employee list.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to delete " + testFirstName + " " + testLastName + " from the employee list.");
            throw (e);
        }
    }

    private void findEmployee(String testFirstName, String testLastName) {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            String elementPathById = "empsearch_employee_name_empName";       //path to employee name input field
            String str = testFirstName + " " + testLastName;
            sendKeysToField(str, elementPathById);
            driver.findElement(By.id("searchBtn")).click();
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to locate elements on the Employee page");
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

    private void addNewEmployee(String testFirstName, String testLastName) {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            driver.findElement(By.id("btnAdd")).click();
            sendKeysToField(testFirstName, "firstName");
            sendKeysToField(testLastName, "lastName");
            driver.findElement(By.id("btnSave")).click();
            System.out.println("Employee " + testFirstName + " " + testLastName + " added to the Employee list.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to add a new employee to the Employee list.");
            throw (e);
        }
    }

    private void goToEmployeePage() {
        try {
            driver.get(EMPLOYEE_LIST_PAGE);
            driver.findElement(By.id("searchBtn"));
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "The Employee list page is not found.");
            throw (e);
        }
    }
}
