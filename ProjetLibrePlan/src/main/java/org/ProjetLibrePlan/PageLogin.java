package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends AbstractPage {

    public PageLogin (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
