package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch_POM {

	WebDriver driver; 
	
	@FindBy(xpath="//textarea[@title='Search']")
	private WebElement searchBar;
	
	@FindBy(xpath="(//input[@value='Google Search'])[2] ")
	private WebElement searchButton;
	
	public GoogleSearch_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, null);
		
	}
	
	public void sendDataInSearchBar(String searchData) {
		searchBar.click();
		searchBar.sendKeys(searchData);
	}
	
	public void pressSearchButton() {
		searchButton.click();
	}
}
