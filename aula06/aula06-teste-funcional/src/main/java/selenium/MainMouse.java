package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class MainMouse {

    public static void main(String[] args) {
        new MainMouse().execute();
    }

    private void execute() {


        System.setProperty("webdriver.chrome.driver",
                getClass().getClassLoader().getResource("chromedriver").getFile());


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

        WebElement clickable = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(1))
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("teste")
                .perform();

        WebElement text = driver.findElement(By.id("click-status"));
        String valor = text.getText();

        System.out.println(valor);



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();

    }
}
