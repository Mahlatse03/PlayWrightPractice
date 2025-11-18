package aBasics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class launchBrowser {
    @Test
    public void launchChromium(){
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.ndosiautomation.co.za/");
            page.fill("#login-email", "md@gmail.com");
            page.fill("#login-password", "emd12345");
            //page.click;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
