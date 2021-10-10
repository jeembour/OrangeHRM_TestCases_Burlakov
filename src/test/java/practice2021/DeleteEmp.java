package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "fuсktest"})
    public void deleteEmployee() {
        FindEmp.findEmployee();
        //TODO Verify emp was not deleted earlier;
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]/../../child::td/input")).click();    // path to checkbox
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
        try {
            actionSuccessful();
            System.out.println("Employee id="+empId + " " + empFirstName + " " + empLastName + " is successfully deleted.");
        } catch (Exception e) {
            System.out.println("Cannot delete employee id="+empId + " " + empFirstName + " " + empLastName);
            throw (e);
        }
    }
}

