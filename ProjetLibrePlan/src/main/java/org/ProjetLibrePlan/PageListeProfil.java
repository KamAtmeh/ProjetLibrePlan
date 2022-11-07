package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeProfil extends PageHeader {

    public PageListeProfil(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//td[@class='z-button-cl']/following-sibling::td[contains (text(), 'Créer')]")
    public WebElement boutonCreerProfil;

    //xpath qui fonctionne seulement pour trouver le bouton modification du profil qu'on vient de créer dans PageCreeProfil
    @FindBy (xpath="(//td[@class='z-button-cm']) [2]")
    public WebElement boutonmodifierProfilQuiAEteCree;

    //xpath qui fonctionne seulement pour trouver le bouton supprimer du profil qu'on vient de créer dans PageCreeProfil
    @FindBy (xpath="(//td[@class='z-button-cm']) [3]")
    public WebElement boutonSupprimerProfilQuiAEteCree;




    public PageCreeProfil creationDeProfil (){
        boutonCreerProfil.click();
        return PageFactory.initElements(driver, PageCreeProfil.class);
    }

    public PageCreeProfil modificationProfil(){
        boutonmodifierProfilQuiAEteCree.click();
        return PageFactory.initElements(driver, PageCreeProfil.class);

    }

    public void supprimerProfil (){
        boutonSupprimerProfilQuiAEteCree.click();
    }



}
