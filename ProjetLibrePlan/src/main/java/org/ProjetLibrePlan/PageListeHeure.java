package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageListeHeure extends PageHeader {
    public PageListeHeure(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//td[contains(text(), 'Créer')]")
    public WebElement boutoncCreeListeHeure;

    @FindBy (xpath = "(//span[@class='z-label']) [3]")
    public WebElement Nomclickable;

    @FindBy (xpath = "(//span[@class='z-label']) [3]")
    public WebElement Prixclickable;

    @FindBy (xpath="(//span[@class='z-label']) [2]")
    public WebElement Codeclickable;

    public PageCreeHeure creerPageCreeHeure (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait,boutoncCreeListeHeure);
        return PageFactory.initElements(driver, PageCreeHeure.class);
    }

    public PageCreeHeure cliquerNom (){
        Nomclickable.click();;
        return PageFactory.initElements(driver, PageCreeHeure.class);
    }

    public PageCreeHeure cliquerPrix (){
       Prixclickable.click();;
        return PageFactory.initElements(driver, PageCreeHeure.class);
    }

    public PageCreeHeure cliquerCode (){
        Codeclickable.click();;
        return PageFactory.initElements(driver, PageCreeHeure.class);
    }







}
