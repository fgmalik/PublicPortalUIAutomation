package com.pagefreezer.assignments;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicUsabilityTests {
	
	@BeforeTest()	
	public void setup() {
		Pages.homePage().goTo();
	}

	@Test
	public void a_userCanDoBasicSearch() {
		String searchTerm = "sacramento";
		Pages.homePage().performBasicSearch(searchTerm);
	}

	@Test
	public void b_canAccessDefaultWebsiteArchives() {		
		Pages.websiteArchivePages().goTo();
		Assert.assertTrue(Pages.websiteArchivePages().isAt());
	}

	@Test
	public void c_canSelectOnlyWebsitesToSearch() {
		Assert.assertTrue(Pages.homePage().isAtDefaultSelectedAllDropdown());
		Pages.homePage().selectOnlyWebsitesDropDown();
		Assert.assertTrue(Pages.homePage().isAtAllWebsitesDropdown());
	}

	@Test
	public void d_canUsePortalHomePage() {
		Assert.assertTrue(Pages.homePage().isAt());
	}

	@AfterTest
	public void tearDown() {
		Browser.close();
	}
}
