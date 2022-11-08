package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCategorieCout extends PageHeader{
    public PageCategorieCout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//td[contains(text(), 'Créer')")
    WebElement boutonCréerCategorieCout;

    public PageCreeCategorieCout creerUneCategorieDeCout (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonCréerCategorieCout);
        return PageFactory.initElements (driver, PageCreeCategorieCout.class);
    }
}
