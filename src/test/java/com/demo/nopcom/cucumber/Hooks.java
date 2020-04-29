package com.demo.nopcom.cucumber;

import com.cucumber.listener.Reporter;
import com.demo.nopcom.basepage.BasePage;
import com.demo.nopcom.browserselector.BrowserSelector;
import com.demo.nopcom.loadproperty.LoadProperty;
import com.demo.nopcom.utility.UtilityRM;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 * Ravi's Creation
 * Date of Creation 28 Apr 20
 */
public class Hooks extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();

    String baseURL = loadProperty.getProperty("baseURL");

    String browser = loadProperty.getProperty("browser");
    // this will open browser before test starts
    @Before
    public void openBrowser(){
        browserSelector.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        Reporter.assignAuthor("Prime group study", "RM");
    }
    // this will close the browser
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenShotPath = UtilityRM.getScreenshot(driver,scenario.getName().replace(" ","_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}
