package seleniumBankingOperations;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();
	String[] customersFirstNames = { "leen", "mohammad", "younis", "sora", "ahmad" };
	String[] customersLastNames = { "omar", "youssef", "ameer", "majd", "abedallah" };
	String[] customersPostCodes = { "123456789", "000054321", "199887654", "555544433", "987654002" };
	Random rand = new Random();
	int indexnum1 = rand.nextInt(customersFirstNames.length);
	int indexnum2 = rand.nextInt(customersLastNames.length);
	int indexnum3 = rand.nextInt(customersPostCodes.length);
	int randomNum = rand.nextInt(1, 3);

}
