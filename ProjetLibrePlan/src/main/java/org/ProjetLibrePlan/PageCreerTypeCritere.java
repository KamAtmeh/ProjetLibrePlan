package org.ProjetLibrePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerTypeCritere {
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
    private WebElement champType;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    private WebElement caseValeurs;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    private WebElement caseHierarchie;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    private WebElement caseActive;

    @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    private WebElement description;

    //div[@class="z-row-cnt z-overflow-hidden"]/input[@class="z-textbox"]




}
