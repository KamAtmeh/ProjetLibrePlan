package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class
PageLogin extends AbstractPage {

    public PageLogin (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //
    @FindBy(name = "j_username")
    WebElement fieldUsername;

    @FindBy(name = "j_password")
    WebElement fieldPassword;

    @FindBy(xpath = "//input[@value=\"Se connecter\"]")
    WebElement submitButton;

    // ********** Méthodes *********** //

    public PagePlanification seConnecter(WebDriverWait wait, String username, String password) throws Throwable {
        // clear username field and input username
        LOGGER.info("Vider le champ username et ajouter le username");
        tools.setValue(wait, fieldUsername, username);

        // clear password field and input password
        LOGGER.info("Vider le champ password et ajouter le password");
        tools.setValue(wait, fieldPassword, password);

        // click on submit button to login
        LOGGER.info("Click on Sign In button");
        tools.clickElement(wait, submitButton);

        return PageFactory.initElements(driver, PagePlanification.class);
    }

}
