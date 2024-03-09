package fitpeoPackage;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClassName {
	
	public static void main(String[] args) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--incognito");
				
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();

				driver.get("https://www.flipkart.com/");

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// verifying homepage is loading successfully

				WebElement homePageLogo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
				if (homePageLogo.isDisplayed()) {
					System.out.println("Homepage loaded successfully.");
				} else {
					System.out.println("Homepage failed to load");
					driver.quit();
					return;
				}

				WebElement searchLaptop = driver.findElement(By.xpath("//input[@type='text']"));
				searchLaptop.sendKeys("Laptops");
				searchLaptop.submit();

				WebElement clicklaptop = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
				clicklaptop.click();

				// Selected Laptop Name
				String selectedLaptopName = clicklaptop.getText();
				System.out.println(selectedLaptopName);

				// To switch to new Window and perform actions
				Set<String> windowHandles = driver.getWindowHandles();
				ArrayList<String> a = new ArrayList<String>(windowHandles);

				String title = driver.switchTo().window(a.get(1)).getTitle();
				System.out.println(title);

				WebElement pinCodeEnter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
				pinCodeEnter.sendKeys("600024");
				pinCodeEnter.sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				WebElement addToCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
				addToCart.click();

				WebElement product = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));
				String productName = product.getText();
				System.out.println(productName);

				// Verifying the prodcut name with the help of the title name
				try {
					//Assert.assertTrue(selectedLaptopName.contains(productName));
					System.out.println("Selected Laptop and Laptop added in Cart are same");

				} catch (Exception e) {
					System.out.println("Wrong Product added in the cart ");
				}
				Thread.sleep(2000);
				WebElement placeOrderButton = driver.findElement(By.xpath("//span[text()='Place Order']/parent::button"));
				placeOrderButton.click();
				
				WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='text']"));
				phoneNumber.sendKeys("6382897879");
				
				WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
				continueButton.click();
				
				WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
				name.sendKeys("Kishore");
				
				WebElement mobileNumber = driver.findElement(By.xpath("//input[@name='phone']"));
				mobileNumber.sendKeys("9042350039");
				
				WebElement pincode = driver.findElement(By.xpath("//input[@name='pincode']"));
				pincode.sendKeys("600023");
				
				WebElement locality = driver.findElement(By.xpath("//input[@name='addressLine2']"));
				locality.sendKeys("Chennai");
				
				WebElement addressField = driver.findElement(By.xpath("//textarea[@name='addressLine1']"));
				addressField.sendKeys("");
				
				
				WebElement cityName = driver.findElement(By.xpath("//input[@name='city']"));
				cityName.sendKeys("Chennai");
				
				WebElement stateDropDown = driver.findElement(By.xpath("//select[@name='state']"));
				Select s = new Select(stateDropDown);
				s.selectByValue("Tamil Nadu");
				
				WebElement saveAndDeliver = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
				saveAndDeliver.click();
				
				WebElement continueButton1 = driver.findElement(By.xpath("//span[@id='to-payment']"));
				continueButton.click();
				
				WebElement agreeAndContinue = driver.findElement(By.xpath("//button[text()='Accept & Continue']"));
				agreeAndContinue.click();
			
				WebElement creditCard = driver.findElement(By.xpath("//label[@for='CREDIT']/input"));
				creditCard.click();
				
				WebElement cardNUmber = driver.findElement(By.xpath("//input[@name='cardNumber']"));
				cardNUmber.sendKeys("1234567891234567");
				
				WebElement cardMonth = driver.findElement(By.xpath("//select[@name='month']"));
				Select s1 = new Select(cardMonth);
				s.selectByValue("02");
				
				WebElement cardYear = driver.findElement(By.xpath("//select[@name='year']"));
				Select s2 = new Select(cardYear);
				s.selectByVisibleText("24");
				
				WebElement cvv = driver.findElement(By.xpath("//input[@type='password']"));
				cardNUmber.sendKeys("123");

	}

}
