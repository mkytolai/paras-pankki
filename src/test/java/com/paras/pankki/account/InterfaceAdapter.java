package com.paras.pankki.account;

import com.paras.pankki.customer.Customer;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;


public class InterfaceAdapter implements Adapter {

    private static final String TARGET = "http://127.0.0.1:8080";
    private static final String GECKODRIVERPATH = "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver";
    private WebDriver driver;

    public InterfaceAdapter() {
        ApplicationSupport.start();
    }

    @Override
    public void deposit(String customer, Integer balance, String currency) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Customer testCustomer = new Customer(customer);
        Balance testBalance = new Balance(balance, new Currency(currency));
        Transaction transaction = new Transaction(testCustomer, testBalance, Transaction.TransactionType.DEPOSIT);

        jerseyClient
                .target(TARGET)
                .path("account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(transaction));
    }

    @Override
    public Balance getBalance(String user) {


        //URL url = getClass().getResource("/geckodriver");
        //String geckoDriverPath = url.getFile();
        //System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        System.setProperty("webdriver.gecko.driver", GECKODRIVERPATH);

        driver = new FirefoxDriver();
        driver.get(TARGET);

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement balanceButton = driver.findElement(By.id("saldoButton"));
        //WebElement balanceArea = driver.findElement(By.id("balanceArea"));

        nameField.sendKeys(user);
        balanceButton.click();
        //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement balanceArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("balanceArea")));

        //System.out.println(balanceArea.getText());
        //HERE BE DRAGONS! string -> regex out non-numbers -> cast to Integer, assume EUR?
        Integer seenBalance = Integer.valueOf(balanceArea.getText().replaceAll("\\D+",""));

        driver.close();

        return new Balance(seenBalance, new Currency("EUR"));
    }

    @Override
    public void withdraw(String customer, Balance balance) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        Customer testCustomer = new Customer(customer);
        Transaction testTransaction = new Transaction(testCustomer, balance, Transaction.TransactionType.WITHDRAWAL);

        Response response = jerseyClient
                .target(TARGET)
                .path("account")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(testTransaction));

        if (response.getStatus() == 403) {
            String message = response.readEntity(String.class);
            throw new InsufficientFundsException(message);
        }
    }
}
