package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import com.amazon.steps.select;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
//import net.serenitybdd.screenplay.ui.Select;

public class AmazonLogin extends PageObject{

	public WebDriver driver;
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	public WebElementFacade signin;
	
	@FindBy(xpath= "//*[@id='ap_email']")
	public WebElementFacade username;
	
	@FindBy(xpath= "//*[contains(@class, 'a-button-input')]")
	public WebElementFacade button;
	
	@FindBy(xpath="//*[@id='ap_password']")
	public WebElementFacade password;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	public WebElementFacade submitbttn;
	
	@FindBy(xpath="//*[contains(@class, 'nav-cart-icon')]")
	public WebElementFacade cart;
	
	@FindBy(xpath="//*[@id=\"select-all\"]")
	public WebElementFacade items;
	
	@FindBy(xpath="//*[@id=\"sc-item-Cc3afb8df-45b2-4c56-bad2-104be67d4f2e\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[1]/span/span[1]/span/span/span/span")
	public WebElementFacade ddrop;
	
	@FindBy (tagName="li")
	public List<WebElementFacade> list;
	
	@FindBy(xpath="//*[@id=\"sc-buy-box-gift-checkbox\"]")
	public WebElementFacade chkBox;
	
	//@FindBy(xpath="/html/body/div[1]/div[2]/div[3]/div[4]/div/div[1]/div[1]/div/form/div/div[3]/div[1]/span[2]/span")
	@FindBy(id="sc-subtotal-amount-buybox")
	public WebElementFacade subtotal;
	@FindBy(xpath="//*[@name='proceedToRetailCheckout']")
	public WebElementFacade Checkoutbttn;
	
	public void signin()
	{
		signin.click();
	}
	public void enterUsername(String email )
	{
		username.sendKeys(email);
	}
	public void button()
	{
		button.click();
	}
	public void enterPassword(String pass )
	{
		password.sendKeys(pass);
	}
	public void submitbttn()
	{
		submitbttn.click();
	}
	public void cart() {
		cart.waitUntilClickable().click();
		 
	}
	public void items() {
		items.click();
	}
	public void  ddrop() {
		ddrop.click();}
		public void clickOnquantity(){	
		for(WebElement option:list) {
			if(option.getText().equals("3")) {
				option.click();
				break;
			}
		}
	}
		public void chkBox() {
			chkBox.waitUntilClickable().click();
		}
		public String subTotal() {
			 return subtotal.getText();
		}
		
	public void Checkoutbttn() {
		Checkoutbttn.click();
	}
	public <WebElement> void list() {
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equals("3")) {
				list.get(i).click();
			}
		}
	}
}
