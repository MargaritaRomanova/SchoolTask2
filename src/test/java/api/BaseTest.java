package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Status;
import model.Ticket;
import model.TicketData;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.UUID;

import static net.serenitybdd.rest.RestRequests.given;

/**
 * Абстрактный класс, содержащий общие для всех тестов методы
 */
public abstract class BaseTest {

    @BeforeClass
    public void prepare() throws IOException {
        // todo: загрузить в системные переменные "base.uri" из "config.properties"
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));

        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        // todo: подготовить глобальные преднастройки для запросов
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .addHeader("demo", System.getProperty("password"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными
        Ticket ticket = new Ticket();
        ticket.setStatus(status);
        ticket.setTitle(UUID.randomUUID().toString());
        ticket.setQueue(1);
        ticket.setPriority(priority);
        return ticket;
    }

    protected TicketData createTicket(Ticket ticket) throws ExceptionInInitializerError {
        // todo: отправить HTTP запрос для создания тикета
        TicketData ticketData = given()
                .body(ticket)
                .when()
                .post("api/tickets/")
                .then().log().all()
                .statusCode(201)
                .extract().as(TicketData.class);
        return ticketData;
    }
}
