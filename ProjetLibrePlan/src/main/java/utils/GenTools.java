package utils;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

/* Class for defining tools that can be used in any project
such as clear field, input value and click button
 */
public class GenTools extends Logging {

    private final String className;

    public GenTools(String className) {
        this.className = className;
    }


    // function to click on element after waiting
    public void clickElement(WebDriverWait wait, WebElement element) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    // function to fill fields after clearing them
    public void setValue(WebDriverWait wait, WebElement element, String string) throws Throwable {
        clickElement(wait, element);
        element.clear();
        element.sendKeys(string);
    }

    // function to set checkbox selection
    public void setCheckbox(WebDriverWait wait, WebElement element, Boolean wantChecked) throws Throwable {
        if(wantChecked == true && !(element.isSelected())){
            clickElement(wait, element);
        } else if (wantChecked == false && element.isSelected()) {
            clickElement(wait, element);
        }
    }

    // function to verify whether element is modifiable
    public boolean isModifiable(WebDriverWait wait, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        String tag = element.getTagName();
        if(tag != "input"){
            return false;
        } else if (tag == "input" && !(element.isEnabled())){
            return false;
        } else {
            return true;
        }
    }

    // execute sql file
    public void executeSqlFile(Connection con, String pathSQLFile) throws Exception {
        LOGGER.info("Initialisation du script runner...");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        LOGGER.info("Script runner initi??");
        LOGGER.info("Cr??ation d'un reader object");
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(pathSQLFile));
        LOGGER.info("Reader object cr????");
        LOGGER.info("Lecture du script SQL");
        //Running the script
        sr.runScript(reader);
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
