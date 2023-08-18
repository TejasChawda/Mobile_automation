import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo {

    AndroidDriver<MobileElement> driver = null;
    @BeforeTest
    public void openEmulator() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3a");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/admin/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Replace with your app's path
        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(url, caps);

        System.out.println("App launched!");
    }

    @Test
    public void loginCredentials() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Located by AccessibilityId
        MobileElement userName = driver.findElementByAccessibilityId("test-Username");
        userName.sendKeys("standard_user");

        // Located by XPath
        MobileElement passWord = driver.findElementByXPath("//android.widget.EditText[@content-desc=\"test-Password\"]");
        passWord.sendKeys("secret_sauce");

        MobileElement loginButton = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
        loginButton.click();
    }
}
