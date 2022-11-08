package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageModifierFormulaireQualite extends PageHeader{
    public PageModifierFormulaireQualite(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//select[@selectedindex='0']")
    public WebElement menuDeroulantModifierTypeFormulaireQualite;

    @FindBy (xpath="//option[contains (text(), 'par élément') ]")
    public WebElement menuDeroulantElement;

    @FindBy  (xpath="//option[contains (text(), 'par pourcentage') ]")
    public WebElement menuDeroulantPourcentagePageModifier;

    @FindBy (xpath="//td[contains (text(), 'Enregistrer')]")
    public WebElement boutonPageModifierEnregistrerpageCreerFormulaireQualite;

    public void setMenuDeroulantElement (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, menuDeroulantModifierTypeFormulaireQualite);
        tools.clickElement(wait, menuDeroulantElement);

    }
    public PageFormulaireQualite passageEnregistrementPageModifierAListe (WebDriverWait wait) throws Throwable {
        tools.clickElement(wait, boutonPageModifierEnregistrerpageCreerFormulaireQualite);
        return PageFactory.initElements(driver, PageFormulaireQualite.class);
    }
}
