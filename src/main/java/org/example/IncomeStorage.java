package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

public class IncomeStorage {
    private Map<String, User> income;
    private String filNamn = "src/main/java/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public IncomeStorage() {

    }
    public void sparaFil() throws IOException { // Denna metoden sparar filer
        FileWriter fw = new FileWriter(new File(filNamn));
        gson.toJson(income, fw);
        fw.close();
        System.out.println("Filen sparad");
    }
    public void läsaFil() throws IOException{ // Denna metoden läser filer
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        Reader reader = new FileReader(new File(filNamn));
        income = gson.fromJson(reader, type);
        reader.close();
    }
    public void moneyLeft() throws IOException { // Denna metoden ser till att du kan se hur mycket pengar du har kvar
        läsaFil();
        System.out.println("Kvar i kontot ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ditt förnamn: ");
        String förnamn = scanner.next();

        if (income.containsKey(förnamn)) {
            User user = income.get(förnamn);
            double totalIncome = user.getInkomst().getBelopp();
            double totalExpense = user.getUtgifter().getBelopp();
            double moneyLeft = totalIncome - totalExpense;

            System.out.println("Kvar i kontot: " + moneyLeft + " kr");
            sparaFil();
            } else {
                System.out.println("Användaren finns inte i systemet.");
        }
    }
     public void läggTillInkomst() throws IOException { // Denna metoden gör att du kan lägga till inkomst
        läsaFil();
        System.out.println("Lägg till inkomst");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn: ");
        String förnamn = scanner.next();

        if (income.containsKey(förnamn)) {
            System.out.println("Ange din inkomst: ");
            double skrivInkomst = scanner.nextDouble();

            System.out.println("Välj kategori för inkomsten ([1]LÖN,[2]BIDRAG,[3]ARV,[4]ÖVRIGT):");
            int enumInkomst = scanner.nextInt();

            System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
            String date = scanner.next();

            User user = income.get(förnamn);
            Income inkomst = user.getInkomst();
            inkomst.setBelopp(skrivInkomst);
            inkomst.setDatum(date);
            inkomst.setInkomstKategori(enumInkomst);

            System.out.println("Inkomst tillagd.");
            sparaFil();
        } else {
            System.out.println("Användaren finns inte i systemet.");
        }
    }
    public void uppdateraInkomst() throws IOException { // Här uppdateras inkomsten
        läsaFil();
        System.out.println("Uppdatera inkomst");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ditt förnamn: ");
        String förnamn = scanner.next();

        if (income.containsKey(förnamn)) {
            System.out.print("Ange din nya inkomst: ");
            double nyInkomst = scanner.nextDouble();

            System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
            String date = scanner.next();

            User user = income.get(förnamn);
            Income inkomst = user.getInkomst();
            inkomst.setBelopp(nyInkomst);
            inkomst.setDatum(date);

            System.out.println("Inkomst uppdaterad.");
            sparaFil();
        } else {
            System.out.println("Användaren finns inte i systemet.");
        }
    }
    public void taBortInkomst() throws IOException { // Denna metoden gör att du kan ta bort din inkomst
            läsaFil();
            System.out.println("Ta bort inkomst");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ditt förnamn för att ta bort inkomst: ");
            String förNamn = scanner.next();

           if (income.containsKey(förNamn)) {
               System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
               String date = scanner.next();

               User user = income.get(förNamn);
               Income inkomst = user.getInkomst();
               inkomst.setBelopp(0.0);
               inkomst.setDatum(date);

               System.out.println("Inkomsten har tagits bort från användaren");
               sparaFil();
           } else {
               System.out.println("Användaren finns inte i listan.");
           }
       }
       public void inkomstLista() throws IOException { //Denna metoden gör att om ditt namn finns med
        läsaFil();                                     // i systemet så kan du se lista över dina inkosmter
        System.out.println("Lista för din inkomst");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn:");
        String förNamn = scanner.next();

        if (income.containsKey(förNamn)) {
            User user = income.get(förNamn);
            System.out.println("Inkomstlista för " + user.getFörNamn() + " " + user.getEfterNamn());
            System.out.println();
            System.out.println("Inkomst: " + user.getInkomst());
        } else {
            System.out.println("Användaren finns inte i listan.");
        }
    }
}