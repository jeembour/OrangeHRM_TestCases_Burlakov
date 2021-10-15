package practice2021;

import org.testng.annotations.Test;

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
        app.driver.get(app.CANDIDATE_PAGE);
    }

}
