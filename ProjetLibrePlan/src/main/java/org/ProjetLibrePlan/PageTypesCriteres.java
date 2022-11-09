package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class PageTypesCriteres extends PageHeader {
    @FindBy(xpath = "//div[@class=\"clickable-rows z-grid\"]")
    public WebElement tableau;

    @FindBy(xpath = "//div[@class=\"z-column-cnt\"][contains(text(), \"Nom\")]")
    public WebElement titreColonneNom;

    @FindBy(xpath = "//div[@class=\"z-column-cnt\"][contains(text(), \"Code\")]")
    public WebElement titreColonneCode;

    @FindBy(xpath = "//div[@class=\"z-column-cnt\"][contains(text(), \"Type\")]")
    public WebElement titreColonneType;

    @FindBy(xpath = "//div[@class=\"z-column-cnt\"][contains(text(), \"Activé\")]")
    public WebElement titreColonneActive;

    @FindBy(xpath = "//div[@class=\"z-column-cnt\"][contains(text(), \"Opérations\")]")
    public WebElement titreColonneOperations;

    //bouton créer

    @FindBy(xpath = "//td[@class=\"z-button-cm\"][contains(text(), \"Créer\")]")
    public WebElement boutonCreerCritere;

    //Formulaire créer
    @FindBy(xpath = "//div[@class=\"z-tabpanel-cnt\"]")
    public WebElement formulaireCreationCritere;

    @FindBy(xpath = "//td[@class=\"z-button-cm\"][contains(text(), \"Enregistrer\")]")
    public WebElement boutonEnregistrerCritere;

    @FindBy(xpath = "//td[@class=\"z-button-cm\"][contains(text(), \"Sauver et continuer\")]")
    public WebElement boutonSCCritere;

    @FindBy(xpath = "//td[@class=\"z-button-cm\"][contains(text(), \"Annuler\")]")
    public WebElement boutonAnnulerCritere;

    //champs de formulaire
    @FindBy(xpath = "//div[@class=\"z-row-cnt z-overflow-hidden\"]/input[@class=\"z-textbox\"]")
    public WebElement champNom;

    @FindBy(xpath = "//i[@class=\"z-combobox\"]")
    public WebElement champType; //voir plus tard pour les différents éléments

    @FindBy(xpath = "//td[contains(text(), \"PARTICIPANT\")]")
    public WebElement typeParticipant;

    @FindBy(xpath = "//span[@title=\"Autoriser de multiples valeurs de ce type de critère dans la même période de temps\"]/../../following-sibling::td//input")
    public WebElement caseValeurs;

    @FindBy(xpath = "//span[contains(text(), \"Hiérarchie\")]/../../following-sibling::td//input")
    public WebElement caseHierarchie;

    @FindBy(xpath = "//span[contains(text(), \"Activé\")]/../../following-sibling::td//input")
    public WebElement caseActive;

    @FindBy(xpath = "//textarea")
    public WebElement description;

    //modif critère
    @FindBy(xpath = "//span[@title=\"Critère - Test bouton [Sauver et continuer]\"]/../../following-sibling::td//img[@src=\"/libreplan/common/img/ico_editar1.png\"]")
    public WebElement boutonModif;

    //titres page
    @FindBy(xpath = "//div[@class=\"z-window-embedded-header\"][1]")
    public WebElement titrePage;

    @FindBy(xpath = "//span[@title=\"Critère - Test bouton [Enregistrer]\"]")
    public WebElement exempleCritereEnregistrement;

    //corbeille
    @FindBy(xpath = "//span[@title=\"Critère - Test bouton [Sauver et continuer]\"]")
    public WebElement exempleCritereSC;

    @FindBy(xpath = "//span[@title=\"Critère - Test bouton [Sauver et continuer] 2\"]")
    public WebElement exempleCritereModif;

    @FindBy(xpath = "//span[@title=\"Critère - Test bouton [Sauver et continuer] 2\"]/../../following-sibling::td//img[@src=\"/libreplan/common/img/ico_borrar1.png\"]")
    public WebElement boutonSuppr;

    @FindBy(xpath = "//div[@class=\"z-window-modal z-window-modal-shadow\"]")
    public WebElement confirmerSuppr;

    @FindBy(xpath = "//div[@class=\"z-window-modal z-window-modal-shadow\"]//td[contains(text(), \"OK\")]")
    public WebElement okSuppr;

    @FindBy(xpath = "//div[@class=\"z-window-modal z-window-modal-shadow\"]//td[contains(text(), \"Annuler\")]")
    public WebElement annulSuppr;

    @FindBy(xpath = "//div[@class=\"message_INFO\"]")
    public WebElement fenetreConfirm;

    @FindBy(xpath = "//div[@class=\"z-center z-center-noborder\"]")
    public WebElement blancPage;

    public PageTypesCriteres(WebDriver driver) {
        super(driver);
    }

    //Vérification de la présence du tableau (résultat attendu PT2)
    public boolean displayTableau(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(tableau));
        return tableau.isDisplayed();
    }

    public boolean displayColNom(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(titreColonneNom));
        return titreColonneNom.isDisplayed();
    }

    public boolean displayColCode(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(titreColonneCode));
        return titreColonneCode.isDisplayed();
    }

    public boolean displayColType(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(titreColonneType));
        return titreColonneType.isDisplayed();
    }

    public boolean displayColActive(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(titreColonneActive));
        return titreColonneActive.isDisplayed();
    }

    public boolean displayColOperations(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(titreColonneOperations));
        return titreColonneOperations.isDisplayed();
    }

    //vérif bouton créer et clic
    public boolean displayBoutCreer(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonCreerCritere));
        return boutonCreerCritere.isDisplayed();
    }

    public void clicCreer() {
        boutonCreerCritere.click();
    }

    //vérif présence formulaire et boutons
    public boolean verifFormulaire(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        return formulaireCreationCritere.isDisplayed();
    }

    public boolean verifBoutonEnregistrer(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonEnregistrerCritere));
        return boutonEnregistrerCritere.isDisplayed();
    }

    public boolean verifBoutonSC(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonSCCritere));
        return boutonSCCritere.isDisplayed();
    }

    public boolean verifBoutonAnnuler(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonAnnulerCritere));
        return boutonAnnulerCritere.isDisplayed();
    }

    //remplissage du formulaire de création de critère
    public void remplissageFormulaireAnnul(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        champNom.sendKeys("Critère - Test bouton [Annuler]");
        typeParticipant.isDisplayed();
        caseValeurs.isSelected();
        caseHierarchie.isSelected();
        caseActive.isSelected();
        description.sendKeys("Critère - Test bouton [Annuler]");
    }

    //clic Annuler puis verif Annuler pas présent
    public void clicAnnulerCréation(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonAnnulerCritere));
        boutonAnnulerCritere.click();
        wait.until(ExpectedConditions.visibilityOf(titrePage));
        assertEquals("Types de critères Liste", titrePage.getText());
        assertFalse("ok", boutonAnnulerCritere.isDisplayed());
    }

    //remplissage du formulaire de création de critère
    public void remplissageFormulaireEnreg(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        champNom.sendKeys("Critère - Test bouton [Enregistrer]");
        typeParticipant.isDisplayed();
        caseValeurs.isSelected();
        caseHierarchie.isSelected();
        caseActive.isSelected();
        description.sendKeys("Critère - Test bouton [Enregistrer]");
    }

    //clic Enregistrer puis verif Enregistrer présent
    public void clicEnregistrerCréation(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonEnregistrerCritere));
        boutonEnregistrerCritere.click();
        wait.until(ExpectedConditions.visibilityOf(titrePage));
        assertEquals("Types de critères Liste", titrePage.getText());
        assertTrue("ok", exempleCritereEnregistrement.isDisplayed());
    }

    //remplissage du formulaire de création de critère
    public void remplissageFormulaireSC(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        champNom.sendKeys("Critère - Test bouton [Sauver et continuer]");
        typeParticipant.isDisplayed();
        caseValeurs.isSelected();
        caseHierarchie.isSelected();
        caseActive.isSelected();
        description.sendKeys("Critère - Test bouton [Sauver et continuer]");
    }

    //clic sauver et continuer puis verif, annulation et revérif (PT 7 et 8)
    public void clicSCCreation(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonSCCritere));
        boutonSCCritere.click();
        //assertEquals("Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", titrePage.getText());
        //récup xpath fenêtre d'enregistrement
        //assertEquals("Type de critère \"Critère - Test bouton [Sauver et continuer]\"enregistré", fenetreConfirm.getText());
        assertTrue("ok", boutonSCCritere.isDisplayed());
        boutonAnnulerCritere.click();
        //wait.until(ExpectedConditions.visibilityOf(titrePage));
        //assertEquals("Types de critères Liste", titrePage.getText());
        //assertTrue("ok", exempleCritereSC.isDisplayed());
    }

    //accès modification PT9
    public void accesModif(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonModif));
        boutonModif.click();
        wait.until(ExpectedConditions.visibilityOf(titrePage));
        //assertEquals("Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", titrePage.getText());
    }

    //modif (pt10)
    public void modifCritereAnnuler(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        champNom.clear();
        champNom.sendKeys("Critère - Test bouton [Sauver et continuer] 2");
        boutonAnnulerCritere.click();
        //assertEquals("Critère - Test bouton [Sauver et continuer]", champNom.getText());
    }

    //accès modification PT11
    public void accesModifNom(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(exempleCritereEnregistrement));
        exempleCritereEnregistrement.click();
        wait.until(ExpectedConditions.visibilityOf(titrePage));
        //assertEquals("Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", titrePage.getText());
    }

    //modif PT12 et 13, 14
    public void modifCritereSC(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(formulaireCreationCritere));
        champNom.clear();
        champNom.sendKeys("Critère - Test bouton [Sauver et continuer] 2");
        blancPage.click();
        //assertEquals("Critère - Test bouton [Sauver et continuer] 2", titrePage.getText());
        boutonSCCritere.click();
        wait.until(ExpectedConditions.visibilityOf(fenetreConfirm));
        //assertEquals("Type de critère \"Critère - Test bouton [Sauver et continuer] 2 \"enregistré", fenetreConfirm.getText());
        //assertEquals("Critère - Test bouton [Sauver et continuer] 2", titrePage.getText());
        boutonAnnulerCritere.click();
        wait.until(ExpectedConditions.visibilityOf(titrePage));
        assertEquals("Types de critères Liste", titrePage.getText());
        //assertEquals("Critère - Test bouton [Sauver et continuer] 2", exempleCritereModif.getText());
    }

    public void annulationSuppressionCritere(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonSuppr));
        boutonSuppr.click();
        confirmerSuppr.isDisplayed();
        okSuppr.isDisplayed();
        annulSuppr.isDisplayed();
        annulSuppr.click();
        wait.until(ExpectedConditions.visibilityOf(exempleCritereModif));
        assertFalse(confirmerSuppr.isDisplayed());
        exempleCritereModif.isDisplayed();
    }

    public void confirmationSuppressionCritere(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(boutonSuppr));
        boutonSuppr.click();
        confirmerSuppr.isDisplayed();
        okSuppr.isDisplayed();
        annulSuppr.isDisplayed();
        okSuppr.click();
        wait.until(ExpectedConditions.visibilityOf(confirmerSuppr));
        fenetreConfirm.isDisplayed();
        assertFalse(exempleCritereModif.isDisplayed());
    }
}

//retravailler titrePage
