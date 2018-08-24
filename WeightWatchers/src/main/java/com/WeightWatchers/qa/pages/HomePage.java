package com.WeightWatchers.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WeightWatchers.qa.base.TestBase;

public class HomePage extends TestBase {
	//Page Objects
	@FindBy(className="find-a-meeting")
	WebElement findMeeting;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//Return the title of page
	public String validHomePageTitle()
	{
		return driver.getTitle();
	}
	//Clicks meeting link and rerun FindMettingPage object
	public FindMeetingPage clickMeetingLink()
	{
		findMeeting.click();
	 	return new FindMeetingPage();
	}
}
