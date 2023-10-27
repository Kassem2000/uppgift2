package org.example;

public class Transaction {
    private double Belopp;
    private String datum;

    public Transaction(double belopp, String datum) {
        this.Belopp = belopp;
        this.datum = datum;
    }

    public double getBelopp() {
        return Belopp;
    }

    public void setBelopp(double belopp) {
        Belopp = belopp;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Belopp=" + Belopp +
                ", datum=" + datum +
                '}';
    }
}
