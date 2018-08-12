package com.kurs.selenium.przyklad1;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

import org.junit.*;

public class SearchTest2 {

	private WebDriver driver;

	@Before 					
	public void setUp() {		

		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");		

		driver = new FirefoxDriver();	

		driver.manage().window().maximize();

	}

	@Test
	public void testGoogleSearch() {		

		driver.get("http://www.bing.com");

		WebElement searchbox = driver.findElement(By.name("q"));		//q = query
		
		WebElement lupka = driver.findElement(By.name("go"));	
		
		searchbox.clear();

		searchbox.sendKeys("Mistrzostwa Europy w lekkoatletyce 2018");
		
		try {
			Thread.sleep(2500); //uśpienie wątku z automatycznym (wymaganym) try-catch
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		lupka.click();

	}

	@After

	public void tearDown() throws Exception {

		driver.close();
	}
} 

