package io.codepen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartGameTest {
	
		@Test
		public void StartGame () {
			//Create driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			//Navigate to codepen
			String url = "https://codepen.io/jshlfts32/full/bjambP/";
			driver.get(url);
			
			//Send number to game
			driver.switchTo().frame(driver.findElement(By.id("result")));
			WebElement inputField = driver.findElement(By.id("number"));
			inputField.sendKeys("2");
			
			//Press play to start game
			WebElement playButton = driver.findElement(By.id("start"));
			playButton.click();
			
			//Check for double board bug
			
			WebElement table = driver.findElement(By.id("table"));
			String oneClickTableSize = table.getSize().toString();
			System.out.println(oneClickTableSize);
			
			playButton.click();
			String twoClickTableSize = table.getSize().toString();
			System.out.println(twoClickTableSize);
			Assert.assertTrue(oneClickTableSize.contains(twoClickTableSize), "Expected: " + oneClickTableSize + " but got: " + twoClickTableSize);
			
			//table is visible
			//If the id "1" is not found, the table isn't visible
			WebElement tableRow = driver.findElement(By.id("1"));
			//Assert.assertTrue(tableRow.isDisplayed(), "Table is not visible");
			
			//close browser
			driver.quit();
		}
}
