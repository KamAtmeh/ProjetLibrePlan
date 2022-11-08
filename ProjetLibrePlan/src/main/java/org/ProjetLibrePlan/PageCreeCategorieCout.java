package org.ProjetLibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreeCategorieCout extends PageHeader{
    public PageCreeCategorieCout(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkboxCodeCategorieCout;

    @FindBy (xpath="//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")
    WebElement champNomCategorieCout;

    @FindBy (xpath="//input[@class='focus-element z-textbox z-textbox-text-invalid']")
    WebElement nomCategorieCout;

    @FindBy (xpath ="(//input[@type='checkbox'])[2]" )
    WebElement checkboxActivitéCreeCout;

    @FindBy (xpath="//select")
    WebElement menuDeroulantTypeCategorieCout;

    public void xpathTypeAvecNomHeure (String nomHeure) {
        driver.findElement(By.xpath( "//option[contains (text(), 'nomHeure')]"));
    }



}
