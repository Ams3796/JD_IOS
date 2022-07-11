package com.objectRepo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.genericLib.ReadData_PropertyFile;

import io.appium.java_client.ios.IOSDriver;

public class SearchProductPage {

	public IOSDriver<WebElement> driver;

	ReadData_PropertyFile prop = new ReadData_PropertyFile();

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']")
	public WebElement dont_allow_button;

	public WebElement getDont_allow_button() {
		return dont_allow_button;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Agree and Continue']")
	public WebElement agreeandcontinue;

	public WebElement getAgreeandcontinue() {
		return agreeandcontinue;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']")
	private WebElement contact_dontallow;

	public WebElement getContact_dontallow() {
		return contact_dontallow;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
	private WebElement maybelater;

	public WebElement getMaybelater() {
		return maybelater;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow While Using App']")
	private WebElement allow_location_access;

	public WebElement getAllow_location_access() {
		return allow_location_access;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement allow_contact_access;

	public WebElement getAllow_contact_access() {
		return allow_contact_access;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SHOPPING']")
	private WebElement shopping_option;

	public WebElement getShopping_option() {
		return shopping_option;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField")
	private WebElement search_bar;

	public WebElement getSearch_bar() {
		return search_bar;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='locationHdrIcn']")
	private WebElement location_dropdown;

	public WebElement getLocation_dropdown() {
		return location_dropdown;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Start typing your location']")
	private WebElement location_searchbar;

	public WebElement getLocation_searchbar() {
		return location_searchbar;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Manyata Tech Park')]")
	private WebElement location_suggestion;

	public WebElement getLocation_suggestion() {
		return location_suggestion;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@value=' What? eg. Restaurants']")
	private WebElement prod_seachbar;

	public WebElement getProd_seachbar() {
		return prod_seachbar;
	}

	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
	private List<WebElement> auto_suggestion;

	public List<WebElement> getAuto_suggestion() {
		return auto_suggestion;
	}

	@FindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell)[2]")
	private WebElement tap_2nd_suggestion;

	public WebElement getTap_2nd_suggestion() {
		return tap_2nd_suggestion;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='egLoginLogoIcnND']")
	private WebElement justdial_logo;

	public WebElement getJustdial_logo() {
		return justdial_logo;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=' Sort By'])[1]")
	private WebElement sortby_option;

	public WebElement getSortby_option() {
		return sortby_option;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\" Filters\"])[1]")
	private WebElement filters_option;

	public WebElement getFilters_option() {
		return filters_option;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\" Map\"])[1]")
	private WebElement map_option;

	public WebElement getMap_option() {
		return map_option;
	}

	@FindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText[4]")
	private List<WebElement> restaurant_name;

	public List<WebElement> getRestaurant_name() {
		return restaurant_name;
	}

	@FindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText[4])[2]")
	private WebElement tap_2nd_restaurant;

	public WebElement getTap_2nd_restaurant() {
		return tap_2nd_restaurant;
	}

	@FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
	private WebElement resultpage_searchfield;

	public WebElement getResultpage_searchfield() {
		return resultpage_searchfield;
	}

	@FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText")
	private WebElement resultpage_restname;

	public WebElement getResultpage_restname() {
		return resultpage_restname;
	}

	public void verify_setlocation_searchprod() throws IOException {
		search_bar.click();
		location_dropdown.click();
		location_searchbar.sendKeys(prop.readProp("Location"));
		location_suggestion.click();
		search_bar.click();
		prod_seachbar.sendKeys(prop.readProp("Searchbar"));
	}

	public void verify_logo_display() {
		String logo = justdial_logo.getText();
		boolean display = justdial_logo.isDisplayed();
		System.out.println(logo + " logo displayed is : " + display);
	}

	public void verify_options() {
		boolean sort = sortby_option.isDisplayed();
		System.out.println("Sort option displayed is : " + sort);
		boolean filters = filters_option.isDisplayed();
		System.out.println("Filters option displayed is : " + filters);
		boolean map = map_option.isDisplayed();
		System.out.println("Map option displayed is : " + map);
	}

	public void verify_restaurant_names() {
		List<WebElement> res_names = restaurant_name;
		System.out.println(res_names.size());
		for (WebElement res_name : res_names) {
			String name = res_name.getText();
			System.out.println(name);
		}

	}

	public void verify_search() {
		String search_field = resultpage_searchfield.getText();
		boolean display1 = resultpage_searchfield.isDisplayed();
		System.out.println(search_field + " displayed is : " + display1);
	}

	public void verify_result_rest_name() {
		String rest_name = resultpage_restname.getText();
		boolean display2 = resultpage_restname.isDisplayed();
		System.out.println(rest_name + " displayed is : " + display2);
	}

}
