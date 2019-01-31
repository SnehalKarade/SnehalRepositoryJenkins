import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {
	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\SnehalKrade113\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://labs.abeautifulsite.net/archived/jquery-multiSelect/demo/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement mutiselect = driver.findElement(By.id("control_6"));
	
	Select objMultiselect = new Select(mutiselect);
	
	objMultiselect.selectByIndex(1);
	objMultiselect.selectByValue("option_3");
	objMultiselect.selectByVisibleText("Option 2");
	
	List<WebElement> selectedOptions = objMultiselect.getAllSelectedOptions();
	
	int size = selectedOptions.size();
	System.out.println(size);
	
	for(int i = 0;i<size;i++) {
		
		System.out.println("Selected option "+i+" : " +selectedOptions.get(i).getText());
	}
	
	objMultiselect.deselectAll();
	
	driver.close();
}

}
