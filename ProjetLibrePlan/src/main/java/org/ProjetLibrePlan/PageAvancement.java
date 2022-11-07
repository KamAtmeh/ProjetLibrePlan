package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    // ********** Methodes ************ //
    public boolean displayTitle(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    // Créer un type d'avancement
    public void creerAvancement(WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonCreer);
    }

}
