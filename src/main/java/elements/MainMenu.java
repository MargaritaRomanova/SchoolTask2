package elements;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Элемент главного меню
 */
public class MainMenu {

    private WebDriver driver;

    // Поиск элементов без аннотации
    private WebElement newTicketBtn;

    // todo: остальные элементы меню
    private WebElement logInBtn;
    private WebElement homepageBtn;
    private WebElement allTicketsBtn;
    private WebElement searchTicket;
    private WebElement searchBtn;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        newTicketBtn = driver.findElement(By.xpath("//*[contains(text(), 'New Ticket')]/parent::*"));
        if (!loginIsVisible()) {
            allTicketsBtn = driver.findElement(By.xpath("//*[contains(text(), 'All Tickets')]/parent::*"));
            searchTicket = driver.findElement(By.xpath("//input[@id='search_query']"));
            searchBtn = driver.findElement(By.xpath("//*[@class='fas fa-search']/parent::*"));
        } else {
            homepageBtn = driver.findElement(By.xpath("//*[contains(text(), 'Homepage')]/parent::*"));
            logInBtn = driver.findElement(By.xpath("//*[contains(text(), 'Log In')]/parent::*"));
        }
    }

    private boolean loginIsVisible() {
        try {
            WebElement logInBtn = driver.findElement(By.xpath("//*[contains(text(), 'Log In')]/parent::*"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void newTicket() {
        // todo: нажать кнопку создания нового тикета
        newTicketBtn.click();
    }

    public void logIn() {
        // todo: нажать кнопку авторизации
        logInBtn.click();
    }

    public void homepage() {
        homepageBtn.click();
    }

    public void allTickets() {
        allTicketsBtn.click();
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */
    public MainMenu setSearch(String text) {
        // todo: ввести значение в поле поиска
        searchTicket.sendKeys(text);
        return this;
    }

    public void search() {
        // todo: нажать кнопку поиска
        searchBtn.click();
    }
}
