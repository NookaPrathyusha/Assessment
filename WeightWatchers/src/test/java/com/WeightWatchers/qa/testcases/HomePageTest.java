package com.WeightWatchers.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WeightWatchers.qa.base.TestBase;
import com.WeightWatchers.qa.pages.FindMeetingPage;
import com.WeightWatchers.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homepage;
	FindMeetingPage findMeeting;
	//Setup for home page
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage = new HomePage();	
	}
	
	//Validating home page title
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title = homepage.validHomePageTitle();
		Assert.assertEquals(title, "Weight Watchers: Weight Loss Program, Recipes & Help | WW America");
	}
	
	//Click on meeting link
	@Test(priority=2)
	public void findMeetingLinkTest()
	{
		findMeeting = homepage.clickMeetingLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
