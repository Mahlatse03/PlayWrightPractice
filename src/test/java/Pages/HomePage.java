package Pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;
    private String welcomeText = "h2:has-text('Welcome back')";
    private String learningMaterialLocator = "button:has-text('Learning Materials')";

    public HomePage(Page page){
        this.page = page;
    }
    public boolean verifyUserIsLoggedIn(){
        return page.isVisible("button:has-text('Logout')");

    }

    public HomePage clickLearningMaterials(){
        page.click((learningMaterialLocator));
        return new HomePage(page);
    }
}
