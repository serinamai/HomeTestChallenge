package Pages;

import Supports.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UTestPage extends SeleniumWrapper {
    public UTestPage(WebDriver Driver) {
        super(Driver);
    }

    By firstNameTxt = By.id("firstName");
    By lastNameTxt = By.id("lastName");
    By emailTxt = By.id("email");
    By monthDrp = By.cssSelector("div#birthDate select#birthMonth");
    By dayDrp = By.cssSelector("div#birthDate select#birthDay");
    By yearDrp = By.cssSelector("div#birthDate select#birthYear");
    By nextLocationBtn = By.xpath("//form[contains(@name,'userForm')]//a[contains(@class, 'btn-blue')]/span");
    By stepTitle = By.cssSelector("h1.step-title");
    By errorMessageLbl = By.id("emailError");

    public void fillFirstName(String firstName) throws Exception {
        type(firstNameTxt, firstName);
    }

    public void fillLastName(String lastName) throws Exception {
        type(lastNameTxt, lastName);
    }

    public void fillEmailName(String email) throws Exception {
        type(emailTxt, email);
    }

    public void selectBirthDay(String birth, String value) throws Exception {
        By locator = null;
        switch (birth.toLowerCase()){
            case "month":
                locator = monthDrp;
                break;
            case "day":
                locator = dayDrp;
                break;
            case "year":
                locator = yearDrp;
                break;
            default:
                throw new Exception("Given birth is not matched as expected");

        }
        Select select = new Select(rwDriver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public void clickNextLocationButton() throws Exception {
        click(nextLocationBtn);
    }

    public String getStepTitle() throws Exception {
        return getText(stepTitle);
    }

    public String getErrorMessageLbl() throws Exception {
        return getText(errorMessageLbl);
    }


}
