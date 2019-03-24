package io.codepen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
			inputField.sendKeys("3");
			//Press play to start game
			WebElement playButton = driver.findElement(By.id("start"));
			playButton.click();
			
		}
}
