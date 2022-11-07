package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageAvancement extends PageHeader {

    public PageAvancement (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
