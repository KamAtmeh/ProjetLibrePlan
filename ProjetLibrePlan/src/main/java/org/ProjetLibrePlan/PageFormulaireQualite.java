package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PageFormulaireQualite extends PageHeader {

    public PageFormulaireQualite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//td[contains (text(), 'Créer')]")
    public WebElement creerUnFormulaireQualité;

    @FindBy(xpath = "//input[@class='z-textbox']")
    public WebElement champRechercheFormulaire;

    @FindBy(xpath = "//td[contains (text(), 'Filtre')]")
    public WebElement boutonRechercheFormulaire;

    @FindBy(xpath ="(//span[contains(text(),'Test1')]) [2]")
    public WebElement champNomClickable;

    @FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']/parent::*")
    public WebElement boutonModifierFormulaire;

    @FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*")
    public WebElement boutonSupprimerFormulaire;

    @FindBy(xpath = "//td[contains(text(),'OK')]")
    public WebElement boutonOkSupprimerFormulaire;


    public PageCreerFormulaireQualite clickBoutonCreerFormulaireQualite(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,creerUnFormulaireQualité);
        return PageFactory.initElements(driver, PageCreerFormulaireQualite.class);
    }


    public void faireUneRechercheFormulaire(String formulairename, WebDriverWait wait) throws Throwable {
        //inserer nom du formulaire qu'on recherche
        tools.clickElement(wait,champRechercheFormulaire);
        LOGGER.info("Rerchercher formulaire par nom");
        tools.setValue(wait,champRechercheFormulaire,formulairename);
        assertEquals(formulairename, champRechercheFormulaire.getText());
        //lancer la recherhce
        tools.clickElement(wait,boutonRechercheFormulaire);
    }

    public PageCreerFormulaireQualite clickBoutonModifierFormulaire(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonModifierFormulaire);
        return PageFactory.initElements(driver, PageCreerFormulaireQualite.class);
    }

    public void supprimerFormulairesurPageListeFormulaire(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonSupprimerFormulaire);
        tools.clickElement(wait, boutonOkSupprimerFormulaire);
    }

    public PageModifierFormulaireQualite clickerSurNomFormulaire(WebDriverWait wait,String $nomformulaire) throws Throwable {
        WebElement nomclickable = driver.findElement(By.xpath("(//span[contains (text(), 'Test1')])[2]"));
        tools.clickElement(wait,nomclickable);
        return PageFactory.initElements(driver, PageModifierFormulaireQualite.class);
    }


}







