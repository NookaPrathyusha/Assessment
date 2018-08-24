package com.WeightWatchers.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WeightWatchers.qa.base.TestBase;

public class LocationDetailsPage extends TestBase {
	 
	@FindBy(className="location__name")
	WebElement afterClickLocation;
	public LocationDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	//To get the text of the location after clicking on link
	public String afterClickGetText()
	{
		return afterClickLocation.getText();
	}
	public String locationTimings(){
		// To get current day of the week
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dayOftheWeek=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		//To get the timings of the location
		String timings = driver.findElement(By.xpath("//*[@class='hours-list-item-day'][contains(text(), '"+dayOftheWeek+"')]/following-sibling::div")).getText();
		return timings;
	}
}
