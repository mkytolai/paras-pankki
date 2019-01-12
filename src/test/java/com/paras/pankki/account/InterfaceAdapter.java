package com.paras.pankki.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InterfaceAdapter implements Adapter {

    private static final String TARGET = "http://127.0.0.1:8080";
    private static final String GECKODRIVERPATH = "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver";
    private WebDriver driver;

    public InterfaceAdapter() {
        ApplicationSupport.start();

        System.setProperty("webdriver.gecko.driver", GECKODRIVERPATH);
        driver = new FirefoxDriver();
        driver.get(TARGET);
    }

    @Override
    public void deposit(String customer, Integer balance, String currency) {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement amountField = driver.findElement(By.id("amount"));
        WebElement currencyField = driver.findElement(By.id("currency"));
        WebElement depositButton = driver.findElement(By.id("depositButton"));

        nameField.clear();
        amountField.clear();
        currencyField.clear();

        nameField.sendKeys(customer);
        amountField.sendKeys(balance.toString());
        currencyField.sendKeys(currency);

        depositButton.click();

    }

    @Override
    public Balance getBalance(String user) {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement balanceButton = driver.findElement(By.id("saldoButton"));

        nameField.clear();

        nameField.sendKeys(user);
        balanceButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement balanceArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("balanceArea")));

        //HERE BE DRAGONS! string -> regex out non-numbers -> cast to Integer, assume EUR?
        Integer seenBalance = Integer.valueOf(balanceArea.getText().replaceAll("\\D+", ""));

        return new Balance(seenBalance, new Currency("EUR"));
    }

    @Override
    public void withdraw(String customer, Balance balance) {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement amountField = driver.findElement(By.id("amount"));
        WebElement currencyField = driver.findElement(By.id("currency"));
        WebElement withdrawButton = driver.findElement(By.id("withdrawButton"));

        nameField.clear();
        amountField.clear();
        currencyField.clear();

        nameField.sendKeys(customer);
        amountField.sendKeys(balance.getBalance().toString());
        currencyField.sendKeys(balance.getCurrency().getCurrency());

        withdrawButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement balanceArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("balanceArea")));


        String parsedText = balanceArea.getText().substring(0, 10);

        if (parsedText.equals("Error: 403")) {
            //dont want error text(10 first), just the message
            @SuppressWarnings("StringOperationCanBeSimplified") String errorMessage = balanceArea.getText().substring(10, balanceArea.getText().length());
            throw new InsufficientFundsException(errorMessage);
        }

    }
    public static void stopBrowser(InterfaceAdapter a){
        a.driver.close();
    }
}
