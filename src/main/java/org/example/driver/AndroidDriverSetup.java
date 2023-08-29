package org.example.driver;

import com.github.dockerjava.api.model.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.driver.DriverSetup;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverSetup implements DriverSetup {

    @Override
    public AppiumDriver<MobileElement> create(DesiredCapabilities cap) throws MalformedURLException {
        return new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub/"), cap);
    }


}
