package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageRessourceCreerFormulaireQualite extends AbstractPage {

    public pageRessourceCreerFormulaireQualite (WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement champNomFormulaireQualite;

    @FindBy (xpath="//textarea[@class='z-textbox']")
    public WebElement champDescriptionFormulaireQualite;

    @FindBy (xpath="//select[@selectedindex='0']")
    public WebElement menuDeroulantTypeFormulaireQualite;

    @FindBy  (xpath="//option[contains (text(), 'par pourcentage') ]")
    public WebElement menuDeroulantPourcentage;

    @FindBy (xpath="//option[contains (text(), 'par élément') ]")
    public WebElement menuDeroulantElement;

    @FindBy (xpath="//input[@type='checkbox' ]")
    public WebElement checkboxAvancementDuRapport;

    @FindBy (xpath="//td[contains (text(), 'Nouvel élément du formulaire qualité') ]")
    public WebElement boutonNouvelElementDuFormulaireQualite;

    //@FindBy (xpath="")



}
