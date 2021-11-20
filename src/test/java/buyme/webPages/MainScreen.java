package buyme.webPages;

import org.openqa.selenium.By;
import buyme.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainScreen extends BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;


    public void choosePrice() {
        clickElement(By.className("chosen-single"));
        getWebElements(By.className("active-result"), 3).click();

    }

    public void chooseArea() {
        clickElement(By.linkText("אזור"));
        getWebElements(By.className("active-result"), 2).click();

    }

    public void chooseCategory() {
        clickElement(By.linkText("קטגוריה"));
        getWebElements(By.className("active-result"), 1).click();

    }
    public void search() {
        clickElement(By.linkText("תמצאו לי מתנה"));

    }
        public void pickBusinessAndMount() {
            clickElement(By.linkText("BUYME RISHON"));
            sendKeysToElement(By.cssSelector("input[placeholder=\"הכנס סכום\"]"), "200");
            clickElement(By.cssSelector("button[gtm=\"בחירה\"]"));

        }
    }





