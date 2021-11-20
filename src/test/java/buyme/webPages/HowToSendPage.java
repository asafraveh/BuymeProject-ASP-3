package buyme.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import buyme.base.BasePage;

public class HowToSendPage extends BasePage {


//    public void sendByMail() {
//        clickElementFromlist(By.className("circle-area"), 1);
//        sendKeysToElement(By.cssSelector("input[data-parsley-type=\"email\"]"), Keys.CONTROL + "a");
//        sendKeysToElement(By.cssSelector("input[data-parsley-type=\"email\"]"), "tomkaro789@gmail.com");


    public void enterSenderName() {
        clearText(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"));
        sendKeysToElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"), "asaf");
    }

    public void paymentSubmit() {
        clickElement(By.cssSelector("button[type=\"submit\"]"));
    }

}
