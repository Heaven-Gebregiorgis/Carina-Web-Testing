package com.qaprosoft.carina.demo.hgebregiorgis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class ReservationPage {
	
	public ReservationPage(WebDriver driver) {
	
	}

	@FindBy(xpath="//*[@id=\"bodyconstraint-inner\"]/div[3]/div[2]/aside/div/section[1]/div/div/div[1]/div[2]/div[2]")
	private ExtendedWebElement lengthOfStay;
	
	@FindBy(xpath="//*[@id=\"bodyconstraint-inner\"]/div[3]/div[2]/aside/div/section[1]/div/div/div[2]/ul/li")
	private ExtendedWebElement groups;
	
	@FindBy(xpath="//*[@id=\"bp-property-details__title\"]")
	private ExtendedWebElement title;
	
	@FindBy(xpath="")
	private ExtendedWebElement rating;

	public String getLengthOfStay() {
		return lengthOfStay.getText();
	}

	public String getGroups() {
		return groups.getText();
	}

	public String getTitle() {
		return title.getText();
	}
	
	public String getRating() {
		return rating.getText();
	}
	
	

}
