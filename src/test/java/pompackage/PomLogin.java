package pompackage;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLogin extends BaseClass {
@FindBy(name="username")	
	WebElement Username;
@FindBy(name= "password")
WebElement Password;
@FindBy(xpath=" /html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
WebElement Loginbtn;
public PomLogin() {
	PageFactory.initElements(driver,this);
}
public void typeusername(String name) {
	Username.sendKeys(name);
	
}
public void typepassword(String pass) {
	Password.sendKeys(pass);
}
public void clickbutton() {
	Loginbtn.click();
}
public String verify() {
	return driver.getTitle();
}
}


