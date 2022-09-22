package com.amazon.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Base64;
import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.amazon.datafolder.propertiesFilereader;
import com.amazon.pages.AmazonHomepage;
import com.amazon.pages.AmazonLogin;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class StepDefinitions extends PageObject{
	//public static WebDriver driver;
	propertiesFilereader r;
	

@Steps	

AmazonLogin al;
Statement stmt;
Connection c=null;
AmazonHomepage hl;
	@Before 
	
	public void Setup() {
		 r= new propertiesFilereader();
		 System.out.println(r.getEmail());
		 System.out.println(r.getPassword());
	
		 
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "Idontknow@123");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully"); 
	}
	
	
	@Given("user on the login page")
	public void user_on_the_login_page() {
	  getDriver().navigate().to("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_ya_signin%26adgrpid%3D64607481971%26hvpone%3D%26hvptwo%3D%26hvadid%3D486382354470%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D13382594918929822363%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301812%26hvtargid%3Dkwd-297775402051%26hydadcr%3D5650_2175716%26gclid%3DCj0KCQjwn4qWBhCvARIsAFNAMih81zhd4_i8FxfwhyPVkdfsB3sLTqEaJYGNIBAZ2HKYbW1_3DCl5rcaAitmEALw_wcB&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	   //al= new AmazonLogin() ;
	  getDriver().manage().window().maximize();
	}
	

	@When("user enters id")
	public void user_enters_id() throws InterruptedException, SQLException {
		stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM USERNAME;" );
        while ( rs.next() ) {
           String  name = rs.getString("userid");
           al.enterUsername(name);
        }
	  //al.enterUsername(email);
		/*String decryptdata=r.getEmail();
        byte[] decodebytes=Base64.getDecoder().decode(decryptdata.getBytes());
        al.enterUsername(new String(decodebytes));*/
	    Thread.sleep(3000);
	}
	

	@When("click on continue")
	public void click_on_continue() {
		al.button();
		
	}

	
	@When("enter password")
	public void enter_password() throws InterruptedException {
		//al.enterPassword(pass); 
	   String decryptdata=r.getPassword();
       byte[] decodebytes=Base64.getDecoder().decode(decryptdata.getBytes());
       al.enterPassword(new String(decodebytes));
	   Thread.sleep(3000);
	}

	@Then("click on sign in")
	public void click_on_sign_in() {
		Actions act=new Actions(getDriver());
		act.moveToElement(al.submitbttn);
	    al.submitbttn();
	}
	
	@Then("user should be on homepage")
	public void user_should_be_on_homepage() throws InterruptedException {
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle;
		actualTitle =getDriver().getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		System.out.println("Title is-" +actualTitle);
		Assert.assertTrue(actualTitle.contains("Amazon"));
		System.out.println("Page title is verified");
		Thread.sleep(3000);
	}
	@Given("user should be logged in")
	public void user_should_be_logged_in() {
		
	}

	@When("user clicks on cart button")
	public void user_clicks_on_cart_button() {
	   al.cart();
	   System.out.println("Explicit time defined for the test(in seconds) "+getWaitForTimeout().toSeconds());
	   JavascriptExecutor js = (JavascriptExecutor) getDriver();
	   js.executeScript("window.scrollBy(0,200)", "");
	   System.out.println("Scrolled down successfully");	  
	}

	@When("user clicks on select all items")
	public void user_clicks_on_select_all_items() throws InterruptedException {
	  al.items();  
	  Thread.sleep(3000);	
	}
	
	@When("user clicks on dropdown button")
	public void user_clicks_on_dropdown_button() {
		al.ddrop();
	}
	
	@When("user selects quantity")
	public void user_selects_quantity() throws InterruptedException {
	  al.clickOnquantity();
	  JavascriptExecutor js = (JavascriptExecutor) getDriver();
	  js.executeScript("window.scrollBy(0,-200)", "");
	  Thread.sleep(2000);
	}
	
	@When("user verify the cart amount")
	public void user_verify_the_cart_amount() {
		String expectedText="   13,688.30";
		String actualText;
		actualText =al.subTotal();
        Assert.assertEquals(expectedText,actualText);
		System.out.println("Cart amount is verified");
        
	}

	@Then("user clicks on proceed to buy")
	public void user_clicks_on_proceed_to_buy() {
	    al.Checkoutbttn();
		 getDriver().navigate().forward();
		 getDriver().navigate().back();
		 getDriver().navigate().refresh();
	}
	
	@Given("user on the homepage")
	public void user_on_the_homepage() {
		 getDriver().navigate().to("https://www.amazon.in/ref=nav_logo");
		 
	}
	@When("user clicks on All button")
	public void user_clicks_on_all_button() {
		WebElement category_dropdown=getDriver().findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));

		Select category=new Select(category_dropdown);

		 category.selectByVisibleText("Electronics");
		/*Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
      fluentWait.until(ExpectedConditions.elementToBeSelected(hl.dropDown_menu));*/	
	   // hl.selectDropDownValues();
	}

	@And("user serach for {string} product")
	public void user_serach_for_product(String string) {
	    hl.enterProductname(string);
	}

	@Then("user clicks on searchbutton")
	public void user_clicks_on_searchbutton() throws InterruptedException {
	 hl.searchButton();
	 Thread.sleep(2000);
	 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	  js.executeScript("window.scrollBy(0,200)", "");
	}
	
	@Then("user clicks on the product")
	public void user_clicks_on_the_product() {
	    hl.dsrProduct();
	    hl.getWindowHandle();
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
		  js.executeScript("window.scrollBy(0,200)", "");
	}

}

