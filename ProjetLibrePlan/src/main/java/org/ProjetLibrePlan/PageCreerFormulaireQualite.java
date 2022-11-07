package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class PageCreerFormulaireQualite extends PageHeader {

    public PageCreerFormulaireQualite(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//div/input[@class='focus-element z-textbox z-textbox-text-invalid']")
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

    @FindBy (xpath="//div/input[@class='z-textbox']")
    public WebElement champNomNouvelElementDuFormulaireQualite;

    @FindBy (xpath="/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div[3]/table/tbody[2]/tr/td[2]/div")
    public WebElement numeroPositionDuNouvelElementDuFormualireQualite;

    @FindBy (xpath="//input[@class='z-decimalbox']")
    public WebElement champPourcentageNouvelElementDuFormulaireQualite;

    @FindBy (xpath="//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*")
    public WebElement boutonsupprimeNouvelElementduFormulaire;

    @FindBy (xpath="//td[contains (text(), 'Enregistrer')]")
    public WebElement boutonEnregistrerpageCreerFormulaireQualite;

    @FindBy (xpath="//td[contains (text(), 'Sauver et continuer')]")
    public WebElement boutonSauverpageCreerFormulaireQualite;

    @FindBy (xpath="//td[contains (text(), 'Annuler')]")
    public WebElement boutonAnnulerpageCreerFormulaireQualite;


    public void remplirChampsPrincipauxFormulaireQualitePourcentage (String nomformulaire, String descriptionformulaire){
        //remplir le champ nom du formulaire
        champNomFormulaireQualite.click();
        champNomFormulaireQualite.sendKeys(nomformulaire);
        assertEquals (nomformulaire, champNomFormulaireQualite.getText());
        //remplir le champ description
        champDescriptionFormulaireQualite.click();
        champDescriptionFormulaireQualite.sendKeys(descriptionformulaire);
        assertEquals(descriptionformulaire, champDescriptionFormulaireQualite.getText() );
       //choisir d'afficher le formulaire en pourcentage
        menuDeroulantTypeFormulaireQualite.click();
        menuDeroulantPourcentage.click();
        assertEquals("par pourcentage", menuDeroulantTypeFormulaireQualite.getText());


    }

    public void remplirChampsPrincipauxFormulaireQualiteElement (String formualirename, String descripformulaire){
        //remplir le champ nom du formulaire
        champNomFormulaireQualite.click();
        champNomFormulaireQualite.sendKeys(formualirename);
        assertEquals(formualirename, champNomFormulaireQualite.getText());
        // remplir le champd description
        champDescriptionFormulaireQualite.click();
        champDescriptionFormulaireQualite.sendKeys(descripformulaire);
        assertEquals(descripformulaire, champDescriptionFormulaireQualite.getText() );
        // choisir d'afficher le formulaire par element
        menuDeroulantTypeFormulaireQualite.click();
        menuDeroulantElement.click();
        assertEquals("par element", menuDeroulantTypeFormulaireQualite.getText());
    }

    public void remplirNouvelElementDuFormulairePourcentage (String nvlElementName, String pourcentage){
        // remplir le champ nom de la partie Nouvel Element
        boutonNouvelElementDuFormulaireQualite.click();
        champNomNouvelElementDuFormulaireQualite.click();
        champNomNouvelElementDuFormulaireQualite.sendKeys(nvlElementName);
        assertEquals(nvlElementName, champNomNouvelElementDuFormulaireQualite.getText());
        //remplir le champ pourcentage de la partie
        champPourcentageNouvelElementDuFormulaireQualite.click();
        champPourcentageNouvelElementDuFormulaireQualite.sendKeys(pourcentage);
        assertEquals(pourcentage, champPourcentageNouvelElementDuFormulaireQualite.getText());
        //sauvegarde des modifications faites
        boutonSauverpageCreerFormulaireQualite.click();

    }

    public void remplirNouvelElementDuFormulaireElement (String name){
       //ajouter un nouvel element au formulaire
        boutonNouvelElementDuFormulaireQualite.click();
        //nommer le nouvel element creer
        champNomNouvelElementDuFormulaireQualite.click();
        champNomNouvelElementDuFormulaireQualite.sendKeys(name);
        //sauvegarder les changements
        boutonSauverpageCreerFormulaireQualite.click();
    }

    public PageListeFormulaireQualite enregistrerPageCreeFormulaireQualite (){
       boutonEnregistrerpageCreerFormulaireQualite.click();
       return PageFactory.initElements(driver, PageListeFormulaireQualite.class);
    }

    public PageListeFormulaireQualite annulerPageCreeFormulaireQualite (){
        boutonAnnulerpageCreerFormulaireQualite.click();
        return  PageFactory.initElements(driver, PageListeFormulaireQualite.class);
    }

    public void supprimerNouvelElementFormulaire (){
        boutonsupprimeNouvelElementduFormulaire.click();
    }



}
