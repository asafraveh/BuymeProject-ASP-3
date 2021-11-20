package buyme.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import buyme.base.BasePage;

public class SenderReceiverScreen extends BasePage {

    public void enterReceiverName() {
        clickElement(By.cssSelector("input[maxlength=\"25\"]"));
        sendKeysToElement(By.cssSelector("input[maxlength=\"25\"]"), "danyel");
        sendKeysToElement(By.cssSelector("textarea[rows=\"4\"]"), "תודה");


    }

    private void sendKeysToElementWithKeys(By xpath, Keys tab) {
    }

//    public void enterPurpose() {
//   clickElement(By.cssSelector("div[class=\"selected-name\""));
//     clickElement(By.cssSelector("eventType"));
//     clickElement(By.xpath("//*[@id=\"ember2456\"]"));


    public void enterTextForBlessing() {
        //    clickElement(By.xpath("//*[@id=\"ember2395\"]"));
        //  sendKeysToElement(By.linkText("ברכה"),"תודה");
        //  sendKeysToElement(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.CONTROL + "a");
        //    sendKeysToElementWithKeys(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.DELETE, "Mazal tovv");
    }

    public void uploadPhoto() {
        sendKeysToElement(By.cssSelector("input[type=file]"), "C:\\Users\\sioas\\Desktop\\זמני\\c5a9c67c-c895-413f-b4ec-c8c4e63f27b0.jpg");
    }


    public void pressContinue() {
        clickElement(By.cssSelector("button[gtm=המשך]"));
    }


}


