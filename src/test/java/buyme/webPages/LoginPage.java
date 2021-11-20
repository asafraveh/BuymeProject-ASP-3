package buyme.webPages;

import org.openqa.selenium.By;
import buyme.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {
    public static WebDriver driver;
    public void register() {
        enterRegisterPage();
        enterCredentials();
    }

    public void loginBuyMe() {
        submitLogin();
    }


    private void enterRegisterPage() {
        clickElement(By.className("seperator-link"));
        clickElement(By.className("text-link"));
    }

    private void enterCredentials() {
        sendKeysToElement(By.className("ember-text-field"), "tom");
        sendKeysToElement(By.cssSelector("input[placeholder = מייל]"), "asafravhe@gmail.com");
        sendKeysToElement(By.cssSelector("input[placeholder = סיסמה]"), "asaf");
        sendKeysToElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"), "A162534a");
    }

    public void confirmRegister() {
        clickElement(By.className("label"));
    }

    public void submitLogin() {
        clickElement(By.className("seperator-link"));
        sendKeysToElement(By.xpath("//*[@id=\"ember1451\"]"), "asafravhe@gmail.com");
        sendKeysToElement(By.xpath("//*[@id=\"ember1451\"]"), String.valueOf(Keys.TAB));
        sendKeysToElement(By.cssSelector("input[placeholder=\"סיסמה\""),"A162534a");
        clickElement(By.cssSelector("button[type = submit]"));
    }


}
