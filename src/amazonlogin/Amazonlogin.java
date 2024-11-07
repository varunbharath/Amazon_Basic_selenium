package amazonlogin;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Amazonlogin {
	
	
	public void takeScreenshot(WebDriver driver) {
	
		 long timestamp = Instant.now().toEpochMilli(); // Get current timestamp
		
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
	String   path1	="C:\\Users\\kumar\\OneDrive\\Documents\\New folder_screenshot\\"+ timestamp +"_screenshot.png";
	Path sourcePath = srcFile.toPath();
    Path destPath = Paths.get(path1);
		try {
			  Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("Screenshot captured: " + destPath.toAbsolutePath());
			System.out.println("Screenshot captured and saved");
			
			}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println("Screenshot capture - failed "+e.getMessage());
		}

		
	}




	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Amazonlogin obj= new Amazonlogin();
System.setProperty("webdriver.chrome.driver","C:\\Users\\kumar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe" );
WebDriver driver=new ChromeDriver();
//System.setProperty("webdriver.edge.driver", "C:\\Users\\kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//WebDriver driver=new EdgeDriver();
driver.get("https://www.amazon.in/");
driver.navigate().refresh();
obj.takeScreenshot(driver);


WebElement search= driver.findElement(By.xpath("//*[@placeholder=\"Search Amazon.in\"]"));
search.sendKeys("Iphone");
obj.takeScreenshot(driver);
WebElement searchclick=driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
searchclick.click();
obj.takeScreenshot(driver);
WebElement addtocart=driver.findElement(By.xpath(("//*[@id=\"a-autoid-1\"]")));
addtocart.click();
obj.takeScreenshot(driver);
;
WebElement Signin=driver.findElement(By.xpath("//*[@id='nav-xshop']/a[2]"));
Signin.click();

obj.takeScreenshot(driver);
WebElement Signup=driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]"));
Signup.click();

obj.takeScreenshot(driver);


WebElement Firstname=driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]"));
Firstname.sendKeys("Bharath");

obj.takeScreenshot(driver);
WebElement mobileno=driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]"));
mobileno.sendKeys("9876543998");

obj.takeScreenshot(driver);
WebElement Password=driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]"));
Password.sendKeys("12345677");

obj.takeScreenshot(driver);



driver.quit();
	}

}
