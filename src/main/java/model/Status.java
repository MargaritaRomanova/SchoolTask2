package model;

/**
 * Статусы тикета, используемые в тестах
 */
public enum Status {
    STATUS0(0),
    OPEN(1),
    STATUS2(2),
    STATUS3(3),
    CLOSED(4),
    STATUS5(5);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
