package com.qaprosoft.carina.demo.hgebregiorgis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class PropertyPage extends AbstractUIObject {
	
	@FindBy(xpath="//*[@id=\'hp_hotel_name\']")
	private ExtendedWebElement title;
	
	@FindBy(xpath="//*[@id=\'js--hp-gallery-scorecard\']/a/div/div/div/div/div[1]")
	private ExtendedWebElement rating;
	
	@FindBy(xpath="//*[@id=\'group_recommendation\']/table/tbody/tr/td[3]/table/tbody/tr[1]/td/div[1]/div[1]")
	private ExtendedWebElement reservationDescription;
	
	@FindBy(xpath="//*[@id=\'hotel_main_content\']/div/div[1]/div[4]/a")
	private ExtendedWebElement image;
	
	@FindBy(xpath="//*[@id=\'group_recommendation\']/table/tbody/tr/td[3]/table/tbody/tr[2]/td/a/span")
	private ExtendedWebElement reserveBtn;
	
	@FindBy(xpath="//*[@id=\"b_tt_holder_2\"]/span[2]")
	private ExtendedWebElement iWillReserveBtn;

	
	
	public PropertyPage(WebDriver driver) {
		super(driver);
		
	}
	
    public String getTitle() {
        return title.getText();
    }
    
    public String getRating() {
        return rating.getText();
    }
    
    public String getReservationDescription() {
        return reservationDescription.getText();
    }
    
    
    public boolean getImage() {
    	return image.isPresent();
    }
    
    public void clickReserveBtn() {
    	reserveBtn.click();
    }

    public ReservationPage clickIWillReserveBtn() {

    	iWillReserveBtn.click();     
        return new ReservationPage(driver);
        }
    
}
