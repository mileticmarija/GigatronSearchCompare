package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.ComparePage;
import pom_classes.HomePage;
import pom_classes.SearchResultPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

@Listeners(allure.AllureListener.class)
public class CompareTests {

        WebDriver driver;
        String URL="https://gigatron.rs/";
        DriverManager driverManager;
        HomePage hp;
        SearchResultPage srp;
        ComparePage cp;

        @BeforeMethod
        @Parameters({"browser"})
        public void setUp(String browser){
            driverManager= DriverManagerFactory.getDriverManager(browser);
            driver=driverManager.qetWebDriver();
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Parameters({"data","item1","item2","url"})
        @Test
        public void comparePhones(String data, String item1,String item2,String url) throws InterruptedException {
            hp=new HomePage(driver);
            hp.searchForItem(data);

            srp=new SearchResultPage(driver);
            String checkTX=srp.getCheckTX();
            srp.checkPage(checkTX);
            srp.selectItems(item1,item2);
            srp.navigateToComparePage();

            cp=new ComparePage(driver);
            cp.checkPage(url);
            cp.compare();

        }


        @AfterMethod
        public void tearDown(){
            driverManager.quitDriver();
        }

}

