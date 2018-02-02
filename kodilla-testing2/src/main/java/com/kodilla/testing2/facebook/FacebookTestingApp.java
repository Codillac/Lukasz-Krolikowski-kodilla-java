package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_WAIT_FOR = "//*[@id=\"u_0_10\"]/div[2]";
    public static final String XPATH_SELECT_DAY = "//*[@id=\"day\"]";
    public static final String XPATH_SELECT_MONTH = "//*[@id=\"month\"]";
    public static final String XPATH_SELECT_YEAR = "//*[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selector = new Select(selectCombo);
        selector.selectByValue("8");
        selectCombo = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        selector = new Select(selectCombo);
        selector.selectByValue("6");
        selectCombo = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        selector = new Select(selectCombo);
        selector.selectByValue("1983");
    }
}
