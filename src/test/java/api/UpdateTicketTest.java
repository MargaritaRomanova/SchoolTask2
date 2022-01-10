package api;

import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        Ticket ticket = buildNewTicket(Status.CLOSED, 5);
        Ticket ticketReturnData = createTicket(ticket);
        ticketReturnData.setStatus(Status.OPEN.getCode());
        updateTicketNegative(ticketReturnData);
    }

    private void updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        given()
                .body(ticket)
                .when()
                .put("api/tickets//" + ticket.getId())
                .then().log().all()
                .statusCode(200);
    }
}
