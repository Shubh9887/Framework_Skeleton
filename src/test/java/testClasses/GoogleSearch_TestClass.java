package testClasses;
import org.testng.annotations.Test;

import pomClasses.GoogleSearch_POM;

public class GoogleSearch_TestClass extends BaseClass{

	GoogleSearch_POM search;
	
	@Test
	public void googleSearch() {
		search = new GoogleSearch_POM(driver);
		search.sendDataInSearchBar("Testing Framework");
		
		search.pressSearchButton();
	}
}
