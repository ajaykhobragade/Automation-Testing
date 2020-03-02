import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Test1_Headless {

    @Test
    public static void main(String[] args) throws InterruptedException, IOException {

        //<editor-fold desc="Get Headless Chrome driver">
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver=new ChromeDriver(options);

        /*driver.manage().window().setPosition(new Point(2000, 1));
        driver.manage().window().fullscreen();
        driver.manage().window().setPosition(new Point(2000, 1)); // To 2nd monitor.  Useful for finding buttons hidden on small screen.
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(globalTimeout, TimeUnit.SECONDS);*/
        //</editor-fold>

        //<editor-fold desc="Get Safari">
        /*System.setProperty("webdriver.safari.driver", "SafariDriver.safariextz");
        WebDriver driver=new SafariDriver();*/

        //</editor-fold>

        //<editor-fold desc="Get IE driver">
         /*System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
         WebDriver driver = new InternetExplorer();*/

         //</editor-fold>

        //<editor-fold desc="Get URL">
        //driver.get("https://users.startribune.com/admin");
        //driver.get("https://stage.www.startribune.com/admin");
        driver.get("https://stage-users.startribune.com/admin");

        //</editor-fold>

        //<editor-fold desc="User logged in with credentials">
        //driver.findElement(By.id("username")).clear();
        //driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("ajay.khobragade@startribune.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("mystrib123");

        driver.findElement(By.cssSelector("input[class=\"btn login-btn track-link\"]")).click(); //user clicks on login button
        WebDriverWait waitloginChrome = new WebDriverWait(driver, 3);
        //</editor-fold>

        System.out.println(driver.getTitle());

        //<editor-fold desc="TakeScreenshot">

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(source, new File("./Screenshots/Screen.png")); //this will create folder & file with in project folder
        FileUtils.copyFile(source, new File("/Users/khobraj/Documents/Screenshots/Screen.png")); //this will create new image in directory mentioned
        //FileUtils.copyFile(SrcFile, DestFile); //use this if you want to copy file in different location, specify SrcFile, DestFile directory location
        System.out.println("the Screenshot is taken");

        //</editor-fold>

        //<editor-fold desc="Actions under Placements">
        driver.findElement(By.linkText("Placements")).click();
        driver.findElement(By.cssSelector("a[class=\"btn btn-primary btn-xs\"]")).click(); //user click on View button
        driver.findElement(By.cssSelector("a[class=\"btn btn-warning\"]")).click(); //user click on Edit button

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); //scroll page all the way at bottom of page
        //Thread.sleep(3000);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("button[class=\"btn btn-default\"]")));
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0,500);");
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\", inline: \"nearest\"});", driver.findElement(By.cssSelector("button[class=\"btn btn-default\"]")));
        //driver.findElement(By.cssSelector("button[class=\"btn btn-default\"]")).click(); //user click on Cancel button
        driver.findElement(By.name("cancel")).click(); //user click on Cancel button
        Thread.sleep(3000);

        driver.findElement(By.linkText("Placement")).click();
        driver.findElement(By.cssSelector("a[class=\"btn btn-warning btn-xs\"]")).click(); //user click on Edit button
        driver.findElement(By.linkText("Placements")).click();
        driver.findElement(By.cssSelector("a[class=\"btn btn-success\"]")).click(); //user click on Create button
        //driver.findElement(By.cssSelector("button[class=\"btn btn-default\"]")).click(); //user click on Cancel button (found bug, system asks value for Display name field)
        driver.findElement(By.linkText("Placements")).click();
        driver.findElement(By.linkText("Home")).click();

        //</editor-fold>

        System.out.println(driver.getTitle());

        //<editor-fold desc="User clicked on links under Meter Section & returns Home">

        driver.findElement(By.linkText("Environments")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Flow groups")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Offer groups")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Flow errors")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Workflows")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("Home")).click();
        System.out.println(driver.getTitle());
        //</editor-fold>

        //driver.findElement(By.linkText(" Logout")).click(); //user will logout and returns to homepage

        System.out.println(driver.getTitle());

        //driver.quit();
        //driver.close();

    }

}
