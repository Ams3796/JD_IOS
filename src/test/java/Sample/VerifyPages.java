package Sample;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLib.BaseClass;
import com.genericLib.DriverUtils;
import com.genericLib.ReadData_PropertyFile;
import com.objectRepo.SearchProductPage;

public class VerifyPages extends BaseClass {

	DriverUtils utils = new DriverUtils();
	ReadData_PropertyFile prop = new ReadData_PropertyFile();
	SearchProductPage sp;

	@Test
	public void verify() throws IOException, InterruptedException {
		sp = PageFactory.initElements(driver, SearchProductPage.class);

		Thread.sleep(1000);
		sp.getDont_allow_button().click();
		sp.getAgreeandcontinue().click();
		sp.getContact_dontallow().click();
		sp.getMaybelater().click();
		sp.getAllow_location_access().click();

		Assert.assertTrue(sp.getShopping_option().isDisplayed());
		sp.verify_setlocation_searchprod();
		List<WebElement> auto_sug = sp.getAuto_suggestion();
		System.out.println(auto_sug.size());
		for (WebElement suggestion : auto_sug) {
			String texts = suggestion.getText();
			System.out.println(texts);
		}

		sp.getTap_2nd_suggestion().click();
		sp.verify_logo_display();
		sp.verify_options();
		sp.verify_restaurant_names();
		sp.getTap_2nd_restaurant().click();
		sp.verify_logo_display();
		sp.verify_search();
		sp.verify_result_rest_name();

		for (int i = 1; i <= 4; i++) {
			WebElement options = (WebElement) driver
					.findElementByXPath("(//XCUIElementTypeOther[@name='Call']/XCUIElementTypeButton)[" + i + "]");
			String option = options.getText();
			System.out.println("Option " + i + " : " + option);
		}

	}

}
