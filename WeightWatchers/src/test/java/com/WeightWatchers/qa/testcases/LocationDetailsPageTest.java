package com.WeightWatchers.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.WeightWatchers.qa.base.TestBase;
import com.WeightWatchers.qa.pages.FindMeetingPage;
import com.WeightWatchers.qa.pages.HomePage;
import com.WeightWatchers.qa.pages.LocationDetailsPage;

public class LocationDetailsPageTest extends TestBase {
	HomePage homepage;
	FindMeetingPage findMeeting;
	LocationDetailsPage locationDetails;
	public String locationNameBeforeClickingLink;

	@BeforeMethod
	public void setUp(){
		//Setting up till location details page and getting first link location details
		initialization();
		homepage = new HomePage();
		findMeeting = new FindMeetingPage();
		homepage.clickMeetingLink();
		findMeeting.search(search);
		locationNameBeforeClickingLink=findMeeting.getLinkText();
		locationDetails = findMeeting.clickResult();
	}
	@Test(priority=1)
	public void verifyTextAfterClick(){
		//Get the location name and compare with old location name
		String locationNameAfterClickingLink=locationDetails.afterClickGetText();
		Assert.assertEquals(locationNameBeforeClickingLink, locationNameAfterClickingLink);
		//Get the timings and print
		System.out.println("Todays timings of the store :" + locationDetails.locationTimings());
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
