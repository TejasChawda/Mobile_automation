package org.example.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.models.User;

public class SignUpScreen {
    AndroidDriver<MobileElement> driver;
    public SignUpScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public HomeScreen signup(User client) {

    }
}
