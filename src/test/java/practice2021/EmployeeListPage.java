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
        addNewEmployee(empId, empFirstName, empLastName);
        verifyEmployeeExists(empId);
        deleteEmployee(empId);
        verifyEmployeeExists(empId);


//        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeGender();
//        editEmployeeDoB();
//        editEmployeePhoto();
//
//        logOut();
    }

    private void verifyEmployeeExists(String empId) {
        findEmployee(empId);
        try {
            String elementPath = "//td[text()=\"No Records Found\"]";
            driver.findElement(By.xpath(elementPath));
            System.out.println(empFirstName + " " + empLastName + " is not found in the Employee list.");
        } catch (Exception e) {
            System.out.println(empFirstName + " " + empLastName + " is found in the Employee list.");
        }
    }

    private void deleteEmployee(String empId) {
        findEmployee(empId);
        try {
            driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]/../../child::td/input")).click();    // path to checkbox
            driver.findElement(By.id("btnDelete")).click();
            driver.findElement(By.id("dialogDeleteBtn")).click();
            System.out.println(empFirstName + " " + empLastName + " successfully deleted from the employee list.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to delete " + empFirstName + " " + empLastName + " from the employee list.");
            throw (e);
        }
    }

    private void findEmployee(String empId) {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            String elementPathById = "empsearch_id";       //path to employee name input field
            sendKeysToField(empId, elementPathById);
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

    private void addNewEmployee(String empId, String firstName, String lastname) {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            driver.findElement(By.id("btnAdd")).click();
            sendKeysToField(firstName, "firstName");
            sendKeysToField(lastname, "lastName");
            sendKeysToField(empId, "employeeId");
            driver.findElement(By.id("btnSave")).click();
            System.out.println("Employee " + firstName + " " + lastname + " added to the Employee list.");
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
