package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PageCreerFormulaireQualite extends PageHeader {

    public PageCreerFormulaireQualite(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    //variables
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

    @FindBy (xpath="(//input[@class='z-textbox']) [2]")
    public WebElement champNompourSecondNouvelElement;

    @FindBy (xpath="(//input[@class='z-decimalbox']) [1]")
    public WebElement champPourcentageSecondNouvelElement;

    //Methodes


    public void remplirChampsPrincipauxFormulaireQualitePourcentage (WebDriverWait wait,String nomformulaire, String descriptionformulaire) throws Throwable {
        //remplir le champ nom du formulaire
       tools.clickElement (wait,champNomFormulaireQualite);
       LOGGER.info("Nommez le formulaire");
       tools.setValue(wait,champNomFormulaireQualite,nomformulaire);
        assertEquals (nomformulaire, champNomFormulaireQualite.getText());
        //remplir le champ description
        tools.clickElement(wait,champDescriptionFormulaireQualite);
        LOGGER.info("Ajoutez une description");
        tools.setValue(wait,champDescriptionFormulaireQualite,descriptionformulaire);
        assertEquals(descriptionformulaire, champDescriptionFormulaireQualite.getText() );
       //choisir d'afficher le formulaire en pourcentage
        tools.clickElement(wait,menuDeroulantTypeFormulaireQualite);
        tools.clickElement(wait,menuDeroulantPourcentage);
        assertEquals("par pourcentage", menuDeroulantTypeFormulaireQualite.getText());


    }

    public void remplirChampsPrincipauxFormulaireQualiteElement (WebDriverWait wait,String formualirename, String descripformulaire) throws Throwable {
        //remplir le champ nom du formulaire
        tools.clickElement(wait,champNomFormulaireQualite);
        LOGGER.info("Nommez le formulaire");
        tools.setValue(wait,champNomFormulaireQualite,formualirename);
        assertEquals(formualirename, champNomFormulaireQualite.getText());
        // remplir le champd description
        tools.clickElement(wait,champDescriptionFormulaireQualite);
        LOGGER.info("Ajoutez une description au formulaire");
        tools.setValue(wait,champDescriptionFormulaireQualite,descripformulaire);
        assertEquals(descripformulaire, champDescriptionFormulaireQualite.getText() );
        // choisir d'afficher le formulaire par element
        tools.clickElement(wait,menuDeroulantTypeFormulaireQualite);
        tools.clickElement(wait,menuDeroulantElement);
        assertEquals("par element", menuDeroulantTypeFormulaireQualite.getText());
    }

    public void remplirNouvelElementDuFormulairePourcentage (WebDriverWait wait,String nvlElementName, String pourcentage) throws Throwable {
        // remplir le champ nom de la partie Nouvel Element
        tools.clickElement(wait, boutonNouvelElementDuFormulaireQualite);
        tools.clickElement(wait,champNomNouvelElementDuFormulaireQualite);
        LOGGER.info(("Nom du nouvel element"));
        tools.setValue(wait,champNomNouvelElementDuFormulaireQualite,nvlElementName);
        assertEquals(nvlElementName, champNomNouvelElementDuFormulaireQualite.getText());
        //remplir le champ pourcentage de la partie
        tools.clickElement(wait,champPourcentageNouvelElementDuFormulaireQualite);
        LOGGER.info(("Pourcentage en chiffre"));
        champPourcentageNouvelElementDuFormulaireQualite.sendKeys(pourcentage);
        assertEquals(pourcentage, champPourcentageNouvelElementDuFormulaireQualite.getText());
        //sauvegarde des modifications faites
        tools.clickElement(wait,boutonSauverpageCreerFormulaireQualite);

    }

    public void remplirNouvelElementDuFormulaireElement (WebDriverWait wait,String name) throws Throwable {
       //ajouter un nouvel element au formulaire
        tools.clickElement(wait,boutonNouvelElementDuFormulaireQualite);
        //nommer le nouvel element creer
        tools.clickElement(wait,champNomNouvelElementDuFormulaireQualite);
        LOGGER.info("Nommez le nouvel Element du formulaire");
        tools.setValue(wait,champNomNouvelElementDuFormulaireQualite,name);
        //sauvegarder les changements
        tools.clickElement(wait,boutonSauverpageCreerFormulaireQualite);
    }

    public PageFormulaireQualite enregistrerPageCreeFormulaireQualite (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonEnregistrerpageCreerFormulaireQualite);
       return PageFactory.initElements(driver, PageFormulaireQualite.class);
    }

    public PageFormulaireQualite annulerPageCreeFormulaireQualite (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonAnnulerpageCreerFormulaireQualite);
        return  PageFactory.initElements(driver, PageFormulaireQualite.class);
    }

    public void sauvegarder (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonSauverpageCreerFormulaireQualite);
    }

    public void supprimerNouvelElementFormulaire (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonsupprimeNouvelElementduFormulaire);
    }

    public void creerSecondNouvelElementDuFormulaire (WebDriverWait wait,String secondnom, String secondpourcentage) throws Throwable {
        //ajouter un nouvel element au formulaire
        tools.clickElement(wait,boutonNouvelElementDuFormulaireQualite);
        //remplir champ nom du second element créer
        tools.clickElement(wait,champNompourSecondNouvelElement);
        LOGGER.info("Nom deuxième élément formulaire");
        tools.setValue(wait,champNompourSecondNouvelElement,secondnom);
        //remplir champ pourcentage du second element créer
        tools.clickElement(wait,champPourcentageSecondNouvelElement);
        LOGGER.info("Pourcentage en chiffre");
        tools.setValue(wait,champPourcentageSecondNouvelElement,secondpourcentage);
        //cliquer hors du tableau
        tools.clickElement(wait,numeroPositionDuNouvelElementDuFormualireQualite);


    }



}
