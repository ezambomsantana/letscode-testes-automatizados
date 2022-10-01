package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainGoogle {

    public static void main(String[] args) {
        new MainGoogle().execute();
    }

    public void execute() {

        System.setProperty("webdriver.chrome.driver",
                getClass().getClassLoader().getResource("chromedriver").getFile());

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("lets code");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botao = driver.findElement(By.name("btnK"));
        botao.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();


    }
}
