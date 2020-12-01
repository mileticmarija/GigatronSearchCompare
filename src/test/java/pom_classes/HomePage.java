package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    protected By acceptCookies = By.cssSelector(".btn.primary");
    protected By searchBox=By.cssSelector("#searchbox>div .search-container>input");
    protected By searchButton=By.cssSelector("#searchbox>div .search-icon>i");

    public void accCookies(){
        driver.findElement(acceptCookies).click();
    }

    public void enterSearchData(String data){
        driver.findElement(searchBox).sendKeys(data);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    public void searchForItem(String data){
        accCookies();
        enterSearchData(data);
        clickSearchButton();
    }


}
