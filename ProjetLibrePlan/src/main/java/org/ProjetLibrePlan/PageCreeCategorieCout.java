package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreeCategorieCout extends PageHeader{
    public PageCreeCategorieCout(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkboxCodeCategorieCout;

    @FindBy (xpath="//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")
    WebElement champNomCategorieCout;

    @FindBy (xpath="//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    WebElement nomCategorieCout;

    @FindBy (xpath ="(//input[@type='checkbox'])[2]" )
    WebElement checkboxActivitéCreeCout;

    @FindBy (xpath="//select")
    WebElement menuDeroulantTypeCategorieCout;

    public void xpathTypeAvecNomHeure (String nomHeure) {
        driver.findElement(By.xpath( "//option[contains (text(), 'nomHeure')]"));
    }

    @FindBy (xpath="//input[@class='z-decimalbox']")
    WebElement champCoutHoraire;

    @FindBy (xpath="'//input[@class='z-datebox-inp']) [1]")
            WebElement champDateDebutCategorieCout;

    @FindBy (xpath= "'//input[@class='z-datebox-inp']) [2]")
    WebElement champDateFinCategorieCout;

    @FindBy (xpath="(//td[@class='z-button-cm']) [4]" )
    WebElement boutonSupprimerLigneCoutDesHeures;

    @FindBy (xpath="//td[contains(text(), 'Enregistrer')]")
    WebElement boutonEnregistrerCategorieCout;

    @FindBy (xpath="//td[contains(text(), 'Sauver et continuer')]")
    WebElement boutonSauverCategorieCout;

    @FindBy (xpath = "//td[contains(text(), 'Annuler')]")
    WebElement boutonAnnulerCategorieCout;

    @FindBy (xpath ="(//span[contains(text(),'Etes-vous sûr de vouloir supprimer ce coût horaire ?')])[2]")
    WebElement messageQuandOnvaSupprimerUneNouvelleLigneCout;







}
