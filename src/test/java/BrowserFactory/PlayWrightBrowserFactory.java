package BrowserFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.Properties;

public class PlayWrightBrowserFactory {

    private Page page;
    Browser browser;
    Properties prop;

    public void initBrowser(Properties prop) {
        String browserName = prop.getProperty("browsers").trim();
        Playwright playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            case "weblit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser type: "+ browserName);
        }

    }

}
