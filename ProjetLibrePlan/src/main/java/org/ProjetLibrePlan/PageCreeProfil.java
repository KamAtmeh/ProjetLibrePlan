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

    @FindBy(xpath = "//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement ChampNomProfil;

    @FindBy(xpath = "/input[@class='focus-element z-textbox z-textbox-text-invalid']")
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

    @FindBy(xpath = "//table[@class='z-button-over']")
    public WebElement infoBulleSupprimer;

    //*****Methode***
    public PageListeProfil enregistrerProfilPageCreeProfil(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonEnregistrerProfil);
        return PageFactory.initElements(driver, PageListeProfil.class);
    }

    public PageListeProfil supprimerProfilPageCreeProfil (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutonAnnulerProfil);
        return PageFactory.initElements(driver, PageListeProfil.class);
    }

    public void sauvegarderProfilPageCreeProfil () {
        boutonSauvegarderChangementProfil.click();
    }

    public void creerProfil (String name, WebDriverWait wait) throws Throwable {
        //nommer nouveau profil qu'on veut créer
        tools.clickElement(wait, ChampNomProfil);
        LOGGER.info("Veuillez donner un nom à votre profil");
        tools.setValue(wait, ChampNomProfil, name);
        // dérouler menu déroulant des roles disponibles
        tools.clickElement(wait, menuDeroulantRole);
        // attribuer les roles Dépenses et Participant à ce nouveau profil
        tools.clickElement(wait, choixParticipantsDansMenuDeroulant);
        tools.clickElement(wait, choixDépensesDansMenuDeroulant);
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

        public void suppressionRoles() {
            boutonSupprimerRole1.click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[contains(text(), 'Modifier tous les projets')]"))));
            boutonSupprimerRole2.click();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[contains(text(), 'Participants')]"))));
        }

        public void selectionnerMemeRole (WebDriverWait wait) throws Throwable {
                // dérouler menu déroulant des roles disponibles
                tools.clickElement(wait,menuDeroulantRole);
                // attribuer le role Participants au profil
                tools.clickElement(wait, choixParticipantsDansMenuDeroulant);
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





