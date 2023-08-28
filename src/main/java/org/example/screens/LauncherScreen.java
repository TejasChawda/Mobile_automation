package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LauncherScreen {

    AppiumDriver<MobileElement> appiumDriver;
    public LauncherScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void navToClientSignup() {
    }
}
