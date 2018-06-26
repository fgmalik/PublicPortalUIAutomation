package com.pagefreezer.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	static String homePageUrl = "https://social.pagefreezer.com/openrecords/cityofsacramento";
	static String homePageTitle = "Social Accounts";
	static String homePageDefaultDropdownText = "Selected All";
	static String homePageAllWebsitesDropdownText = "All Websites";

	public void goTo() {
		Browser.goTo(homePageUrl);
	}

	public boolean isAt() {
		return Browser.title().equals(homePageTitle);
	}

	public boolean isAtDefaultSelectedAllDropdown() {
		
		try { Thread.sleep(10000); } catch (InterruptedException e1) {e1.printStackTrace();}
		
		//System.out.println(Browser.driver.findElement(By.xpath("//button[@type='button']")).getText());
		return Browser.driver.findElement(By.xpath("//button[@type='button']")).getText()
				.equals(homePageDefaultDropdownText);
	}

	public boolean isAtAllWebsitesDropdown() {
		return Browser.driver.findElement(By.xpath("//button[@type='button']")).getText()
				.equals(homePageAllWebsitesDropdownText);
	}

	public void selectOnlyWebsitesDropDown() {
		Browser.driver.findElement(By.xpath("//button[@type='button']")).click();
		Browser.driver.findElement(By.xpath(
				"/html/body/div[4]/div/div/div/section/ui-view/div/div[1]/div[3]/section/div/div[1]/div/div[1]/section/ul/li[1]/div/div[3]/label/input"))
				.click();
	}

	public void performBasicSearch(String searchTerm) {
		// verify baseline for when nothing should be found form the search
		
		try { Thread.sleep(10000); } catch (InterruptedException e1) {e1.printStackTrace();}
		
		Browser.driver.findElement(By.id("Value_1")).sendKeys("nothingshouldbefoundwiththisstring");
		Browser.driver.findElement(By.xpath("//div[@id='aria-search']/div/div/div[2]/button")).click();
		
		//try { Thread.sleep(15000); } catch (InterruptedException e1) {e1.printStackTrace();}
		
		String resultsSectionXpath = "//*[@id=\"govt-content\"]/div[5]/ui-view/div/section/div/section/div/div/section[2]/section/h2";
		// "//div[@id='govt-content']/div[5]/ui-view/div/section/div/section/div/div/section[2]/section/h2/span";
		
		WebDriverWait wait=new WebDriverWait(Browser.driver, 10);
		WebElement noResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resultsSectionXpath)));
		
		assert noResultsSection.getText().equals("No results found");

		Browser.driver.findElement(By.id("Value_1")).click();
		Browser.driver.findElement(By.id("Value_1")).clear();
		Browser.driver.findElement(By.id("Value_1")).sendKeys(searchTerm);
		Browser.driver.findElement(By.xpath("//div[@id='aria-search']/div/div/div[2]/button")).click();
		
		try {
			WebElement resultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resultsSectionXpath)));			
		}catch(Exception e) {
			//do nothing. this is expected.
		}		
	}
}
