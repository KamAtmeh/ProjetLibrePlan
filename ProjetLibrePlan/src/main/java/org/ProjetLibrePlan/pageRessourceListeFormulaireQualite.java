package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageRessourceListeFormulaireQualite extends AbstractPage  {

    public pageRessourceListeFormulaireQualite (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath="//td[contains (text(), 'Créer')]")
    public WebElement creerUnFormulaireQualité;

    @FindBy (xpath="//input[@class='z-textbox']")
    public WebElement champRechercheFormulaire;

    @FindBy (xpath="//td[contains (text(), 'Filtre')]")
    public WebElement boutonRechercheFormulaire;

 public pageRessourceCreeFormulaireQualite clickBoutonCreerFormulaireQualite (WebDriver driver){
     creerUnFormulaireQualité.click();
     return PageFactory.initElements(driver, pageRessourceCreeFormulaireQualite.class);
 }


public void faireUneRechercheFormulaire (String formulairename){
     champRechercheFormulaire.click ();
     champRechercheFormulaire.sendKeys(formulairename);
     assertEquals (formulairename, champRechercheFormulaire.getText());
     boutonRechercheFormulaire.click();
}




}
