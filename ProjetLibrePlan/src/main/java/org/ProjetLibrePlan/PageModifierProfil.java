package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageModifierProfil extends PageHeader {
    public PageModifierProfil(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement menuDeroulantRole;

    @FindBy(xpath = "//td[contains (text(),'Profils')]")
    public WebElement choixProfilsDansMenuDeroulant;

    @FindBy(xpath = "//td[contains (text(),'Canevas')]")
    public WebElement choixCanevasDansMenuDeroulant;

    @FindBy(xpath = "//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    public WebElement ChampNomProfilPageModifierProfil;

}


