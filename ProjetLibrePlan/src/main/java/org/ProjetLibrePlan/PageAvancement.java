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
    WebElement fieldType;

    @FindBy(xpath = "//span[contains(text(), \"Pourcentage\")]/ancestor::tr//input[@type=\"checkbox\"]")
    WebElement checkboxPourcentage;

    @FindBy(xpath = "//td[contains(text(), \"Enregistrer\")]")
    WebElement boutonEnregistrer;

    @FindBy(xpath = "//td[contains(text(), \"Sauver\")]")
    WebElement boutonSauver;

    @FindBy(xpath = "//td[contains(text(), \"Annuler\")]")
    WebElement boutonAnnuler;

    @FindBy(xpath = "//span[contains(text(),\"enregistré\")]")
    WebElement messageEnregistrement;

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
    public void clickCreerAvancement(WebDriverWait wait) throws Throwable {
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

    // Type par défaut
    public String getTypeDefaut(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(fieldType));
        return fieldType.getText();
    }

    public boolean isModifiableType(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(fieldType));
        return tools.isModifiable(wait, fieldType);
    }

    // Pourcentage
    public boolean isCheckedPourcentage(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(checkboxPourcentage));
        return checkboxPourcentage.isSelected();
    }

    // boutons Enregistrer
    public boolean isDisplayEnregister(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(boutonEnregistrer));
        return boutonEnregistrer.isDisplayed();
    }

    // boutons Sauver
    public boolean isDisplaySauver(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(boutonSauver));
        return boutonSauver.isDisplayed();
    }

    // boutons Sauver
    public boolean isDisplayAnnuler(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(boutonAnnuler));
        return boutonAnnuler.isDisplayed();
    }

    // créer un type d'avancement
    public void creerAvancement(WebDriverWait wait, String nomUnite, boolean checkActif, String valeurMax, String precision, boolean checkPourcentage) throws Throwable {
        tools.setValue(wait, fieldNomUnite, nomUnite);
        tools.setCheckbox(wait, checkboxActif, checkActif);
        tools.setValue(wait, fieldValeurMaximum, valeurMax);
        tools.setValue(wait, fieldPrecision, precision);
        tools.setCheckbox(wait, checkboxPourcentage, checkPourcentage);
        tools.clickElement(wait, boutonEnregistrer);
    }

    // message enregistrement
    public String getMessageEnregistrement(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(messageEnregistrement));
        return messageEnregistrement.getText();
    }

    public boolean isDisplayNouveauType(WebDriverWait wait, String nomUnite){
        String xpath = "//span[contains(text(),\"" + nomUnite + "\")]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isDisplayed();
    }

    // case activé du nouveau type d'avancement
    public boolean isSelectedActiveNouveauAvancement(WebDriverWait wait, String nomUnite){
        String xpath = "(//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//input)[1]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isSelected();
    }

    public boolean isEnabledActiveNouveauAvancement(WebDriverWait wait, String nomUnite){
        String xpath = "(//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//input)[1]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isEnabled();
    }

    // case prédéfini du nouveau type d'avancement
    public boolean isSelectedPredefNouveauAvancement(WebDriverWait wait, String nomUnite){
        String xpath = "(//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//input)[2]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isSelected();
    }

    public boolean isEnabledPredefNouveauAvancement(WebDriverWait wait, String nomUnite){
        String xpath = "(//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//input)[2]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isEnabled();
    }

    // icônes d'un type d'avancement
    public boolean isDisplayModifier(WebDriverWait wait, String nomUnite){
        String xpath = "//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//img[contains(@src, \"editar1\")]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isDisplayed();
    }

    public boolean isDisplaySupprimer(WebDriverWait wait, String nomUnite){
        String xpath = "//span[contains(text(),\"" + nomUnite + "\")]//ancestor::tr//img[contains(@src, \"borrar1\")]";
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return el.isDisplayed();
    }
}
