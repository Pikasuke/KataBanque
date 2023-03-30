package fr.codeworks;

import java.math.BigDecimal;

public class Monney {

    private BigDecimal amount;
    private String devise;


    public Monney(BigDecimal amount) {
        this.amount = amount;
    }

    public Monney(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public void addMonney (Monney monney) {
        this.amount = this.amount.add(monney.amount);
    }

    public void plusMonney (double value) {
        this.amount = this.amount.add(BigDecimal.valueOf(value));
    }

    public BigDecimal substract(BigDecimal value) {
        this.amount = this.amount.subtract(value);
        return this.amount;
    }
    
}
