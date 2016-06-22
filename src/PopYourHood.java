import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class PopYourHood {
	private static FirefoxDriver driver;
	WebElement element;

	// Start at the home page for reddit for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}


	////////////////////////////////////////////////////////////////
	//////////////////////////USER STORY 1//////////////////////////
	////////////////////////////////////////////////////////////////

	/*
	 * As a user I want to be able to recognize a simple math expression
	 * so that when my brain no longer knows which symbols correspond to each action
	 * the computer can remind me which symbols stand for each operation
	 * @author Goot449
	 */


	//////////////////////////////////
	//Scenario 1
	//////////////////////////////////
	//Given that I am on the main page
	//When I type an math expression using the cross symbol
	//Then I see that it corresponds to the "plus" operation
	@Test
	public void testCrossSymbol() {
		driver.findElement(By.id("code_code")).sendKeys("4+4");
		driver.findElement(By.xpath("//input[@value='Compile' and @type='submit']")).click();
		String codeBlock = driver.findElement(By.xpath("//code")).getText();
		System.out.print(codeBlock);
		assertTrue(codeBlock.contains("opt_plus"));
	}

	//////////////////////////////////
	//Scenario 2
	//////////////////////////////////
	//Given that I am on the main page
	//When I type an math expression using the slash symbol
	//Then I see that it corresponds to the "divide" operation
	@Test
	public void testSlashSymbol() {
		driver.findElement(By.id("code_code")).sendKeys("4/4");
		driver.findElement(By.xpath("//input[@value='Compile' and @type='submit']")).click();
		String codeBlock = driver.findElement(By.xpath("//code")).getText();
		System.out.print(codeBlock);
		assertTrue(codeBlock.contains("opt_div"));
	}

	//////////////////////////////////
	//Scenario 3
	//////////////////////////////////
	//Given that I am on the main page
	//When I type an math expression using the Star symbol
	//Then I see that it corresponds to the "Multiplication" operation
	@Test
	public void testStarSymbol() {
		driver.findElement(By.id("code_code")).sendKeys("4*4");
		driver.findElement(By.xpath("//input[@value='Compile' and @type='submit']")).click();
		String codeBlock = driver.findElement(By.xpath("//code")).getText();
		System.out.print(codeBlock);
		assertTrue(codeBlock.contains("opt_mult"));
	}

	//////////////////////////////////
	//Scenario 4
	//////////////////////////////////
	//Given that I am on the main page
	//When I type an math expression using the dash symbol
	//Then I see that it corresponds to the "minus" operation
	@Test
	public void testDashSymbol() {
		driver.findElement(By.id("code_code")).sendKeys("4-4");
		driver.findElement(By.xpath("//input[@value='Compile' and @type='submit']")).click();
		String codeBlock = driver.findElement(By.xpath("//code")).getText();
		System.out.print(codeBlock);
		assertTrue(codeBlock.contains("opt_minus"));
	}

	////////////////////////////////////////////////////////////////
	//////////////////////////USER STORY 2//////////////////////////
	////////////////////////////////////////////////////////////////
	@After
	public void tearDown() throws Exception{
		driver.quit();
	}
}