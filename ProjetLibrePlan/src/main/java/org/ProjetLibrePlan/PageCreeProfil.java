package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreeProfil extends AbstractPage {
    public PageCreeProfil(WebDriver driver) {
        super(driver);
    }

    public class PageConfigurationListeProfil extends AbstractPage {

        public PageConfigurationListeProfil(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }
    }

@FindBy
}
