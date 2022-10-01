package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainMouse2 {

    public static void main(String[] args) {
        new MainMouse2().execute();
    }

    private void execute() {


        System.setProperty("webdriver.chrome.driver",
                getClass().getClassLoader().getResource("chromedriver").getFile());


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

        WebElement clickable = driver.findElement(By.id("draggable"));
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(1))
                .clickAndHold()
                .pause(Duration.ofSeconds(1))
                .moveToElement(driver.findElement(By.id("droppable")))
                .pause(Duration.ofSeconds(10))
                .release()
                .perform();

        WebElement texto = driver.findElement(By.id("drop-status"));
        System.out.println(texto.getText());





        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();

    }
}
