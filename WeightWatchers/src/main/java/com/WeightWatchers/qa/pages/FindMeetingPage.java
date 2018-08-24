package com.WeightWatchers.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.WeightWatchers.qa.base.TestBase;

public class FindMeetingPage extends TestBase{
	//Page Objects
	@FindBy(id="meetingSearch")
	WebElement searchbar;
	@FindBy(className="input-group-btn")
	WebElement searchBtn;
	@FindBy(xpath="(//*[@class='location__name']/span)[1]")
	WebElement firstResult;
	@FindBy(xpath="(//*[@class='location__distance'])[1]")
	WebElement distance;
	
	public FindMeetingPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyMeetingPageTitle()
	{
		return driver.getTitle();
	 }
	//Search with given text.For simplicity I have written in properties file but in TestNG test data is passed via xml file.
	public void search(String search)
	{
		searchbar.sendKeys(search);		
		searchBtn.click();
	}
	//Get the link text of first location link
	public String getLinkText()
	{
		waitUnitlTextPresent(firstResult);
		return (firstResult.getText());
	}
	//Get the distance of first location
	public String getDistance()
	{
		waitUnitlTextPresent(distance);
		return (distance.getAttribute("innerText"));
	}
	//Click the location link and return locationDetailsPage object
	public LocationDetailsPage  clickResult()
	{
		firstResult.click();
		return new LocationDetailsPage();
	}
}
