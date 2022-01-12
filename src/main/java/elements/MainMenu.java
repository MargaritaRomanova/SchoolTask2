package elements;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Элемент главного меню
 */
public class MainMenu {

    private WebDriver driver;

    private By newTicketBtn = By.xpath("//*[contains(text(), 'New Ticket')]/parent::*");
    private By logInBtn = By.xpath("//*[contains(text(), 'Log In')]/parent::*");
    private By allTicketsBtn = By.xpath("//*[contains(text(), 'All Tickets')]/parent::*");
    private By searchTicket = By.xpath("//input[@id='search_query']");
    private By searchBtn = By.xpath("//*[@class='fas fa-search']/parent::*");
    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void newTicket() {
        driver.findElement(newTicketBtn).click();
    }

    public void logIn() {
        driver.findElement(logInBtn).click();
    }

    public void allTickets() {
        driver.findElement(allTicketsBtn).click();
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */
    public MainMenu setSearch(String text) {
        driver.findElement(searchTicket).sendKeys(text);
        return this;
    }

    public void search() {
        driver.findElement(searchBtn).click();
    }
}
