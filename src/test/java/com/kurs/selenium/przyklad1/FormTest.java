package com.kurs.selenium.przyklad1;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class FormTest {

	private WebDriver driver;
	boolean isElementPresent;

	@Before 					
	public void setUp() {		

		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");	
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
	}

	@Test
	public void testUserSuccessfullyCreated() {		
		driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
		
		//dane testowe
		String firstName = "Jan";
		String lastName = "Kowalski";
		String address = "Wrocław";
		String email = "mail@test.com";
		String password = "123456";
		String company = "CodersLab";
		String comment = "First test case";
		
		//lokatory - adresy do pól na stronie -> najlepiej poszukać przez inspekcję elementu na stronie
		String firstNameLocator = "first-name";
		String lastNameLocator = "last-name";
		String genderLocator = "/html/body/div/div/form/div[3]/div/div/label[1]/input";
		String dateOfBirthLocator = "dob";
		String calendarLocator = "/html/body/div[2]/div[1]/table/tbody/tr[3]/td[4]";
		String addressLocator = "address";
		String emailLocator = "email";
		String passwordLocator = "password";
		String companyLocator = "company";
		String commentLocator = "comment";
		String roleLocator = "role";
		String jobExpectationLocator = "expectation";
		String techConsCheckboxLocator = "/html/body/div/div/form/div[11]/div/div[4]/label";
		String submitLocator = "submit";

		//Wpisz imię
		WebElement firstNameElement = driver.findElement(By.id(firstNameLocator));		//definiujemy okno do wpisania
		
		//zad. 11, sprawdzanie czy dostępny oraz zwróć nazwę elementu imię + wynik
		isElementPresent = firstNameElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + firstNameElement.getAttribute("name") + ": " + firstName);
		
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
		
		
		//Wpisz nazwisko
		WebElement lastNameElement = driver.findElement(By.id(lastNameLocator));		
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
		
		isElementPresent = lastNameElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + lastNameElement.getAttribute("name") +" : "+ lastName);
		
		//Wybierz płeć
		WebElement genderElement = driver.findElement(By.xpath(genderLocator));		//klikamy na pierwszy element, czyli man
		genderElement.click();		
		
		isElementPresent = genderElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + genderElement.getAttribute("name") + " : " + "Male");
			
		//Wybierz date urodzin
		WebElement dateOfBirthElement = driver.findElement(By.id(dateOfBirthLocator));	//klikamy na wybór daty
		dateOfBirthElement.click();
			
		WebElement calendarElement = driver.findElement(By.xpath(calendarLocator));	//klikamy na wybrany dzień w kalendarzu
		calendarElement.click();
		
		isElementPresent = dateOfBirthElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + dateOfBirthElement.getAttribute("name") + " : ");
			
		//Wpisz adres
		WebElement addressElement = driver.findElement(By.id(addressLocator));
			
		addressElement.click();
			
		addressElement.clear();
		addressElement.sendKeys(address);	
			
		isElementPresent = addressElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + addressElement.getAttribute("name") +" : "+ address);
	
		//Wpisz email
		WebElement emailElement = driver.findElement(By.id(emailLocator));
		emailElement.clear();
		emailElement.sendKeys(email);	
		
		isElementPresent = emailElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + emailElement.getAttribute("name") +" : "+ email);
						
		//Wpisz password
		WebElement passwordElement = driver.findElement(By.id(passwordLocator));
		passwordElement.clear();
		passwordElement.sendKeys(password);	
		
		isElementPresent = passwordElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + passwordElement.getAttribute("name") +" : "+ password);
		
		//Wpisz company
		WebElement companyElement = driver.findElement(By.id(companyLocator));
		companyElement.clear();
		companyElement.sendKeys(company);	
		
		isElementPresent = companyElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + companyElement.getAttribute("name") +" : "+ company);
			
		//Wpisz rolę QA
		Select roleDropdown = new Select (driver.findElement(By.id(roleLocator)));		//select z pola dropdown
		roleDropdown.selectByVisibleText("QA");			
			
		//Wpisz oczekiwania - development checkbox
		Select jobExpectation = new Select (driver.findElement(By.id(jobExpectationLocator)));		//select przesuwnego pola wielokrotnego wyboru
		jobExpectation.selectByVisibleText("High salary");			
		jobExpectation.selectByVisibleText("Good teamwork");	
			
		//Sposoby rozwoju
		WebElement techConsCheckbox = driver.findElement(By.xpath(techConsCheckboxLocator));
		techConsCheckbox.click();
			
		//Wpisz comment
		WebElement commentElement = driver.findElement(By.id(commentLocator));
		commentElement.clear();
		commentElement.sendKeys(comment);	
		
		isElementPresent = commentElement.isEnabled();
		System.out.println("Element enabled: " + isElementPresent + "\n" + commentElement.getAttribute("name") +" : "+ comment);
			
		//Wyślij
		WebElement submit = driver.findElement(By.id(submitLocator));
		submit.click();
			
		//Sprawdź, czy użytkownik dodany
		WebElement submitMessage = driver.findElement(By.id("submit-msg"));
		String result = submitMessage.getText();
		assertEquals("Successfully submitted!", result); //sprawdzanie, czy dobry wynik formularza
	}

	@After
	public void tearDown() throws Exception { //zamknij przeglądarkę
		driver.close();
	}
} 

