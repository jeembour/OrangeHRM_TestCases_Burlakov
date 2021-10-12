package practice2021.edit_employee;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;
import practice2021.employee.FindEmp;

public class Photo extends EmpListPageManager {
    @Test
    public void editEmployeePhoto() {
        FindEmp.findEmployee();
        ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]")).click();
        ApplicationManager.driver.findElement(By.xpath("//img[@alt=\"Employee Photo\"]")).click();
        ApplicationManager.driver.findElement(By.xpath("//input[@id=\"photofile\"]")).sendKeys(ApplicationManager.PATH_TO_PHOTO);
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        // TODO verify photo was excepted and updated successfully;
//        try {
//            actionSuccessful();
//            System.out.println("Employee's photo is successfully updated.");
//        } catch (Exception e) {
//            System.out.println("Cannot update employee's photo.");
//            throw (e);
//        }
    }
}
