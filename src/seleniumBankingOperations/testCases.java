package seleniumBankingOperations;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases extends parameters {

	@BeforeTest
	public void beforeTest() {
		driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
	}

	@Test()
	public void loginAndAddCustomer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement bankManagerLogIn = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
		bankManagerLogIn.click();
		WebElement addCustomerButton = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']"));
		addCustomerButton.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		firstName.sendKeys(customersFirstNames[indexnum1]);
		lastName.sendKeys(customersLastNames[indexnum2]);
		WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
		postCodeElement.sendKeys(customersPostCodes[indexnum3]);
		Thread.sleep(2000);
		try {
			WebElement addButton = driver.findElement(By.cssSelector("button[type='submit']"));
			addButton.click();
			handleAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	@Test()
	public void openAccount() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement openAccountButton = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']"));
		openAccountButton.click();
		Thread.sleep(2000);
		WebElement customerName = driver.findElement(By.id("userSelect"));
		Select select = new Select(customerName);
		select.selectByIndex(6);
		WebElement currencyElement = driver.findElement(By.id("currency"));

		Select sele = new Select(currencyElement);
		sele.selectByIndex(randomNum);
		Thread.sleep(2000);
		try {
			WebElement theProcessButton = driver.findElement(By.cssSelector("button[type='submit']"));
			theProcessButton.click();
			handleAlert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void removeTheCustomer() throws InterruptedException {
		WebElement customersButton = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']"));
		customersButton.click();
		Thread.sleep(2000);
		WebElement deleteButton = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[5]/button[1]"));
		deleteButton.click();

	}

	@AfterTest
	public void postTest() {
	}

	private void handleAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Message: " + alert.getText());
			alert.accept();
		} catch (Exception e) {

		}
	}

}
