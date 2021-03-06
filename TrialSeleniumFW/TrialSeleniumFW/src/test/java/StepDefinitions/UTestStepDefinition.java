package StepDefinitions;

import Pages.UTestPage;
import Supports.CustomVerification;
import Supports.FrameworkInitiation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UTestStepDefinition {

    public WebDriver driver = FrameworkInitiation.getDriverInstance();
    public CustomVerification customVerification = new CustomVerification();

    public UTestPage uTestPage = new UTestPage(driver);


    public class DataSet {
        String firstName = "Test";
        String lastName = "User";
        String email = "testuser@test.com";
        String month = "March";
        String day = "6";
        String year = "2000";
    }

    DataSet dataSet = new DataSet();
    @Given("I navigate to UTest Sign up page")
    public void iNavigateToUTestSignUpPage() throws InterruptedException {
        driver.get("https://www.utest.com/signup/personal");
        Thread.sleep(5000);
    }

    @When("I complete to the form in Step 1")
    public void iCompleteToTheFormInStep() throws Exception {
        uTestPage.fillFirstName(dataSet.firstName);
        uTestPage.fillLastName(dataSet.lastName);
        uTestPage.fillEmailName(dataSet.email);
        uTestPage.selectBirthDay("month", dataSet.month);
        uTestPage.selectBirthDay("day", dataSet.day);
        uTestPage.selectBirthDay("year", dataSet.year);
        uTestPage.clickNextLocationButton();
    }

    @Then("I should able to submit form successfully")
    public void iShouldAbleToSubmitFormSuccessfully() throws Exception {
        String currentURL = driver.getCurrentUrl();
        customVerification.assertTrue(currentURL.contains("address"), "It brought to Step 2 successfully");

        String stepTitle = uTestPage.getStepTitle();
        System.out.println(stepTitle);
        customVerification.assertTrue(stepTitle.contains("Step 2"), "Step title is correct as expected");
    }

    @When("I enter invalid email")
    public void iEnterInvalidEmail() throws Exception {
        uTestPage.fillEmailName("test@123");
    }

    @Then("the error message displays with text {string}")
    public void theErrorMessageDisplaysWithText(String expectedErrorMessage) throws Exception {
        String errorMessage = uTestPage.getErrorMessageLbl();
        customVerification.assertTrue(errorMessage.equals(expectedErrorMessage), "Error message is correct as expected");
    }
}
