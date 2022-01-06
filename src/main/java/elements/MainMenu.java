package elements;

import io.qameta.allure.Step;
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

    @Step("Нажатие кнопки 'New Ticket'")
    public void newTicket() {
        newTicketBtn.click();
    }

    @Step("Нажатие кнопки 'Log In'")
    public void logIn() {
        logInBtn.click();
    }

    @Step("Нажатие кнопки 'All Tickets'")
    public void allTickets() {
        allTicketsBtn.click();
    }

    @Step("Ввод названия тикета в поле поиска и нажатие кнопки поиск")
    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */

    private MainMenu setSearch(String text) {
        searchTicket.sendKeys(text);
        return this;
    }

    private void search() {
        searchBtn.click();
    }
}
