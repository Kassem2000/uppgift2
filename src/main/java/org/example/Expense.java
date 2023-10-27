package org.example;

public class Expense extends Transaction {
    private EExpenseCategory utgiftKategori;

    public Expense(double belopp, String datum, int utgiftkategori) {
        super(belopp, datum);
        setUtgiftKategori(utgiftkategori);
    }

    /*public EExpenseCategory getUtgiftKategori() {  // Denna kan tas bort om inget ändras i koden
        return utgiftKategori;
    }*/

    public void setUtgiftKategori(int utgiftKategori) {
        switch (utgiftKategori) {
            case 1:
                this.utgiftKategori = EExpenseCategory.HYRA;
                break;
            case 2:
                this.utgiftKategori = EExpenseCategory.EL;
                break;
            case 3:
                this.utgiftKategori = EExpenseCategory.MAT;
                break;
            case 4:
                this.utgiftKategori = EExpenseCategory.NÖJE;
                break;
            default:
                this.utgiftKategori = EExpenseCategory.ÖVRIGT;
                break;
        }
    }
    @Override
    public String toString() {
        return "Expense{" +
                "utgiftKategori=" + utgiftKategori +
                ", belopp=" +
                "} " + super.toString();
    }
}


