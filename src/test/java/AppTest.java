import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
    }

    @Test
    public void testAppLaunch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/splashscreen")));
        Assert.assertTrue(driver.findElement(By.id("com.androidsample.generalstore:id/splashscreen")).isDisplayed(),         "Splash screen is displayed");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.androidsample.generalstore:id/splashscreen")));
        //TitleGeneral Store
        WebElement titleGeneralStoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\t\n" +
                "com.androidsample.generalstore:id/toolbar_title")));
        String expectedTitleGeneralStore = "General Store";
        String actualTitleGeneralStore = titleGeneralStoreElement.getText();
        Assert.assertEquals(actualTitleGeneralStore, expectedTitleGeneralStore, "Title text should be '" + expectedTitleGeneralStore + "', but was '" + actualTitleGeneralStore + "'");

        //Text Select country

        WebElement textViewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Select the country where you want to shop\"]\n")));
        String expectedText = "Select the country where you want to shop";
        String actualText = textViewElement.getText();
        Assert.assertEquals(actualText, expectedText, "Text View text should be '" + expectedText + "', but was '" + actualText + "'");
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


