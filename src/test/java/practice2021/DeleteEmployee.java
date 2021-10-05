package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteEmployee extends EmployeeListPage {
    @Test
    public void deleteEmployee() {
        FindEmployee.findEmployee();
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
}
