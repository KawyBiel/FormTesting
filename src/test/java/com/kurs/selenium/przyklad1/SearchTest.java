package com.kurs.selenium.przyklad1;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

import org.junit.*;

public class SearchTest {

	private WebDriver driver;

	@Before 					// zaciagniete z JUnit - według Before, Test, After wykonywany jest kod, a nie wg kolejności linijek
	public void setUp() {		// ustawienia, np, przeglądarka

		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");		//miejsce do odpalenia drivera, który steruje przeglądarką

		driver = new FirefoxDriver();	//nowy objekt "drive" typu Firefox => inicjalizacja, obiekt ten będzie sterował przeglądarką

		driver.manage().window().maximize();

	}

	@Test	// to co poniżej jest testem (definiuje JUnit) i decyduje o wyniku z JUnit, czy Test failed or passed)
	public void testGoogleSearch() {		

		driver.get("http://www.bing.com");

		WebElement element = driver.findElement(By.name("q"));	/*do objektu element typu WebElement zostaje przypisane 
																 do elementu z nazwą "q" wyszukanego w przeglądarce */

		element.clear();

		element.sendKeys("Testowanie Selenium");

		element.submit();
	}

	@After

	public void tearDown() throws Exception {

		driver.close(); //lepsze niż quit, bo quit zrywa połączenie natychmiast i występują błędy
	}
}

