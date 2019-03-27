package io.codepen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WinGameTestP1 {

	@Test
	public void MakeFirstMove() {
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Navigate to codepen
		String url = "https://codepen.io/jshlfts32/full/bjambP/";
		driver.get(url);

		// Send number to game
		driver.switchTo().frame(driver.findElement(By.id("result")));
		WebElement inputField = driver.findElement(By.id("number"));
		inputField.sendKeys("3");

		// Press play to start game
		WebElement playButton = driver.findElement(By.id("start"));
		playButton.click();
		
		//Click to make first move
		WebElement middleTableSpace = driver.findElement(By.id("4"));
		middleTableSpace.click();
		
		//Player 2 turn
		WebElement tableSpace2 = driver.findElement(By.id("2"));
		tableSpace2.click();
		
		//Click to make second move
		WebElement tableSpace0 = driver.findElement(By.id("0"));
		tableSpace0.click();
		
		//Player 2 turn
		WebElement tableSpace3 = driver.findElement(By.id("3"));
		tableSpace3.click();
		
		//Click to make winning move
		WebElement tableSpace8 = driver.findElement(By.id("8"));
		tableSpace8.click();
		
		//Verifications
		
		//Verify winning message shows
		String expectedWinnerMessage = "Congratulations player X! You've won. Refresh to play again!";
		WebElement endgameDiv = driver.findElement(By.id("endgame"));
		String actualWinnerMessage = endgameDiv.getText();
		Assert.assertTrue(actualWinnerMessage.contains(expectedWinnerMessage), "Expected: " + expectedWinnerMessage + " but got: " + actualWinnerMessage);

		// close browser
		//driver.quit();
	}
}
