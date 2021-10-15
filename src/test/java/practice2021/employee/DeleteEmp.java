package practice2021.employee;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.EmpListPageManager;

public class DeleteEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "fuсktest"})
    public void deleteEmployee() {
        FindEmp.findEmployee();
        //TODO Verify emp was not deleted earlier;
        app.driver.findElement(By.xpath("//a[text()=\"" + app.empId + "\"]/../../child::td/input")).click();    // path to checkbox
        app.driver.findElement(By.id("btnDelete")).click();
        app.driver.findElement(By.id("dialogDeleteBtn")).click();
        try {
            actionSuccessful();
            System.out.println("Employee id="+ app.empId + " " + app.empFirstName + " " + app.empLastName + " is successfully deleted.");
        } catch (Exception e) {
            System.out.println("Cannot delete employee id="+ app.empId + " " + app.empFirstName + " " + app.empLastName);
            throw (e);
        }
    }
}

