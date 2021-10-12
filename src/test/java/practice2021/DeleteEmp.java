package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;

public class DeleteEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "fuсktest"})
    public void deleteEmployee() {
        FindEmp.findEmployee();
        //TODO Verify emp was not deleted earlier;
        ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]/../../child::td/input")).click();    // path to checkbox
        ApplicationManager.driver.findElement(By.id("btnDelete")).click();
        ApplicationManager.driver.findElement(By.id("dialogDeleteBtn")).click();
        try {
            actionSuccessful();
            System.out.println("Employee id="+ ApplicationManager.empId + " " + ApplicationManager.empFirstName + " " + ApplicationManager.empLastName + " is successfully deleted.");
        } catch (Exception e) {
            System.out.println("Cannot delete employee id="+ ApplicationManager.empId + " " + ApplicationManager.empFirstName + " " + ApplicationManager.empLastName);
            throw (e);
        }
    }
}

