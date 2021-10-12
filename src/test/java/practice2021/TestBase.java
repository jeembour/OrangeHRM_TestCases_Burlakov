package practice2021;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import practice2021.app_manager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeSuite (alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
