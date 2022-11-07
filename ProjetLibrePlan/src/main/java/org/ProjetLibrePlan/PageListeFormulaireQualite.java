package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class PageListeFormulaireQualite extends PageHeader {

    public PageListeFormulaireQualite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//td[contains (text(), 'Créer')]")
    public WebElement creerUnFormulaireQualité;

    @FindBy(xpath = "//input[@class='z-textbox']")
    public WebElement champRechercheFormulaire;

    @FindBy(xpath = "//td[contains (text(), 'Filtre')]")
    public WebElement boutonRechercheFormulaire;

    @FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']/parent::*")
    public WebElement boutonModifierFormulaire;

    @FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*")
    public WebElement boutonSupprimerFormulaire;


    public PageCreerFormulaireQualite clickBoutonCreerFormulaireQualite() {
        creerUnFormulaireQualité.click();
        return PageFactory.initElements(driver, PageCreerFormulaireQualite.class);
    }


    public void faireUneRechercheFormulaire(String formulairename) {
        //inserer nom du formulaire qu'on recherche
        champRechercheFormulaire.click();
        champRechercheFormulaire.sendKeys(formulairename);
        assertEquals(formulairename, champRechercheFormulaire.getText());
        //lancer la recherhce
        boutonRechercheFormulaire.click();
    }

    public PageCreerFormulaireQualite clickBoutonModifierFormulaire() {
        boutonModifierFormulaire.click();
        return PageFactory.initElements(driver, PageCreerFormulaireQualite.class);
    }

    public void supprimerFormulairesurPageListeFormulaire() {
        boutonSupprimerFormulaire.click();
    }

    public PageCreerFormulaireQualite clickerSurNomFormulaire(String $nomformulaire) {
        WebElement nomclickable = driver.findElement(By.xpath("//span[contains (text(), '$nomformulaire')]"));
        nomclickable.click();

        return PageFactory.initElements(driver, PageCreerFormulaireQualite.class);
    }
}







