package web;

import models.Ticket;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        try {
            // Заполняем объект класс Ticket необходимыми тестовыми данными
            ticket = buildNewTicket();

            // todo: открыть главную страницу
            driver.get(System.getProperty("site.url"));

            // todo: создать объект главной страницы и выполнить шаги по созданию тикета
            new MainPage();
            HelpdeskBasePage helpdeskBasePage = new HelpdeskBasePage();
            helpdeskBasePage.mainMenu().newTicket();
            CreateTicketPage createTicketPage = new CreateTicketPage();
            createTicketPage.createTicket(ticket);

            // todo: перейти к странице авторизации и выполнить вход
            helpdeskBasePage.mainMenu().logIn();
            LoginPage loginPage = new LoginPage();
            loginPage.login(System.getProperty("user"), System.getProperty("password"));

            // todo: найти созданный тикет и проверить поля
            HelpdeskBasePage helpdeskBasePageAfterLogin = new HelpdeskBasePage();
            helpdeskBasePageAfterLogin.mainMenu().allTickets();
            helpdeskBasePageAfterLogin.mainMenu().searchTicket(ticket);
            TicketsPage ticketsPage = new TicketsPage();
            ticketsPage.openTicket(ticket);
            TicketPage ticketPage = new TicketPage();

            Assert.assertTrue(
                    ticketPage.getTicketTitle().contains(ticket.getTitle()),
                    "название тикета не совпадает");
            Assert.assertEquals(
                    ticketPage.getEmail(),
                    ticket.getEMailAddress(),
                    "E-mail тикета не совпадает");
            Assert.assertEquals(
                    ticketPage.getDescription(),
                    ticket.getDescription(),
                    "Описание тикета не совпадает");
            Assert.assertTrue(
                    ticketPage.getPriority().contains(ticket.getPriority()),
                    "Приоритет тикета не совпадает");
            Assert.assertTrue(
                    ticketPage.getQueue().contains("Queue: " + ticket.getQueue()),
                    "Queue тикета не совпадает");
        } finally {
            TicketPage ticketPage = new TicketPage();
            ticketPage.deleteTicket();
            // Закрываем текущее окно браузера
            driver.close();
        }
    }

    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle(RandomString.make(8));
        ticket.setDescription(RandomString.make(20));
        ticket.setEMailAddress(RandomString.make(10) + "@google.com");
        ticket.setQueue("Billing Queries");
        ticket.setPriority("2");
        return ticket;
    }

    @AfterTest
    public void close() {
        // Закрываем все окна браузера и освобождаем ресурсы
        driver.quit();
    }
}
