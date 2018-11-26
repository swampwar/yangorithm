package tumblrFetcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Worker {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String hostId = "dochalschool";
		String url = "https://" + hostId + ".tumblr.com/archive";
		String url2 = "https://www.tumblr.com";
		
		String phantomJSPath = "C:\\Users\\user\\git\\yangorithm\\yangorithm\\src\\tumblrFetcher\\phantomjs.exe";
		System.setProperty("phantomjs.binary.path", phantomJSPath);
		
		WebDriver driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		Thread.sleep(5000);
		
		System.out.println("Page title is: " + driver.getTitle());
		System.out.println(driver.getPageSource());
//		
//		String hostId = "dochalschool";
//		String url = "https://" + hostId + ".tumblr.com/archive";
//		
//		Connection conn = Jsoup.connect(url);
//		try {
//			Document doc = conn.get();
//			
//			Elements aTagElements = doc.getElementsByTag("a");
//			Elements validATagElements = new Elements();
//			
//			for(Element eachE : aTagElements) {
//				if(eachE.attr("href").startsWith("https://")) {
//					validATagElements.add(eachE);
//				}
//			}
//			
//			for(Element eachE : validATagElements) {
//				System.out.println(eachE.attr("href"));
//			
//			}
//			
//		
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
	
	
	}

}
