package fr.codeworks;

import java.time.LocalDateTime;

public class SystemClock implements Clock{
    @Override
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }
}
