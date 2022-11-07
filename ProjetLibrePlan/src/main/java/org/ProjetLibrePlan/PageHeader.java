package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHeader extends AbstractPage {

    public PageHeader (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //


    // ********** Methodes ************ //
    public <T> T clickOption(String onglet, String option, Class<T> className){
        Actions action = new Actions(driver);

        WebElement elementOnglet = driver.findElement(By.xpath("//button[contains(text(), \"" + onglet + "\")]"));
        action.moveToElement(elementOnglet).perform();
        WebElement choixOption = driver.findElement(By.xpath("//ul//a[@class=\"z-menu-item-cnt\" and contains(text(), \"" + option + "\")]"));
        choixOption.click();
        return PageFactory.initElements(driver, className);
    }
}
