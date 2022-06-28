package com.qaprosoft.carina.demo.hgebregiorgis.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;



public class PropertySearchResultPage extends AbstractPage {
	
    @FindBy(xpath = "//*[@id=\"search_results_table\"]")
    private List<ExtendedWebElement> properties;
    
    private ExtendedWebElement propertyLink;

   
    public PropertySearchResultPage(WebDriver driver) {
        super(driver);
    }
    
 
    
    public List<ExtendedWebElement> getProperties() {
		return properties;
	}



	public void setProperties(List<ExtendedWebElement> properties) {
		this.properties = properties;
	}



	public PropertyPage selectProperty(String propertyName) {
        for (ExtendedWebElement property : properties) {
            if (property.getName().equalsIgnoreCase((propertyName))) {
                propertyLink.click();
            }       
        }
        return new PropertyPage(driver);
    }
}


