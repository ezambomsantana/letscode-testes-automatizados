package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {

    public static void main(String[] args) {
        new Main().execute();

    }

    public void execute() {

        System.setProperty("webdriver.chrome.driver",
                getClass().getClassLoader().getResource("chromedriver").getFile());

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textBox = driver.findElement(By.id("my-text-id"));
        textBox.sendKeys("Teste selenium");

        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("teste");

        Select select = new Select(driver.findElement(By.name("my-select")));
        select.selectByValue("2");

        WebElement range = driver.findElement(By.name("my-range"));
        range.sendKeys(Keys.RIGHT);
        range.sendKeys(Keys.RIGHT);
        range.sendKeys(Keys.RIGHT);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botao = driver.findElement(By.cssSelector("button"));
        botao.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement texto = driver.findElement(By.id("message"));
        System.out.println(texto.getText());

        driver.quit();
    }


}
