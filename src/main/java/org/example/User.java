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

   /* public void setFörNamn(String förNamn) { // Denna kan tas bort om inget ändras i koden
        this.förNamn = förNamn;
    }*/

    public String getEfterNamn() {
        return efterNamn;
    }

  /*  public void setEfterNamn(String efterNamn) {  // Denna kan tas bort om inget ändras i koden
        this.efterNamn = efterNamn;
    }*/

    public Expense getUtgifter() {
        return utgifter;
    }

  /*  public void setUtgifter(Expense utgifter) {  // Denna kan tas bort om inget ändras i koden
        this.utgifter = utgifter;
    }*/

    public Income getInkomst() {
        return inkomst;
    }

   /* public void setInkomst(Income inkomst) {  // Denna kan tas bort om inget ändras i koden
        this.inkomst = inkomst;
    }*/

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

