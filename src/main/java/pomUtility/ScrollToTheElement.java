package pomUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToTheElement {
	
public static void scrollIntoView(WebElement Element, WebDriver driver) {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;	
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
	}
}
