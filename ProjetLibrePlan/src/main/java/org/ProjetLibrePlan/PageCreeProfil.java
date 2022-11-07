package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public PageListeProfil enregistrerProfilPageCreeProfil() {
        boutonEnregistrerProfil.click();
        return PageFactory.initElements(driver, PageListeProfil.class);
    }

    public PageListeProfil supprimerProfilPageCreeProfil () {
        boutonAnnulerProfil.click();
        return PageFactory.initElements(driver, PageListeProfil.class);
    }

    public void sauvegarderProfilPageCreeProfil () {
        boutonSauvegarderChangementProfil.click();
    }

    public void creerProfil (String name){
        //nommer nouveau profil qu'on veut créer
        ChampNomProfil.click();
        ChampNomProfil.sendKeys (name);
        // dérouler menu déroulant des roles disponibles
        menuDeroulantRole.click();
       // attribuer les roles Dépenses et Participant à ce nouveau profil
        choixParticipantsDansMenuDeroulant.click();
        choixDépensesDansMenuDeroulant.click();}

        public void passerSurInfoBulle() {
           //set methode action
            Actions action = new Actions(driver);
            //déplacer la souris sur l'icone supprimer role
            action.moveToElement(boutonSupprimerRole1);
           // vérification que le texte 'supprimer' est bien présent
            infoBulleSupprimer.getText();
            assertEquals ("Supprimer", infoBulleSupprimer.getText());
        }




}





}
