package org.example.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public interface DriverSetup<Driver>{

    Driver create(DesiredCapabilities cap) throws MalformedURLException;
}
