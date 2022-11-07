package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageListeHeure extends PageHeader {
    public PageListeHeure(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//td[contains(text(), 'Créer')]")
    public WebElement boutoncCreeListeHeure;


}
