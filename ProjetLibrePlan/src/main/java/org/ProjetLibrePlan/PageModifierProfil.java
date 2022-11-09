package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageModifierProfil extends PageHeader {
    public PageModifierProfil(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement menuDeroulantRole;

    @FindBy(xpath = "//td[contains (text(),'Enregistrer')]")
    public WebElement boutonEnregistrerProfilPageModifierProfil;

    @FindBy(xpath = "//td[contains (text(),'Profils')]")
    public WebElement choixProfilsDansMenuDeroulant;

    @FindBy(xpath = "//td[contains (text(),'Canevas')]")
    public WebElement choixCanevasDansMenuDeroulant;

    @FindBy(xpath = "//td[contains(text(),'Ajouter un rôle')]")
    public WebElement boutonAjouterRole;


    @FindBy(xpath = "//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement ChampNomProfilPageModifierProfil;

    //***Methode****
    public void modifierNomProfil(String name2, WebDriverWait wait) throws Throwable {
        //nommer nouveau profil qu'on veut créer
        tools.clickElement(wait, ChampNomProfilPageModifierProfil);
        LOGGER.info("Veuillez donner un nom à votre profil");
        tools.setValue(wait, ChampNomProfilPageModifierProfil, name2);

    }

    public PageProfil enregistrerProfilPageModifierProfil(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonEnregistrerProfilPageModifierProfil);
        return PageFactory.initElements(driver, PageProfil.class);
    }

    public void ajouterRole(WebDriverWait wait) throws Throwable {
        // dérouler menu déroulant des roles disponibles
        tools.clickElement(wait, menuDeroulantRole);
        // attribuer les roles Dépenses et Participant à ce nouveau profil
        tools.clickElement(wait, choixCanevasDansMenuDeroulant);
        tools.clickElement(wait, boutonAjouterRole);
        tools.clickElement(wait, menuDeroulantRole);
        tools.clickElement(wait, choixProfilsDansMenuDeroulant);
        tools.clickElement(wait, boutonAjouterRole);
    }

}


