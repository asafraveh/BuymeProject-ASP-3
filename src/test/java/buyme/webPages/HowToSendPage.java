package buyme.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import buyme.base.BasePage;

public class HowToSendPage extends BasePage {


 //  public void sendByMail() {
 //      clickElementFromlist(By.className("circle-area"), 1);
  //     clickElement(By.className("times-circle"));
       //  sendKeysToElement(By.cssSelector("input[data-parsley-type=\"email\"]"), Keys.CONTROL + "a");
       //     sendKeysToElement(By.cssSelector("input[data-parsley-type=\"email\"]"), "dgotlieb8@gmail.com");

public void sendBySMS() {
    clickElementFromlist(By.className("circle-area"),0);
       sendKeysToElement(By.id("sms"),"0506998673");

   }
    public void enterSenderName() {
        clearText(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"));
        sendKeysToElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]"), "asaf");
    }
public void senderphonnumber(){
    sendKeysToElement(By.cssSelector("input[placeholder=\"מספר נייד\"]"),"0528354911");
}

    public void paymentSubmit() {
        clickElement(By.cssSelector("button[type=\"submit\"]"));
    }

}
