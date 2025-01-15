package com.example.demo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Thread;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver\\chromedriver-win64\\chromedriver.exe"); // 替換為你的 ChromeDriver 路徑
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testTitle() {
        driver.get("http://localhost:8899/cars"); 
        System.out.println(driver.getTitle());
        assertEquals("car list", driver.getTitle(), "網頁標題不正確");

    }
    
    @Test
    public void testSearchCar() throws InterruptedException {
        driver.get("http://localhost:8899/cars");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String keyword = "Toyota";
        for (char ch : keyword.toCharArray()) {
            searchBox.sendKeys(String.valueOf(ch));
            Thread.sleep(500); 
        }
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Toyota Camry']")));

        List<WebElement> cars = driver.findElements(By.className("car"));
        assertFalse(cars.isEmpty(), "搜尋結果為空");

        for (WebElement car : cars) {
            String carName = car.findElement(By.tagName("h3")).getText();
            assertTrue(carName.contains("Toyota"), "搜尋結果中包含非目標車輛：" + carName);
        }
    }

    
}
