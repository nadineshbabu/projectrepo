package pack;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class reuasablefunction {

	WebDriver driver;

	public void openbrowser() {

		try {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void login(String username, String password){
		try{
			driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void scroll(String element ){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try{
			WebElement findElement = driver.findElement(By.xpath("(//div[@class='NqIFxw'])[10]"));			
			jse.executeScript("arguments[0].scrollIntoView(true);", findElement);
			mouseOver(element);
			click(element);
			Thread.sleep(5000);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void logout(String element){
		try{
			driver.findElement(By.xpath("//span[@class='_2cyQi_']")).click();
			driver.findElement(By.xpath("(//div[@class='_2k0gmP'])[1]")).click();
			scroll(element);
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void closebrowser() {

		try {

			driver.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String getTitle() {
		String title=null;
		try {

			 title = driver.getTitle();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return title;
	}

	public void enterUrL(String URL) {

		try {

			driver.get(URL);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void navigate(String URL){
		
		driver.navigate().to(URL);
	}



	public void click(String Object) {

		try {

			driver.findElement(By.xpath(Object)).click();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String Getext(String Object) {
		String value = null;
		try {

			value = driver.findElement(By.xpath(Object)).getText();

		} catch (Exception e) {
			e.getMessage();
		}

		return value;
	}


	public void comparetest(String Expected, String Actual) {
		try {

			if(Expected.equals(Actual)){

				System.out.println("Expected value is "+Expected +"  Actual value is "+Actual +" Test case PASS");
			}else{
				System.out.println("Expected value is "+Expected +"  Actual value is "+Actual +" Test case FAIL");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String EditSetvalue(String Object, String value) {
		try {

			driver.findElement(By.xpath(Object)).clear();
			driver.findElement(By.xpath(Object)).sendKeys(value);

		} catch (Exception e) {
			e.getMessage();
		}
		return value;
	}

	public  void test(){

		try{

			//getscreenshot("Homepage");

			getAllLinks("//a");


			mouseOver(".//*[@id='nav-link-yourAccount']");
			click(".//*[@id='nav-flyout-yourAccount']/div[3]/a[1]/span");
			click(".//*[@id='nav-your-amazon']");
			System.out.println("");
			EditSetvalue(".//*[@id='ap_email']", "jklskldn");
			click(".//*[@id='continue']");
			String Actual = Getext(".//*[@id='auth-error-message-box']/div/div/ul/li/span")	;	

			comparetest("We cannot find an account with that email address", Actual);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void selectDDvalue(String Object ,String VisibleText ){
		try{

			WebElement webelement = driver.findElement(By.xpath(Object));
			Select se = new Select(webelement);
			se.selectByVisibleText(VisibleText);


		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public void mouseOver(String Object  ){
		try{
			WebElement webelement = driver.findElement(By.xpath(Object));

			Actions act = new Actions(driver);

			act.moveToElement(webelement).build().perform();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public void getAllLinks(String Object  ){
		try{
			List<WebElement> list = driver.findElements(By.xpath(Object));

			for(int i=0; i<=list.size();i++){
				System.out.println(list.get(i).getText());
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public  boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public String gerWindowhandel(){

		String windowHandle = driver.getWindowHandle();

		return windowHandle;
	}

	public void switchintoFrame(int frameID){

		driver.switchTo().frame(frameID);
	}

	public void switchintoDefaultCont(int frameID){

		driver.switchTo().defaultContent();
	}
	
	public void getscreenshot() 
    {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
		try {
			FileUtils.copyFile(src, new File("C:/selenium/error.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	

}
