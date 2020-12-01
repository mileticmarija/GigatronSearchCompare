package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultPage {
    WebDriver driver;
    public SearchResultPage(WebDriver driver){
        this.driver=driver;
    }

    protected By compare=By.cssSelector(".compare-widget>div>a");
    protected By check=By.cssSelector(".col.col-12 .control-bar>h1");

    public String getCheckTX(){
        return driver.findElement(check).getText();
    }

    public void checkPage(String checkTX){
        Assert.assertEquals(driver.findElement(check).getText(),checkTX);
    }

    public void selectItems(String ... item) throws InterruptedException {

        for(int i=0;i<item.length;i++) {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".row.product-items-main.view-grid>div:nth-child("+item[i]+") .product-header>span")).click();
        }
    }

    public void navigateToComparePage(){
        driver.findElement(compare).click();
    }
}
