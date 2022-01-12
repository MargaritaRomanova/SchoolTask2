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

    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement inputProblemTitle;

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
        PageFactory.initElements(driver, this);
    }

    /**
     * Создание тикета
     */
    public void createTicket(Ticket ticket) {
        fillProblemTitle(ticket.getTitle());
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
        inputProblemTitle.sendKeys(text);
    }

    public void fillQueue(String text) {
        inputQueue.sendKeys(text);
    }

    public void fillDescription(String text) {
        inputDescription.sendKeys(text);
    }

    public void fillPriority(String value) {
        Select selectObject = new Select(inputPrioritySelect);
        selectObject.selectByValue(value);
    }

    public void fillEMailAddress(String text) {
        inputEMailAddressTitle.sendKeys(text);
    }

    /**
     * Зажатие кнопки "Submit Ticket"
     */
    public void createTicket() {
        submitTicketButton.click();
    }
}
