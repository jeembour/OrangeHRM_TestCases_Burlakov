package practice2021;

import org.testng.annotations.Test;

public class CandidatePage extends TestBase {
    @Test
    public void candidatePageTests() {
        openCandidatePage();
        getInputData();
//        addCandidate();
//        editCandidate();
//        deleteCandidate();
    }

    private void openCandidatePage() {
        driver.get(CANDIDATE_PAGE);
    }

}
