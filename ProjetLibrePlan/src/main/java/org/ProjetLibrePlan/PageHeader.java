package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHeader extends AbstractPage {

    // ********* Constructeur ******** //
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
    public void seDeconnecter(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonSignOut);
    }

    public boolean signOutDisplay(){
        return boutonSignOut.isDisplayed();
    }

    // récupérer texte du nom de l'utilisateur
    public String getUsername(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(welcomeUsername));
        String textWelcome = welcomeUsername.getText();
        return textWelcome.substring(13);
    }

    // méthode
    public <T> T clickOption(WebDriverWait wait, String menu, String option, Class<T> className) throws Throwable {
        Actions action = new Actions(driver);
        String xpathMenu = "//button[contains(text(), \"" + menu + "\")]";
        WebElement elementMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathMenu)));
        action.moveToElement(elementMenu).perform();
        String xpathOption = "//ul//a[@class=\"z-menu-item-cnt\" and contains(text(), \"" + option + "\")]";
        WebElement choixOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOption)));
        tools.clickElement(wait, choixOption);
        return PageFactory.initElements(driver, className);
    }
}
