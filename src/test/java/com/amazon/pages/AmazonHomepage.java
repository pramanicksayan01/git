package com.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AmazonHomepage extends PageObject{
	
	/*@FindBy(xpath="//*[@id=\"nav-search-dropdown-card\"]/div/div/i")
	public WebElementFacade dropDown_menu;*/
	
	@FindBy(xpath="//*[@id=\"searchDropdownDescription\"]")
	WebElementFacade all;
	
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")    
	WebElementFacade prName;
	
	@FindBy(id="nav-search-submit-button")
	
	public WebElementFacade srButton;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span")
    public WebElementFacade product;
	
	public void clickOn() {
		all.waitUntilClickable().click();
	}
	
	public void enterProductname(String pname )
	{
		prName.sendKeys(pname);
	}
	public void searchButton() {
		srButton.click();
	}
	public void dsrProduct() {
		product.click();
		
	}
	 public void getWindowHandle()
     {
   	 Set<String> ids = getDriver().getWindowHandles();
	    Iterator<String> it = ids.iterator();
	    String parentId = it.next();
	    String childId = it.next();
	    getDriver().switchTo().window(childId);
     }
}
