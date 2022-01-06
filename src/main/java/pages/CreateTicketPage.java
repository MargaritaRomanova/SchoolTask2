package pages;

import io.qameta.allure.Step;
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
    @Step("Cоздание тикета")
    public void createTicket(Ticket ticket) {
        fillProblemTitle(ticket.getTitle());
        fillQueue(ticket.getQueue());
        fillDescription(ticket.getDescription());
        fillEMailAddress(ticket.getEMailAddress());
        fillPriority(ticket.getPriority());
        createTicket();
        saveScreenshot(driver);
    }

    /**
     * Заполнение поля "Summary of the problem"
     */
    @Step("Заполнение поля 'Summary of the problem'")
    public void fillProblemTitle(String text) {
        inputProblemTitle.sendKeys(text);
        saveScreenshot(driver);
    }

    @Step("Заполнение поля 'Queue'")
    public void fillQueue(String text) {
        inputQueue.sendKeys(text);
        saveScreenshot(driver);
    }

    @Step("Заполнение поля 'Description of your issue'")
    public void fillDescription(String text) {
        inputDescription.sendKeys(text);
        saveScreenshot(driver);
    }

    @Step("Заполнение поля 'Priority'")
    public void fillPriority(String value) {
        Select selectObject = new Select(inputPrioritySelect);
        selectObject.selectByValue(value);
        saveScreenshot(driver);
    }

    @Step("Заполнение поля 'Your E-Mail Address'")
    public void fillEMailAddress(String text) {
        inputEMailAddressTitle.sendKeys(text);
        saveScreenshot(driver);
    }

    /**
     * Зажатие кнопки "Submit Ticket"
     */

    @Step("Нажатие кнопки 'Submit Ticket'")
    public void createTicket() {
        submitTicketButton.click();
        saveScreenshot(driver);
    }
}
