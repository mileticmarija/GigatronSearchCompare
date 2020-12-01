package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ComparePage {
    WebDriver driver;
    public ComparePage(WebDriver driver){
        this.driver=driver;
    }

    protected By compareBtn=By.cssSelector(".compare-group-items-footer.clear>a");
    protected By dijagonalaEkrana1 = By.cssSelector(".compare-table>tbody>tr:nth-child(1)>td:nth-child(1)>span:last-child");
    protected By dijagonalaEkrana2 = By.cssSelector(".compare-table>tbody>tr:nth-child(1)>td:nth-child(2)>span:last-child");
    protected By zadnjaKamera1=By.cssSelector(".compare-table>tbody>tr:nth-child(4)>td:nth-child(1)>span:last-child");
    protected By zadnjaKamera2=By.cssSelector(".compare-table>tbody>tr:nth-child(4)>td:nth-child(2)>span:last-child");
    protected By ramMem1=By.cssSelector(".compare-table>tbody>tr:nth-child(10)>td:nth-child(1)>span:last-child");
    protected By ramMem2=By.cssSelector(".compare-table>tbody>tr:nth-child(10)>td:nth-child(2)>span:last-child");
    protected By internaMem1=By.cssSelector(".compare-table>tbody>tr:nth-child(16)>td:nth-child(1)>span:last-child");
    protected By internaMem2=By.cssSelector(".compare-table>tbody>tr:nth-child(16)>td:nth-child(2)>span:last-child");
    protected By operativniSistem1=By.cssSelector(".compare-table>tbody>tr:nth-child(27)>td:nth-child(1)>span:last-child");
    protected By operativniSistem2=By.cssSelector(".compare-table>tbody>tr:nth-child(27)>td:nth-child(2)>span:last-child");
    protected By cena1=By.cssSelector(".compare-table>tbody>tr>td:nth-child(1)>div>div");
    protected By cena2=By.cssSelector(".compare-table>tbody>tr>td:nth-child(2)>div>div");




    public void checkPage(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    public void compare(){
        driver.findElement(compareBtn).click();

        String d1 = driver.findElement(dijagonalaEkrana1).getText();
        String d2 = driver.findElement(dijagonalaEkrana2).getText();
        if(!d1.equals(d2)){
            System.out.println("Razlika u dijagonali ekrana, D1: "+d1+" D2: "+d2);
        }

        String zk1 = driver.findElement(zadnjaKamera1).getText();
        String zk2 = driver.findElement(zadnjaKamera2).getText();
        if(!zk1.equals(zk2)){
            System.out.println("Razlika u zadnjoj kameri, ZK1: "+zk1+" ZK2: "+zk2);
        }

        String rm1 = driver.findElement(ramMem1).getText();
        String rm2 = driver.findElement(ramMem2).getText();
        if(!rm1.equals(rm2)){
            System.out.println("Razlika u RAM memoriji, RM1: "+rm1+" RM2: "+rm2);
        }

        String im1 = driver.findElement(internaMem1).getText();
        String im2 = driver.findElement(internaMem2).getText();
        if(!im1.equals(im2)){
            System.out.println("Razlika u internoj memoriji, IM1: "+im1+" IM2: "+im2);
        }

        String os1 = driver.findElement(operativniSistem1).getText();
        String os2 = driver.findElement(operativniSistem2).getText();
        if(!os1.equals(os2)){
            System.out.println("Razlika u operativnom sistemu, OS1: "+os1+" OS2: "+os2);
        }

        String c1 = driver.findElement(cena1).getText();
        String c2 = driver.findElement(cena2).getText();
        if(!c1.equals(c2)){
            System.out.println("Razlika u ceni, C1: "+c1+" C2: "+c2);
        }

    }
}
