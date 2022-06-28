package com.qaprosoft.carina.demo.hgebregiorgis.pages;

//import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "ss")
	private ExtendedWebElement placeGoingTxtField;
	
	@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")
	//@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[1]/td[6]")
	private ExtendedWebElement checkIn;
	
	@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[3]/div/div/div/div/span")
	//@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[1]")
	private ExtendedWebElement checkOut;
	
	@FindBy(xpath="//*[@id=\"xp__guests__toggle\"]/span[2]/span[1]")
	private ExtendedWebElement adults;
	
	@FindBy(xpath="//*[@id=\"xp__guests__toggle\"]/span[2]/span[2]/span")
	private ExtendedWebElement children;
	
	@FindBy(xpath="//*[@id=\"xp__guests__toggle\"]/span[2]/span[3]/span")
	private ExtendedWebElement rooms;
	
	@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
	private ExtendedWebElement searchBtn;
	
	
	
	public void setPlaceGoingTxtField(String city) {
		placeGoingTxtField.type(city);
	}


	public void setCheckIn(String checkinDate) {
		checkIn.type(checkinDate);
	}
	
	
	public void setCheckOut(String checkoutDate) {
		checkOut.type(checkoutDate);
	}
	
	
	public void setAdults(String adults) {
		this.adults.type(adults);
	}
	
	public void setChildren(String children) {
		this.children.type(children);
	}
	
	public void setRooms(String rooms) {
		this.rooms.type(rooms);
	}
	
	public PropertySearchResultPage clickSearchBtn() {
		searchBtn.click();
		return new PropertySearchResultPage(driver);
	}
}
