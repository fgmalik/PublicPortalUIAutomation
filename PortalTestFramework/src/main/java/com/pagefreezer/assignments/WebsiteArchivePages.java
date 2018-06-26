package com.pagefreezer.assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteArchivePages {

	static String webArchiveTabLabel = "Websites";
	static String webArchivePageTitle = "Archive | PageFreezer.com";
	static String websiteArchivePageHeading = "Website archive for:";
	
	public void goTo() {
		goToWebsiteArchiveTab();
		goToFirstWebArchiveLink();
	}

	public void goToWebsiteArchiveTab() {
		WebDriverWait wait=new WebDriverWait(Browser.driver, 15);
		WebElement websiteArchiveTab;
		websiteArchiveTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(webArchiveTabLabel)));
		websiteArchiveTab.click();
	}
	
	public void goToFirstWebArchiveLink() {		
		WebDriverWait wait=new WebDriverWait(Browser.driver, 15);
		WebElement firstWebArchiveLink;
		firstWebArchiveLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='govt-content']/div[6]/div/div/section[2]/table/tbody/tr/td/a/p")));
		firstWebArchiveLink.click();
	}

	public boolean isAt() {
		String homePageTab = Browser.driver.getWindowHandle();
		Set<String> set = Browser.driver.getWindowHandles();		 
		set.remove(homePageTab);
		assert set.size() == 1;
		Browser.driver.switchTo().window((String) set.toArray()[0]);
		
		try { Thread.sleep(15000); } catch (InterruptedException e1) {e1.printStackTrace();}
		
		boolean isAtWebArchivePage = Browser.driver.getTitle().equals(webArchivePageTitle);
		Browser.driver.close();
		Browser.driver.switchTo().window(homePageTab);
		
		return isAtWebArchivePage;
	}
}