package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {

    public static void selectIndex(WebElement element, int indexNumber){
        Select select=new Select(element);
        select.selectByIndex(indexNumber);
    }

    public static void selectValue(WebElement element, String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }

    public static void selectText(WebElement element, String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
    }



    public  static String takeScreenshot() {
        //We use getScreenShots method to get the screenshot from our driver.
        //we convert output to the File type
        File source = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE); // take screenshot method
        //System.getProperty("user.dir'"); -- it will give the current project file directory
        //CurrentTimeMillis() we use this method to get unique name for our every screenshot
        String destination=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
        //create one File Object for destination
        File des=new File(destination);
        try {
            FileUtils.copyFile(source,des);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
