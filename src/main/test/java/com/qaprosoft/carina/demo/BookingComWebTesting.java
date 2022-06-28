package com.qaprosoft.carina.demo;


import java.util.List;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.hgebregiorgis.pages.HomePage;
import com.qaprosoft.carina.demo.hgebregiorgis.pages.PropertyPage;
import com.qaprosoft.carina.demo.hgebregiorgis.pages.PropertySearchResultPage;
import com.qaprosoft.carina.demo.hgebregiorgis.pages.ReservationPage;



public class BookingComWebTesting implements IAbstractTest {
	

	@Test()
	public void testOpeningWebsite() {
		
		
		//Making sure home page is open
		HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Filling out reservation information & clicking search button
        homePage = new HomePage(getDriver());
        homePage.setPlaceGoingTxtField("London");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.setCheckIn("07/01/2022");
        homePage.setCheckOut("07/12/2022");
        homePage.setAdults("2");
        homePage.setChildren("0");
        homePage.setRooms("1");
        PropertySearchResultPage searchPage = new PropertySearchResultPage(getDriver());
        searchPage = homePage.clickSearchBtn();
        List<ExtendedWebElement> proprties = searchPage.getProperties();
        
        
        //checking the search results with reservation information

        SoftAssert softAssert = new SoftAssert();
        for (ExtendedWebElement x : proprties) {
        softAssert.assertEquals(x.getText(), "11 nights, 2 adults, 1 child", "Invalid Search");
        
        }
        softAssert.assertAll();
	}
	
	@Test()

	public void testReservationDetail() {
		
		//Making sure home page is open
		HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Filling out reservation information & clicking search button
        homePage = new HomePage(getDriver());
        homePage.setPlaceGoingTxtField("London");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.setCheckIn("07/01/2022");
        homePage.setCheckOut("07/12/2022");
        homePage.setAdults("2");
        homePage.setChildren("1");
        homePage.setRooms("1");
        PropertySearchResultPage searchPage = new PropertySearchResultPage(getDriver());
        searchPage = homePage.clickSearchBtn();
       // List<ExtendedWebElement> proprties = searchPage.getProperties();
        
        //Selecting a property
        PropertyPage hotel = searchPage.selectProperty("Holiday Inn London Bloomsbury, an IHG Hotel");
		hotel.clickReserveBtn();
		ReservationPage reservePage = new ReservationPage(getDriver());
		reservePage = hotel.clickIWillReserveBtn();
		
		//comparing search page result with reservation page result
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(reservePage.getTitle(), hotel.getTitle(), "Invalid hotel name");
		softAssert.assertEquals(reservePage.getRating(), hotel.getRating(), "Invalid rating");
		softAssert.assertEquals(reservePage.getGroups(), hotel.getReservationDescription() );
		softAssert.assertAll();
	}
	
	

}
