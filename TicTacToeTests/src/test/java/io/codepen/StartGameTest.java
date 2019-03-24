package io.codepen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
			//Press play to start game
			
		}
}
