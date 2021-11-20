package buyme.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import buyme.base.DriverSingleton;
import buyme.webPages.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class buyMeTest {

    String name = "asaf";
    String mail = "asafravhe@gmail.com";
    String password = "A162534a";
    private static WebDriverWait wait;
    private static ExtentReports extent;
    private static WebDriver driver;
    private static ExtentTest test;

    LoginPage loginPage = new LoginPage();
    MainScreen mainScreen = new MainScreen();
 //   PickBusiness pickBusiness = new PickBusiness();
    SenderReceiverScreen senderReceiverScreen = new SenderReceiverScreen();
    HowToSendPage howToSendPage = new HowToSendPage();


    @BeforeClass
    public void runOnce() {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");  //Establish report location
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("Test1", "Sample description");
        // log results
        test.log(Status.INFO, "@Before class");

        try {
            driver = DriverSingleton.getDriverInstance();
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
        }
        driver.get("https://buyme.co.il/");
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    //@Test // Registration process
    public void introAndRegistration() {
        try {
            loginPage.register();
            Assert.assertEquals(name, driver.findElement(By.className("ember-text-field")).getText());
            Assert.assertEquals(mail, driver.findElement(By.cssSelector("input[placeholder = מייל]")).getText());
            Assert.assertEquals(password, driver.findElement(By.className("input[placeholder = סיסמה]")).getText());
            Assert.assertEquals(password, driver.findElement(By.className("input[placeholder=\"אימות סיסמה\"]")).getText());
            loginPage.confirmRegister();
            test.log(Status.PASS, "Register completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Register failed! " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @SneakyThrows
    @Test(priority = 1) // Login process
    public void loginToBuyMe() {
        try {
            loginPage.submitLogin();
            test.log(Status.PASS, "Login completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Login failed! " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }

    }

    @Test(priority = 2) // Search for gift filters
    public void findGift() {
      try {
          Thread.sleep(6000);
        mainScreen.choosePrice();
            mainScreen.chooseArea();
            mainScreen.chooseCategory();
            mainScreen.search();
       //    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
           mainScreen.pickBusinessAndMount();
      //      pickBusiness.pickBusinessAndMount();

          JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,100)"); // Scroll down For Element

            mainScreen.search();
            test.log(Status.PASS, "Fined gift successfully");
        }catch (Exception e) {
           e.printStackTrace();
            test.log(Status.FAIL, "Gift didn't found " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());



//    @Test(priority = 3)  //Choose business and amount
//    public void enterBusinessAndAmount() {
//        try {
//         String url = "https://buyme.co.il/search?budget=3&category=337&region=11";
//          String webUrl = driver.getCurrentUrl();
//            Assert.assertEquals(webUrl, url);
//            mainScreen.pickBusinessAndMount();
//            test.log(Status.PASS, "Business choose successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            test.log(Status.FAIL, "Can't choose business  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 3)
    public void enterReceiverDetails() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            String receiverName = "בר מזל";
            senderReceiverScreen.enterReceiverName();
           // senderReceiverScreen.enterPurpose();
            senderReceiverScreen.enterTextForBlessing();
            driver.findElement(By.id("ember2025")).getText();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            senderReceiverScreen.uploadPhoto();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm=המשך]")));
           senderReceiverScreen.pressContinue();
            test.log(Status.PASS, "Receiver details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Receiver details not filled  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 5)
    public void enterHowToSend() {
        try {
            String senderName = "dgotlieb8@gmail.com";

        //    howToSendPage.sendByMail();
            howToSendPage.sendBySMS();
            howToSendPage.enterSenderName();
            howToSendPage.senderphonnumber();
            howToSendPage.paymentSubmit();
            String senderNameElement = driver.findElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]")).getText();
            Assert.assertEquals(senderNameElement, senderName);
            test.log(Status.PASS, "Choose how to send successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Must choose how to send  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());

        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        //driver.quit();
        // build and flush report
        extent.flush();
    }


    //Takes screenshot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }


}






