package Saucedemo1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	@Test(dataProvider = "dataset")
	public void data(String username,String password) {
		System.out.println(username+"  "+password);
	}
	@DataProvider
	public Object[][] dataset() {
		return new Object[][]
				{
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"},
			
				};
	}
}
