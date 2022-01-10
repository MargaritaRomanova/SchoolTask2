package api;

import model.Status;
import model.Ticket;
import model.TicketData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Создание и проверка тикета
 */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        // todo: создать тикет и проверить, что он находится в системе
        Ticket ticket = buildNewTicket(Status.OPEN, 5);
        TicketData ticketData = createTicket(ticket);
        getTicket(ticketData.id);
    }

    protected TicketData getTicket(int id) {
        // todo: отправить HTTP запрос на получение тикета по его id
        TicketData ticketData = given()
                .when()
                .get("api/tickets//" + id)
                .then().log().all()
                .statusCode(200)
                .extract().as(TicketData.class);
        return ticketData;
    }
}
