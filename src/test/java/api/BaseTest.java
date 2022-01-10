package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import model.Status;
import model.Ticket;
import model.TicketData;
import org.testng.annotations.BeforeClass;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import static io.restassured.RestAssured.given;

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
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными
        Ticket ticket = new Ticket();
        ticket.setStatus(status.getCode());
        ticket.setTitle(UUID.randomUUID().toString());
        ticket.setQueue(1);
        ticket.setPriority(priority);
        ticket.setAssigned_to(null);
        ticket.setCreated(new Date().toString());
        ticket.setDue_date(new Date().toString());
        ticket.setKbitem(null);
        ticket.setDescription("");
        ticket.setMerged_to(null);
        ticket.setModified(new Date().toString());
        ticket.setOn_hold(false);
        ticket.setResolution("");
        ticket.setSecret_key("");
        ticket.setSubmitter_email("sdfghj@yandex.ru");
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
