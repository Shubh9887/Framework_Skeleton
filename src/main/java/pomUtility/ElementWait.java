package pomUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementWait {

	public static void scrollIntoView(String elementLocation,int waitTime, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementLocation)));
	}
}
