package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PagePlanification extends PageHeader {

    public PagePlanification (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }



}
