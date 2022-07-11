package com.genericLib;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.objectRepo.SearchProductPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;

public class BaseClass {

	public static AppiumDriver<IOSElement> driver;
	public static SearchProductPage sp;

	ReadData_PropertyFile prop = new ReadData_PropertyFile();
	DriverUtils utils = new DriverUtils();

	@BeforeClass
	public void setUp() throws IOException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "amara_ZhuYkB");
		caps.setCapability("browserstack.key", "NUaDMEDCcpuGDSyJpbfn");

		// Set URL of the application under test
		caps.setCapability("app", "bs://391eb9e070e1cc254637e392289a49d289711d3e");

		// Specify device and os_version for testing
		caps.setCapability("device", "iPhone XS");
		caps.setCapability("os_version", "13");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "browserstack-build-1");
		caps.setCapability("name", "first_test");
		caps.setCapability("noReset", "true");
		caps.setCapability("autoGrantPermissions", "true");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		driver = new AppiumDriver<IOSElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
		utils.implicitwait(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Started");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closed");
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}
}
