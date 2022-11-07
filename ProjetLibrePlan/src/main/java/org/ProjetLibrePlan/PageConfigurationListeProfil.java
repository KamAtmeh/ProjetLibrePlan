package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConfigurationListeProfil extends AbstractPage {

    public PageConfigurationListeProfil (WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//td[@class='z-button-cl']/following-sibling::td[contains (text(), 'Créer')]")
    public WebElement boutonCreerProfil;




    public pageConfigurationCreeProfil creationDeProfil (){
        boutonCreerProfil.click();
        return PageFactory.initElements(driver, pageConfigurationCreeProfil.class);
    }

}
