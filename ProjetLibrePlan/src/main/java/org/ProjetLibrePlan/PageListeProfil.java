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

    @FindBy (xpath="")




    public PageCreeProfil creationDeProfil (){
        boutonCreerProfil.click();
        return PageFactory.initElements(driver, PageCreeProfil.class);
    }

}
