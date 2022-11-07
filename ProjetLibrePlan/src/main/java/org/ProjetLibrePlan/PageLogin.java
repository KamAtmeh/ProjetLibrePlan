package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends AbstractPage {

    public PageLogin (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //
    @FindBy(name = "j_username")
    WebElement username_field;

    @FindBy(name = "j_password")
    WebElement password_field;

    @FindBy(xpath = "//input[@value=\"Se connecter\"]")
    WebElement submitButton;

    // ********** Méthodes *********** //

    public PagePlanification seConnecter(String username, String password) {
        // clear username field and input username
        LOGGER.info("Vider le champ username et ajouter le username");
        username_field.clear();
        username_field.sendKeys(username);

        // clear password field and input password
        LOGGER.info("Vider le champ password et ajouter le password");
        password_field.clear();
        password_field.sendKeys(password);

        // click on submit button to login
        LOGGER.info("Click on Sign In button");
        submitButton.click();

        return PageFactory.initElements(driver, PagePlanification.class);
    }

}
