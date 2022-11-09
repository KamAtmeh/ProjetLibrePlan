package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProfil extends PageHeader {

    public PageProfil(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    //***Variable***
    @FindBy (xpath="//td[@class='z-button-cl']/following-sibling::td[contains (text(), 'Créer')]")
    public WebElement boutonCreerProfil;

    //xpath qui fonctionne seulement pour trouver le bouton modification du profil qu'on vient de créer dans PageCreeProfil
    @FindBy (xpath="(//td[@class='z-button-cm']) [2]")
    public WebElement boutonmodifierProfilQuiAEteCree;

    //xpath qui fonctionne seulement pour trouver le bouton supprimer du profil qu'on vient de créer dans PageCreeProfil
    @FindBy (xpath="(//td[@class='z-button-cm']) [3]")
    public WebElement boutonSupprimerProfilQuiAEteCree;

    @FindBy(xpath = "//div[contains(text(),'Nom de profil')]")
    public WebElement nomDesProfilsDansListe;

    @FindBy(xpath ="//span[contains(text(), 'Hed')])[2]")
    public WebElement nomProfilTableau;

    @FindBy (xpath = "//div[contains(text(),'Actions')]")
    public WebElement actionsSurPageProfils;



    //***Méthodes**
    public PageCreeProfil creationDeProfil (WebDriverWait wait) throws Throwable {
        tools.clickElement (wait, boutonCreerProfil);
        return PageFactory.initElements(driver, PageCreeProfil.class);
    }

    public PageModifierProfil modificationProfil(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonmodifierProfilQuiAEteCree);
        return PageFactory.initElements(driver, PageModifierProfil.class);

    }

    public void supprimerProfil (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonSupprimerProfilQuiAEteCree);
    }



}
