package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PageCreeProfil extends PageHeader {
    public PageCreeProfil(WebDriver driver) {
        super(driver);
    }

    public class PageConfigurationListeProfil extends AbstractPage {

        public PageConfigurationListeProfil(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }
    }

    //***Variables*****

    @FindBy(xpath = "(//input[@class])[2]")
    public WebElement ChampNomProfil;

    @FindBy(xpath = ("(//i)[2]"))
    public WebElement menuDeroulantRole;

    @FindBy(xpath = "//td[contains (text(),'Participants')]")
    public WebElement choixParticipantsDansMenuDeroulant;

    @FindBy(xpath = "//td[contains (text(),'Dépenses')]")
    public WebElement choixDépensesDansMenuDeroulant;

    @FindBy(xpath = "//td[contains (text(),'Enregistrer')]")
    public WebElement boutonEnregistrerProfil;

    @FindBy(xpath = "//td[contains (text(),'Sauver et continuer')]")
    public WebElement boutonSauvegarderChangementProfil;

    @FindBy(xpath = "//td[contains (text(),'Annuler')]")
    public WebElement boutonAnnulerProfil;

    //toujours supprimer Role1 avant Role2 sinon xpath non utilisable pour Role2 !
    @FindBy(xpath = "(//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*) [7]")
    public WebElement boutonSupprimerRole1;

    @FindBy(xpath = "(//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*) [7]")
    public WebElement boutonSupprimerRole2;

    @FindBy(xpath = "//*[@id='d9EPt4-box'']/tbody/tr[2]/td[2]/img")
    public WebElement infoBulleSupprimer;

    @FindBy(xpath="//span[contains(text(),'Nom')]")
    public WebElement texteNomPageCreeeProfil;

    @FindBy (xpath="//span[contains(text(),'Association avec les rôles')]")
    public WebElement texteAssociationRole;

    @FindBy (xpath="//td[contains(text(),'Ajouter un rôle')]")
    public WebElement boutonAjouterRole;

    @FindBy(xpath="//span[contains(text(),'Participants')]")
    public WebElement champNomRole;

    @FindBy(xpath="//span[contains(text(),'Canevas')]")
    public WebElement champNomRoleCanevas;

    @FindBy(xpath = "//td[contains (text(),'Canevas')]")
    public WebElement choixCanevasDansMenuDeroulant;

    //*****Methode***
    public PageProfil enregistrerProfilPageCreeProfil(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonEnregistrerProfil);
        return PageFactory.initElements(driver, PageProfil.class);
    }

    public PageProfil supprimerProfilPageCreeProfil (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonAnnulerProfil);
        return PageFactory.initElements(driver, PageProfil.class);
    }

    public void sauvegarderProfilPageCreeProfil () {
        boutonSauvegarderChangementProfil.click();
    }

    public void creerProfil (String name, WebDriverWait wait) throws Throwable {
        //nommer nouveau profil qu'on veut créer
        tools.clickElement(wait, ChampNomProfil);
        tools.setValue(wait, ChampNomProfil, name);
        // dérouler menu déroulant des roles disponibles
        tools.clickElement(wait, menuDeroulantRole);
        // attribuer les roles Dépenses et Participant à ce nouveau profil
        tools.clickElement(wait, choixParticipantsDansMenuDeroulant);
        tools.clickElement(wait, boutonAjouterRole);
        tools.clickElement(wait, menuDeroulantRole);
        tools.clickElement(wait, choixDépensesDansMenuDeroulant);
        tools.clickElement(wait, boutonAjouterRole);
    }

    public void ajouterAutrerole(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,menuDeroulantRole);
        tools.clickElement(wait,choixCanevasDansMenuDeroulant);
        tools.clickElement(wait,boutonAjouterRole);
    }

    public void passerSurInfoBulle() {
        //set methode action
        Actions action = new Actions(driver);
        //déplacer la souris sur l'icone supprimer role
        action.moveToElement(boutonSupprimerRole1);
        // vérification que le texte 'supprimer' est bien présent
        infoBulleSupprimer.getText();
        assertEquals ("Supprimer", infoBulleSupprimer.getText());
    }

    public void suppressionRoles() throws InterruptedException {
        boutonSupprimerRole1.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(boutonSupprimerRole2));
        Thread.sleep(10000);
        boutonSupprimerRole2.click();
        Thread.sleep(10000);
        boutonSupprimerRole2.click();
    }

    public void selectionnerMemeRole (WebDriverWait wait) throws Throwable {
        // dérouler menu déroulant des roles disponibles
        tools.clickElement(wait,menuDeroulantRole);
        // attribuer le role Participants au profil
        tools.clickElement(wait, choixParticipantsDansMenuDeroulant);
        tools.clickElement(wait, boutonAjouterRole);
        //set methode action
        Actions action = new Actions(driver);
        //déplacer la souris sur l'icone supprimer role
        action.moveToElement(boutonSupprimerRole1);
        //essayer à nouveau de sélectionner le role Participants pour le profil
        tools.clickElement(wait, menuDeroulantRole);
        tools.clickElement(wait,choixParticipantsDansMenuDeroulant);
    }


    public void modifiernom(String newname, WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,ChampNomProfil);
        ChampNomProfil.clear();
        LOGGER.info("Entrer le nouveau nom que vous voulez donner au profil");
        tools.setValue(wait,ChampNomProfil,newname);

    }






}





