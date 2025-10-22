import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.net.URI;
import java.time.Duration;

public class AppTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(System.getProperty("user.dir") + "/General-Store.apk")
                .setAppPackage("com.androidsample.generalstore")
                .setAppActivity("com.androidsample.generalstore.SplashActivity");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("App launched successfully");
    }

    @Test
    public void testAppLaunch() {
        WebElement splash = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.androidsample.generalstore:id/splashscreen")
        ));
        Assert.assertTrue(splash.isDisplayed(), "Splash screen should be visible");
        System.out.println("Splash screen appeared and disappeared");

        //TitleGeneral Store
        WebElement titleGeneralStoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
        String expectedTitleGeneralStore = "General Store";
        String actualTitleGeneralStore = titleGeneralStoreElement.getText();
        Assert.assertEquals(actualTitleGeneralStore, expectedTitleGeneralStore, "Title text should be '" + expectedTitleGeneralStore + "', but was '" + actualTitleGeneralStore + "'");
        System.out.println("Title verified: " + actualTitleGeneralStore);

        //Text Select country

        WebElement textSelectCountryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Select the country where you want to shop']")));
        String expectedTextSelectCountry = "Select the country where you want to shop";
        String actualTextSelectCountry = textSelectCountryElement.getText();
        Assert.assertEquals(actualTextSelectCountry, expectedTextSelectCountry, "Text View text should be '" + expectedTextSelectCountry + "', but was '" + actualTextSelectCountry + "'");
        System.out.println("Country selection text verified");

        // Text Your Name

        WebElement textYourNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your Name']")));
        String expectedTextYourName = "Your Name";
        String actualTextYourName = textYourNameElement.getText();
        Assert.assertEquals(actualTextYourName, expectedTextYourName, "Text View text should be '" + expectedTextYourName + "', but was '" + actualTextYourName + "'");
        System.out.println("Your Name  text verified");

        // Text Gender
        WebElement textGenderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Gender']")));
        String expectedTextGender = "Gender";
        String actualTextGender = textGenderElement.getText();
        Assert.assertEquals(actualTextGender, expectedTextGender, "Text View text should be '" + expectedTextGender + "', but was '" + actualTextGender + "'");
        System.out.println("Text  Gender verified");

        // Negative - Wrong Text

        //WebElement textGenderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Gender']")));
        //String expectedTextGender = "Female";
        //String actualTextGender = textGenderElement.getText();
        //Assert.assertEquals(actualTextGender, expectedTextGender, "Text View text should be '" + expectedTextGender + "', but was '" + actualTextGender + "'");
        //System.out.println("Text  Female verified");



    }


    //@Test
    //public void testDashboard(){
      //  WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\t\n" +
               // "com.androidsample.generalstore:id/toolbar_title")));
       // String expectedText = "General Store";
        //String actualText = titleElement.getText();
      //  Assert.assertEquals(actualText, expectedText, "Title text should be '" + expectedText + "', but was '" + actualText + "'");
    //}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


