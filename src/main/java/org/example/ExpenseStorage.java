package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

public class ExpenseStorage {
    private Map<String, User> expense;
    private String filNamn = "src/main/java/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

   public ExpenseStorage() {

   }
   public void sparaFil() throws IOException { // Denna metoden sparar fil
        FileWriter fw = new FileWriter(new File(filNamn));
        gson.toJson(expense, fw);
        fw.close();
        System.out.println("Filen sparad");
    }
    public void läsaFil() throws IOException { // Denna metoden läser in fil
       Type type = new TypeToken<Map<String, User>>(){}.getType();
        Reader reader = new FileReader(new File(filNamn));
        expense = gson.fromJson(reader, type);
        reader.close();
    }
    public void läggTillUtgift() throws IOException { // Denna metoden gör att du lägger till utgift
        läsaFil();
        System.out.println("Lägg till utgifter");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn: ");
        String förnamn = scanner.next();

        if (expense.containsKey(förnamn)) {
            System.out.println("Ange din utgift: ");
            double skrivUtgift = scanner.nextDouble();

            System.out.println("Välj kategori för din utgift ([1]Hyra,[2]El,[3]Mat,[4]Nöje,[5]Övrigt):");
            int enumUtgift = scanner.nextInt();

            System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
            String date = scanner.next();

            User user = expense.get(förnamn);
            Expense utgift = user.getUtgifter();
            utgift.setBelopp(skrivUtgift);
            utgift.setDatum(date);
            utgift.setUtgiftKategori(enumUtgift);

            System.out.println("Utgift tilllagd.");
            sparaFil();
        } else {
            System.out.println("Användaren finns inte i systemet.");
        }
    }
    public void uppdateraUtgift() throws IOException { // Den metoden gör att utigiften uppdateras
        läsaFil();
        System.out.println("Uppdatera dina utgifter");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ditt förnamn: ");
        String förnamn = scanner.next();

        if (expense.containsKey(förnamn)) {
            System.out.print("Ange din nya utgift: ");
            double nyUtgift = scanner.nextDouble();

            System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
            String date = scanner.next();

            User user = expense.get(förnamn);
            Expense utgift = user.getUtgifter();
            utgift.setBelopp(nyUtgift);
            utgift.setDatum(date);

            System.out.println("Utgift uppdaterad.");
            sparaFil();
        } else {
            System.out.println("Användaren finns inte i systemet.");
        }
    }
    public void taBortUtgift() throws IOException { // Denna metoden tar bort din utgift
        läsaFil();
        System.out.println("Ta bort utgifter");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn: ");
        String förNamn = scanner.next();

        if (expense.containsKey(förNamn)) {
            System.out.println("Ange datum, skriv in datum såhär: 2023/10/27 ");
            String date = scanner.next();

            User user = expense.get(förNamn);
            Expense utgift = user.getUtgifter();
            utgift.setBelopp(0.0);
            utgift.setDatum(date);

            System.out.println("Utgiften har tagits bort");
            sparaFil();
        } else {
            System.out.println("Användaren finns inte i listan.");
        }
    }
    public void listaFörUtgifter() throws IOException {  // Denna metoden gör att om ditt namn finns med
        läsaFil();                                      // i systemet så kan du se lista över din utgift
        System.out.println("Lista för dina utgifter");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn:");
        String förNamn = scanner.next();

        if (expense.containsKey(förNamn)) {
            User user = expense.get(förNamn);
            System.out.println("Utgiftlista för " + user.getFörNamn() + " " + user.getEfterNamn());
            System.out.println();
            System.out.println("Utgift: " + user.getUtgifter());
        } else {
            System.out.println("Användaren finns inte i listan.");
        }
    }
}
