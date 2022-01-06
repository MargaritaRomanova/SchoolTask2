package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница отдельного тикета
 */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "//thead[@class='thead-light']//ancestor::h3")
    private WebElement ticketTitle;

    @FindBy(xpath = "//th[text()='Submitter E-Mail']")
    private WebElement email;

    @FindBy(xpath = "//td[@id='ticket-description']//ancestor::p")
    private WebElement description;

    @FindBy(xpath = "//thead[@class='thead-light']//th")
    private WebElement queue;

    @FindBy(xpath = "//th[text()='Priority']//following-sibling::td[1]")
    private WebElement priority;

    @FindBy(xpath = "//button[contains(@class, 'danger btn')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(text(), 'Yes I Understand - Delete It Anyway')]")
    private WebElement agreeBtn;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Получить имя тикета
     */

    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    /**
     * Получить адрес почты
     */
    public String getEmail() {
        return getValue(email);
    }

    public String getDescription() {
        return description.getText();
    }

    public String getQueue() {
        return queue.getText();
    }

    public String getPriority() {
        return priority.getText();
    }

    /**
     * Получить значение элемента таблицы
     *
     * @param columnElem элемент ячейки для которой нужно вернуть значение
     * @return текстовое значение ячейки рядом
     */
    private String getValue(WebElement columnElem) {
        return columnElem
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::td[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }

    @Step("Удаление созданного тикета")
    public void deleteTicket() {
        deleteBtn.click();
        agreeBtn.click();
        saveScreenshot(driver);
    }
}
