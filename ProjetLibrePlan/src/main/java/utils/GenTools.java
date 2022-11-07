package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

/* Class for defining tools that can be used in any project
such as clear field, input value and click button
 */
public class GenTools extends Logging {

    private final String className;

    public GenTools(String className){
        this.className = className;
    }

    // function to click on element after waiting
    public void clickElement(WebDriverWait wait, WebElement element) throws Throwable {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // function to fill fields after clearing them
    public void setValue(WebDriverWait wait, WebElement element, String string) throws Throwable {
        clickElement(wait, element);
        element.clear();
        element.sendKeys(string);
    }

    // take screenshot of webpage and stock it in folder
    public void takeSnapShot(WebDriver driver , String fileName) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        String fileWithPath = ".\\target\\screenshots\\" + fileName;
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
