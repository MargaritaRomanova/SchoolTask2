package pages;

import models.Ticket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Страница создания тикета
 */
public class CreateTicketPage extends HelpdeskBasePage {

    // Способ объявления элементы страницы, через аннотацию
    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement inputProblemTitle;

    // todo: остальные элементы

    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement inputQueue;

    @FindBy(xpath = "//textarea[@id='id_body']")
    private WebElement inputDescription;

    @FindBy(xpath = "//*[@id='id_priority']")
    private WebElement inputPrioritySelect;

    @FindBy(xpath = "//input[@id='id_submitter_email']")
    private WebElement inputEMailAddressTitle;

    @FindBy(xpath = "//button[contains(text(), 'Submit Ticket')]")
    private WebElement submitTicketButton;

    public CreateTicketPage() {
        // Необходимо инициализировать элементы класса, лучше всего это делать в конструкторе
        PageFactory.initElements(driver, this);
    }

    /**
     * Создание тикета
     */
    public void createTicket(Ticket ticket) {
        fillProblemTitle(ticket.getTitle());
        // todo: заполнение остальных полей
        fillQueue(ticket.getQueue());
        fillDescription(ticket.getDescription());
        fillEMailAddress(ticket.getEMailAddress());
        fillPriority(ticket.getPriority());
        createTicket();
    }

    /**
     * Заполнение поля "Summary of the problem"
     */
    public void fillProblemTitle(String text) {
        // todo: заполнить поле
        inputProblemTitle.sendKeys(text);
    }

    // todo: методы заполнения остальных полей

    public void fillQueue(String text) {
        // todo: заполнить поле
        inputQueue.sendKeys(text);
    }

    public void fillDescription(String text) {
        // todo: заполнить поле
        inputDescription.sendKeys(text);
    }

    public void fillPriority(String value) {
        // todo: заполнить поле
        Select selectObject = new Select(inputPrioritySelect);
        selectObject.selectByValue(value);
    }

    public void fillEMailAddress(String text) {
        // todo: заполнить поле
        inputEMailAddressTitle.sendKeys(text);
    }

    /**
     * Зажатие кнопки "Submit Ticket"
     */
    public void createTicket() {
        // todo: нажать кнопку создания задания
        submitTicketButton.click();
    }
}
