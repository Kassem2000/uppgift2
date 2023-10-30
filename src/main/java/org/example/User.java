package org.example;

public class User {
    private String förNamn;
    private String efterNamn;
    private Income inkomst;
    private Expense utgifter;

   public User(String förNamn, String efterNamn, Income inkomst, Expense utgifter) {
        this.förNamn = förNamn;
        this.efterNamn = efterNamn;
        this.inkomst = inkomst;
        this.utgifter = utgifter;
    }

    public String getFörNamn() {
        return förNamn;
    }


    public String getEfterNamn() {
        return efterNamn;
    }

    public Expense getUtgifter() {
        return utgifter;
    }

    public Income getInkomst() {
        return inkomst;
    }

    @Override
    public String toString() {
        return "User{" +
                "förNamn='" + förNamn + '\'' +
                ", efterNamn='" + efterNamn + '\'' +
                ", inkomst=" + inkomst +
                ", utgifter=" + utgifter +
                '}';
    }
}

