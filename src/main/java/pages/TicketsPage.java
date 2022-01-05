package pages;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница со списком тикетов
 */
public class TicketsPage extends HelpdeskBasePage {

    // todo: элементы страницы поиска тикетов

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Ищем строку с тикетом и нажимаем на нее
     */

    public void openTicket(Ticket ticket) {
        // todo: найти и открыть тикет
        WebElement findTicket = driver.findElement(By.xpath("//a[contains(text(),'" + ticket.getTitle() + "')]"));
        findTicket.click();
    }
}
