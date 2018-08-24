package com.WeightWatchers.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.WeightWatchers.qa.base.TestBase;
import com.WeightWatchers.qa.pages.FindMeetingPage;
import com.WeightWatchers.qa.pages.HomePage;

public class FindMeetingPageTest extends TestBase {
	
	HomePage homepage;
	FindMeetingPage findMeeting;
	//SetUp for meeting page 
	@BeforeMethod
	public void setUp(){
		initialization();
		homepage = new HomePage();
		findMeeting = homepage.clickMeetingLink();
	}
	//To validate title of meeting page
	@Test(priority=1)
	public void verifyMeeting()
	{
		String meetingPageTitle=findMeeting.VerifyMeetingPageTitle();
		Assert.assertTrue(meetingPageTitle.contains("Get Schedules & Times Near You"));
	}
	
	//To search and click on link
	@Test(priority=2)
	public void searchTest() throws InterruptedException 
	{
		 findMeeting.search(search);
		 System.out.println("Distance for first location is : "+  findMeeting.getDistance());
		 String locationNameBeforeClickingLink=findMeeting.getLinkText();
		 System.out.println("Text of first link is : "+  locationNameBeforeClickingLink);
		 findMeeting.clickResult();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
