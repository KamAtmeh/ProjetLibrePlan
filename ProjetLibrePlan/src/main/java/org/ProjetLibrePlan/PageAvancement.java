package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageAvancement extends PageHeader {

    // ********* Constructeur ******** //
    public PageAvancement (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //
    @FindBy(xpath = "//div[text()=\"Types d'avancement Liste\"]")
    WebElement pageTitle;

    @FindBy(xpath = "//td[text()=\"Créer\"]")
    WebElement boutonCreer;

    @FindBy(xpath = "//span[contains(text(), \"Nom d'unité\")]/ancestor::tr//input[@type=\"text\"]")
    WebElement fieldNomUnite;

    @FindBy(xpath = "//span[contains(text(), \"Actif\")]/ancestor::tr//input[@type=\"checkbox\"]")
    WebElement checkboxActif;

    @FindBy(xpath = "//span[contains(text(), \"Valeur\")]/ancestor::tr//input[@type=\"text\"]")
    WebElement fieldValeurMaximum;

    @FindBy(xpath = "//span[contains(text(), \"Précision\")]/ancestor::tr//input[@type=\"text\"]")
    WebElement fieldPrecision;

    @FindBy(xpath = "(//span[text()=\"Type\"]/ancestor::tr//span)[2]")
    WebElement fieldUser;

    @FindBy(xpath = "//span[contains(text(), \"Pourcentage\")]/ancestor::tr//input[@type=\"checkbox\"]")
    WebElement checkboxPourcentage;

    @FindBy(xpath = "//td[contains(text(), \"Enregistrer\")]")
    WebElement boutonEnregistrer;

    @FindBy(xpath = "//td[contains(text(), \"Sauver\")]")
    WebElement boutonSauver;

    @FindBy(xpath = "//td[contains(text(), \"Annuler\")]")
    WebElement boutonAnnuler;


    // ********** Methodes ************ //
    public boolean displayTitle(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    public boolean displayCreer(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(boutonCreer));
        return boutonCreer.isDisplayed();
    }

    // Créer un type d'avancement
    public void creerAvancement(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonCreer);
    }

    // Nom d'unité
    public String getNomUnite(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(fieldNomUnite));
        return fieldNomUnite.getAttribute("value");
    }

    // Actif
    public boolean isCheckedActif(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(checkboxActif));
        return checkboxActif.isSelected();
    }

    // Valeur par défaut
    public String getValeurDefaut(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(fieldValeurMaximum));
        return fieldValeurMaximum.getAttribute("value");
    }

    // Précision par défaut
    public String getPrecisionDefaut(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(fieldPrecision));
        return fieldPrecision.getAttribute("value");
    }

//    Type : Valeur non modifiable "User"
//    Pourcentage : case à cocher décochée par défaut
}
