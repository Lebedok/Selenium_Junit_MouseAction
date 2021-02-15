package Selenium.mouseActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseClick {

    @Test

    public void test1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement abcTestLink = driver.findElement(By.linkText("A/B Testing"));

        Actions action = new Actions(driver);
        action.click(abcTestLink).perform();
    }


    @Test

    public void test2() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement contextMenuLink = driver.findElement(By.partialLinkText("Context Menu"));
        Actions actions = new Actions(driver);
        actions.click(contextMenuLink).perform();

        WebElement rectangle = driver.findElement(By.id("hot-spot"));
        actions.contextClick(rectangle).perform();


    }

    @Test
    // move slider to the right

    public void slideTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/");
        WebElement horizontalSliderLLink = driver.findElement(By.linkText("Horizontal Slider"));
        Actions actions = new Actions(driver);
        actions.click(horizontalSliderLLink).perform();

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();

    }


    @Test
    // move slider to the right

    public void hoversTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/");
        WebElement hoverLink = driver.findElement(By.linkText("Hovers"));
        Actions actions = new Actions(driver);
        actions.click(hoverLink).perform();

        WebElement avatar3 = driver.findElement(By.xpath("//h5[.=‘name: user3’]/../preceding-sibling::img"));
        actions.moveToElement(avatar3).perform();

        WebElement user3Name = driver.findElement(By.xpath("//h5[.=‘name: user3’]"));
        boolean isUser3Displayed = user3Name.isDisplayed();
        // verify user3 username is visible
        Assert.assertTrue(isUser3Displayed);


    }
}