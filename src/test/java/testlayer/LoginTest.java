package testlayer;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;


public class LoginTest extends BaseClass{
	
		PomLogin Log;
		public LoginTest() {
			super();
		}
		@BeforeMethod
		public void initialsetup() throws InterruptedException {
			initation();
			screenshots("Login");
			
			 Log= new PomLogin();
		}
	@Test(priority=1)
	public void Title() {
	String b=	Log.verify();
	System.out.println(b);
		Assert.assertEquals(b,"OrangeHRM");
		
		
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
		
	}
	@Test(priority=2,dataProvider="Details")
	public void Login(String name, String password)  {
		Log.typeusername(name);
		
		Log.typepassword(password);
		
		//Log.clickbutton();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

	}



