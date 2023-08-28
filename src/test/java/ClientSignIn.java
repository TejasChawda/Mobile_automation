import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.screens.HomeScreen;
import org.example.screens.LauncherScreen;
import org.example.screens.ProfileScreen;
import org.example.screens.SignUpScreen;
import org.example.models.User;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientSignIn {

    AndroidDriver<MobileElement> driver = null;
    @BeforeTest
    public void openEmulator() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 6");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/admin/Downloads/ul-coach.apk"); // Replace with your app's path
        caps.setCapability("appium:appPackage", "com.ultralesson.coach");
        caps.setCapability("appium:appActivity", "com.ultralesson.coach.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(url, caps);

        System.out.println("App launched!");
    }

    @Test
    public void clientShouldBeAbleToSignupSuccessfully() {
        // Assume mobileDriver is created and handy.

        //Arrange
        LauncherScreen launcherScreen = new LauncherScreen(driver);
        launcherScreen.navToClientSignup();
        User client = new User("Automation Client",
                "randomclient@gmail.com",
                "1234567890","");

        //Act
        SignUpScreen signupScreen = new SignUpScreen(driver);
        HomeScreen homeScreen = signupScreen.signup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        Assert.assertEquals(clientProfile.getEmail(), client.getEmail());
        Assert.assertEquals(clientProfile.getFullName(), client.getFullName());
        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        // Assume we have called a date utility to supply Today's Date
        Assert.assertEquals(clientProfile.getMembershipStartDate(), "Today's Date");

    }

}
