package com.demo.nopcom.pages;

import com.cucumber.listener.Reporter;
import com.demo.nopcom.utility.UtilityRM;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*
 * Ravi's Creation
 * Date of Creation 27 Apr 20
 */
public class RegistrationCompletePage extends UtilityRM {

    private static final Logger log = LogManager.getLogger(RegistrationCompletePage.class.getName());

    @FindBy(xpath = "//div[@class='master-wrapper-content']//div[text()='Your registration completed']")
    WebElement _yourRegCompleted;

    public void verifyTextYourRegistrationCompleted(String strRegComplited) {
        Reporter.addStepLog("verify text show"+strRegComplited+"displayed msg"+_yourRegCompleted.toString()+"<br>");
        verifyTextAssertMethod(_yourRegCompleted,strRegComplited);
        log.info("verify text show"+strRegComplited+"displayed msg"+_yourRegCompleted.toString());
    }

}
