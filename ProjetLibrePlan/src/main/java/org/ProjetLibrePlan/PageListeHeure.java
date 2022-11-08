package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeHeure extends PageHeader {
    public PageListeHeure(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//td[contains(text(), 'Créer')]")
    public WebElement boutoncCreeListeHeure;

    @FindBy (xpath = "(//span[@class='z-label']) [2]")
    public WebElement Nomclickable;


    public PageCreeHeure creerPageCreeHeure (){
        boutoncCreeListeHeure.click();;
        return PageFactory.initElements(driver, PageCreeHeure.class);
    }


}
