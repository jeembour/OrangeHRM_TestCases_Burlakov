package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmployeeListPage extends TestBase {
    public static void goToEmployeePage() {
        try {
            driver.get(EMPLOYEE_LIST_PAGE);
            driver.findElement(By.id("searchBtn"));
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "The Employee list page is not found.");
            throw (e);
        }

//        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeGender();
//        editEmployeeDoB();
//        editEmployeePhoto();
//
//        logOut();
    }

//    public void verifyEmployeeExists() {
//        findEmployee();
//        try {
//            String elementPath = "//td[text()=\"No Records Found\"]";
//            driver.findElement(By.xpath(elementPath));
//            System.out.println(empFirstName + " " + empLastName + " is not found in the Employee list.");
//        } catch (Exception e) {
//            System.out.println(empFirstName + " " + empLastName + " is found in the Employee list.");
//        }
//    }



    public static void waitForEmployeePageJSExecution() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"ac_input inputFormatHint\"]")));
        } catch (Exception e) {
        }
    }
}