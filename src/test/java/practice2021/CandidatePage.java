package practice2021;

import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;

public class CandidatePage extends TestBase {
    @Test
    public void candidatePageTests() {
        openCandidatePage();
        app.getInputData();
//        addCandidate();
//        editCandidate();
//        deleteCandidate();
    }

    private void openCandidatePage() {
        ApplicationManager.driver.get(ApplicationManager.CANDIDATE_PAGE);
    }

}
