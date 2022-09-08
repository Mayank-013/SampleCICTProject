package com.nitara.utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;


import java.io.File;
import java.util.Properties;

public class CapabilitiesManager {

	TestUtils utils = new TestUtils();

	public DesiredCapabilities getCaps() throws Exception {

		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();

		try{
			utils.log().info("getting capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUdid());
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
		//	caps.setCapability("noReset", true);
			caps.setCapability("autoGrantPermissions", "true");
			caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
//			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
//			caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			String appName = props.getProperty("AndroidApplication");
			String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "apps" + File.separator + appName;

			caps.setCapability("app",androidAppUrl);


			return caps;
		} catch(Exception e){
			e.printStackTrace();
			utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
			throw e;
		}
	}
}
