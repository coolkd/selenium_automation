package com.kuldeep.Udemy_Course;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cosec {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://ess.infibeam-inc.ooo/COSEC/login.aspx");
        driver.findElement(By.id("txtLoginID")).sendKeys("IIL0721");
        driver.findElement(By.id("txtPassword")).sendKeys("kdcool12");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("rpt1_Btn1_1")).click();
        driver.findElement(By.id("rpt1_rpt2_1_Btn1_0")).click();
        
        driver.switchTo().frame("filter");
        
        WebElement table = driver.findElement(By.id("grdDetail"));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        
        WebElement tbody = table.findElement(By.tagName("tbody"));
        
        List<WebElement>trList = tbody.findElements(By.className("gridrowstyle"));
        
        for(WebElement tr: trList ) {
        	List<WebElement> tdList = tr.findElements(By.tagName("td"));
        	WebElement dateElementg=tdList.get(0);
        	String textDate = dateElementg.getText();
        	
        		//System.out.println(tdList.get(2).getText());
        	
        	if(date.equals(textDate)) {
        		String inTime = tdList.get(2).getText();

        		String str =tdList.get(2).getText();
		    	   
		    float c=Float.parseFloat(str);
		      
		    float Exceedout= 7;
		    
		    float out=c+Exceedout;
		    System.out.println("out time = " + out);
        		
        		System.out.println("I Entered in "+c);
        		//excepted out time
        		//intime+7 hours
        		//intime string ,intime integar convert , 7
        		
        		System.out.println(c);
        		
        
        		//System.out.println("I Logged out by "+tdList.get(3).getText());
        	}
        	
        	
        		
        	}
        	
        	
	}
}




