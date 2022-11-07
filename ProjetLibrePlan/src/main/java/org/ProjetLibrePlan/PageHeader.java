package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHeader extends AbstractPage {

    public PageHeader (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //
    @FindBy(xpath="//a[text()=\"[Déconnexion]\"]")
    WebElement boutonSignOut;

    @FindBy(xpath = "//td[contains(text(),\"utilisateur:\")]")
    WebElement welcomeUsername;

    // ********** Methodes ************ //

    // Se déconnecter
    public void seDeconnecter(WebElement boutonSignOut) {
        boutonSignOut.click();
    }

    // récupérer texte du nom de l'utilisateur
    public String getUsername(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(welcomeUsername));
        String textWelcome = welcomeUsername.getText();
        String finalText = textWelcome.substring(13);
        return finalText;
    }

    // méthode
    public <T> T clickOption(WebDriverWait wait, String onglet, String option, Class<T> className){
        Actions action = new Actions(driver);

        WebElement elementOnglet = driver.findElement(By.xpath("//button[contains(text(), \"" + onglet + "\")]"));
        action.moveToElement(elementOnglet).perform();
        WebElement choixOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//a[@class=\"z-menu-item-cnt\" and contains(text(), \"" + option + "\")]")));
        choixOption.click();
        return PageFactory.initElements(driver, className);
    }
}
