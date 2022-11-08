package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PageCreeHeure extends PageHeader {
    public PageCreeHeure(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']" )
    WebElement champCode;

    @FindBy (xpath="(//input[@type='checkbox'])[3]")
    WebElement checkboxCode;

    @FindBy (xpath="//input[@class='z-textbox']")
    WebElement champNomCreeHeure;

    @FindBy (xpath = "//input[@class='z-decimalbox']")
    WebElement champPrixParDéfaut;

    @FindBy (xpath="(//input[@type='checkbox'])[4]")
    WebElement checkboxActivité;

    @FindBy (xpath="//td[contains(text(), 'Enregistrer')]")
    WebElement boutonEnregistrerHeureCree;

    @FindBy (xpath="//td[contains(text(), 'Sauver et continuer')]")
    WebElement boutonSauverHeureCree;

    @FindBy (xpath="//td[contains(text(), 'Annuler')]")
    WebElement boutonAnnuler;

    @FindBy (xpath="//div[contains(text(), 'Vous devez spécifier un nombre au lieu de ddd.')]")
    WebElement messageAlerteSpécifierNombre;


    public void vérifierAlerteSpécifierNombre() {
        assertEquals("Vous devez spécifier un nombre", messageAlerteSpécifierNombre.getText());
    }

    public void viderChampCode(){
        checkboxCode.click();
        assertFalse(checkboxCode.isEnabled());
        champCode.click();
        champCode.clear();
    }

    public void remplirChampCode(String code){
        champCode.click();
        champCode.sendKeys(code);
        assertEquals(code, champCode.getText());
    }

    public void remplireCodtCopierCollerDansPrix (String copier){
        //remplir le champ code
        champCode.click();
        champCode.sendKeys(copier);
        //vérification que nom code est bien entrer dans champs
        assertEquals(copier, champCode.getText());
       //setting de la méthode copier-coller
        Actions action = new Actions(driver);
        //copier nom donné au code
        champCode.sendKeys(Keys.CONTROL, "c");
        champPrixParDéfaut.click();
        // collé dans champ prix
        champPrixParDéfaut.sendKeys(Keys.CONTROL,"v");
        //initialiser méthode qui attend message d'erreur
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //driver attend que le message d'erreur soit visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Vous devez spécifier un nombre au lieu ')]")));
        // nettoyage du champ prix
        champPrixParDéfaut.click();
        champPrixParDéfaut.clear();
    }

    public void remplirchampPrix (String prix){
        champPrixParDéfaut.click();
        champPrixParDéfaut.sendKeys(prix);
    }

    public PageListeHeure enregistrerHeureCree (){
        boutonEnregistrerHeureCree.click();
        return PageFactory.initElements(driver, PageListeHeure.class);
    }

    public void sauverHeureCree (){
        boutonSauverHeureCree.click();

        }

    public void annulerHeureCree (){
        boutonAnnuler.click();
    }
    }


