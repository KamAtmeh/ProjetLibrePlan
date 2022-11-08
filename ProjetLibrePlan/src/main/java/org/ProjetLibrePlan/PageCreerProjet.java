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
    @FindBy(xpath = "//input[@type='checkbox' and  @checked='checked']")
    WebElement codeCheckbox;
    @FindBy(xpath = "//td[text()='Accepter']")
    WebElement acceptButton;
    @FindBy(xpath = "//span[contains(text(), \"Code\")]/ancestor::tr//input[@type=\"text\"")
    WebElement codeField;

//</editor-fold>



//<editor-fold desc="Méthode RedirectionSuiteCreationProjet">

    public PageProjets RedirectionSuiteCreationProjet (WebDriverWait wait, String projectName, String projectCode) throws Throwable {

        // clear name field and input projectName

        tools.setValue(wait, nameField, projectName);
        //model field must be empty******
        modelField.clear();

        //Décocher la case 'Generer code' si elle est cochée
        tools.setCheckbox(wait, codeCheckbox,false);

       /* if (codeCheckbox.isSelected() == true){
            codeCheckbox.click();
        }*/

        // clear code field and input CodeProject
        LOGGER.info("Vider le champ code et saisir le code du projet");
        tools.setValue(wait, codeField, projectCode);




        // click on submit button to login
        LOGGER.info("Click on Sign In button");
        tools.clickElement(wait, acceptButton);

        return PageFactory.initElements(driver, PageProjets.class);
    }

    //PageHeader.getNomChamps (wait);

    /*public ArrayList<String> getNomChamps (WebDriverWait wait){
        String xpath = "(//tbody[@class=\"z-rows\"])[2]/child::tr[not(contains(@style, \"none\"))]/td[1]//span";
        List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

        ArrayList<String> row = new ArrayList<String>();
        for (WebElement i : element){
            row.add(i.getText());
        }
        return row;
    }*/

//</editor-fold>


}
