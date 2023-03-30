package fr.codeworks;

import java.time.LocalDateTime;

public class StubClock implements Clock {

    LocalDateTime date;
    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
