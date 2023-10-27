package org.example;

public class Income extends Transaction {
    private ElncomeCategory inkomstKategori;

    public Income(double belopp, String datum, int inkomstKategori) {
        super(belopp, datum);
         setInkomstKategori(inkomstKategori);
    }
  /*  public ElncomeCategory getInkomstKategori() {    // Denna ska också bort om inte något ändras i koden
        return inkomstKategori;
    }*/
    public void setInkomstKategori(int inkomstKategori) {
        switch (inkomstKategori) {
            case 1:
                this.inkomstKategori = ElncomeCategory.LÖN;
                break;
            case 2:
                this.inkomstKategori = ElncomeCategory.BIDRAG;
                break;
            case 3:
                this.inkomstKategori = ElncomeCategory.ARV;
                break;
            default:
                this.inkomstKategori = ElncomeCategory.ÖVRIGT;
                break;
        }
    }
    @Override
    public String toString() {
        return "Income{" +
                "inkomstKategori=" + inkomstKategori +
                ", belopp=" +
                "} " + super.toString();
    }
}


