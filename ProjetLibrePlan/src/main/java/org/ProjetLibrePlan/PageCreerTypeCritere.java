package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerTypeCritere extends PageHeader {
    public PageCreerTypeCritere (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Xpath tableau

    @FindBy(xpath="//div[@class=\"clickable-rows z-grid\"]")
    private WebElement tableau;

    @FindBy(xpath="//div[@class=\"z-column-cnt\"][contains(text(), \"Nom\")]")
    private WebElement titreColonneNom;

    @FindBy(xpath="//div[@class=\"z-column-cnt\"][contains(text(), \"Code\")]")
    private WebElement titreColonneCode;

    @FindBy(xpath="//div[@class=\"z-column-cnt\"][contains(text(), \"Type\")]")
    private WebElement titreColonneType;

    @FindBy(xpath="//div[@class=\"z-column-cnt\"][contains(text(), \"Activé\")]")
    private WebElement titreColonneActive;

    @FindBy(xpath="//div[@class=\"z-column-cnt\"][contains(text(), \"Opérations\")]")
    private WebElement titreColonneOperations;

    //bouton créer

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Créer\")]")
    private WebElement boutonCreerCritere;

    //Formulaire créer
    @FindBy(xpath="//div[@class=\"z-tabpanel-cnt\"]")
    private WebElement formulaireCreationCritere;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Enregistrer\")]")
    private WebElement boutonEnregistrerCritere;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Sauver et Continuer\")]")
    private WebElement boutonSCCritere;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    private WebElement boutonAnnulerCritere;

    //champs de formulaire
    @FindBy(xpath="//div[@class=\"z-row-cnt z-overflow-hidden\"]/input[@class=\"z-textbox\"]")
    private WebElement champNom;

    @FindBy(xpath="//i[@class=\"z-combobox\"]")
    private WebElement champType; //voir plus tard pour les différents éléments
//A CHANGER
    @FindBy(xpath="//span[@title=\"Autoriser de multiples valeurs de ce type de critère dans la même période de temps\"]/../../following-sibling::td//input\"]")
    private WebElement caseValeurs;

    @FindBy(xpath="//span[contains(text(), \"Hiérarchie\")]/../../following-sibling::td//input\"]")
    private WebElement caseHierarchie;

    @FindBy(xpath="//span[contains(text(), \"Activé\")]/../../following-sibling::td//input\"]")
    private WebElement caseActive;

    @FindBy(xpath="//textarea")
    private WebElement description;

    //modif critère
    @FindBy(xpath="//span[@title=\" Critère - Test bouton [Sauver et continuer]\"]/../../following-sibling::td//img[@src=\"/libreplan/common/img/ico_editar1.png\"]")
    private WebElement boutonModif;

    //titres page
    @FindBy(xpath="//td[@class=\"z-caption-l\"]")
    private WebElement titre;

    //corbeille
    @FindBy(xpath="//span[@title=\" Critère - Test bouton [Sauver et continuer]\"]/../../following-sibling::td//img[@src=\"/libreplan/common/img/ico_borrar1.png\"]")
    private WebElement boutonSuppr;

    @FindBy(xpath="//div[@class=\"z-window-modal z-window-modal-shadow\"]")
    private WebElement confirmerSuppr;

    @FindBy(xpath="//div[@class=\"z-window-modal z-window-modal-shadow\"]//td[contains(text(), \"OK\")]")
    private WebElement okSuppr;

    @FindBy(xpath="//div[@class=\"z-window-modal z-window-modal-shadow\"]//td[contains(text(), \"Annuler\")]")
    private WebElement annulSuppr;

    @FindBy(xpath="//div[@class=\"message_INFO\"]")
    private WebElement confirmationSuppr;

}
