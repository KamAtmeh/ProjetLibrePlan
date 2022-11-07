package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class PageRessourceListeFormulaireQualite extends AbstractPage  {

    public PageRessourceListeFormulaireQualite (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath="//td[contains (text(), 'Créer')]")
    public WebElement creerUnFormulaireQualité;

    @FindBy (xpath="//input[@class='z-textbox']")
    public WebElement champRechercheFormulaire;

    @FindBy (xpath="//td[contains (text(), 'Filtre')]")
    public WebElement boutonRechercheFormulaire;

    @FindBy (xpath= "//img[@src='/libreplan/common/img/ico_editar1.png']/parent::*")
    public WebElement boutonModifierFormulaire;

    @FindBy (xpath="//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*")
    public WebElement boutonSupprimerFormulaire;


 public PageRessourceCreerFormulaireQualite clickBoutonCreerFormulaireQualite (WebDriver driver){
     creerUnFormulaireQualité.click();
     return PageFactory.initElements(driver, PageRessourceCreerFormulaireQualite.class);
 }


public void faireUneRechercheFormulaire (String formulairename){
     champRechercheFormulaire.click ();
     champRechercheFormulaire.sendKeys(formulairename);
     assertEquals (formulairename, champRechercheFormulaire.getText());
     boutonRechercheFormulaire.click();
     assertEquals ("Créer Formulaire qualité", driver.findElement(By.xpath("//td[contains (text(), 'Créer Formulaire qualité') ]")));
}

public PageRessourceCreerFormulaireQualite clickBoutonModifierFormulaire (WebDriver driver){
     boutonModifierFormulaire.click();
     return PageFactory.initElements(driver, PageRessourceCreerFormulaireQualite.class);
    }

    public void supprimerFormulairesurPageListeFormulaire (){
     boutonSupprimerFormulaire.click();
    }






}
