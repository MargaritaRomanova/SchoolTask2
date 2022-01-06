package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница со списком тикетов
 */
public class TicketsPage extends HelpdeskBasePage {

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Ищем строку с тикетом и нажимаем на нее
     */

    @Step("Выбор и открытие тикета")
    public void openTicket(Ticket ticket) {
        WebElement findTicket = driver.findElement(By.xpath("//a[contains(text(),'" + ticket.getTitle() + "')]"));
        findTicket.click();
        saveScreenshot(driver);
    }
}
