package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    @FindBy (xpath="//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement ChampNomProfil ;

    @FindBy (xpath="/input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement menuDeroulantRole;

    @FindBy (xpath="//td[contains (text(),'Participants')]")
    public WebElement choixParticipantsDansMenuDeroulant;

    @FindBy (xpath="//td[contains (text(),'Dépenses')]")
    public WebElement choixDépensesDansMenuDeroulant;

    @FindBy (xpath="//td[contains (text(),'Enregistrer')]")
    public WebElement boutonEnregistrerProfil;

    @FindBy (xpath="//td[contains (text(),'Sauver et continuer')]")
    public WebElement boutonSauvegarderChangementProfil;

    @FindBy (xpath="//td[contains (text(),'Annuler')]")
    public WebElement boutonAnnulerProfil;




}
