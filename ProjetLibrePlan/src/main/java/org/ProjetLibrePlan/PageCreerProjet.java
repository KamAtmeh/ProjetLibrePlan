package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCreerProjet extends PageHeader {

    public PageCreerProjet(WebDriver driver) {

        super(driver);
    }


//<editor-fold desc="WebElements">
    @FindBy(xpath = "//span[contains(text(), \"Nom\")]/ancestor::tr//input[@type=\"text\"]")
    WebElement nameField;
    @FindBy(xpath = "//span[contains(text(), \"Modèle\")]/ancestor::tr//input[@type=\"text\"]")
    WebElement modelField;
    @FindBy(xpath = "//td[text()='Accepter']")
    WebElement acceptButton;


//</editor-fold>



//<editor-fold desc="Méthodes">

    public PageProjets RedirectionSuiteCreationProjet (WebDriverWait wait, String projectName) throws Throwable {
        // clear name field and input projectName
        LOGGER.info("Vider le champ nom et saisir le nom du projet");
        tools.setValue(wait, nameField, projectName);
        //model field must be empty
        modelField.clear();



        // click on submit button to login
        LOGGER.info("Click on Sign In button");
        tools.clickElement(wait, acceptButton);

        return PageFactory.initElements(driver, PageProjets.class);
    }


//</editor-fold>


}
