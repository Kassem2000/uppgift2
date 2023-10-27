import org.example.ExpenseStorage;
import org.example.IncomeStorage;
import org.example.List;
import java.io.IOException;
import java.util.Scanner;

public class BudgetTracker {
    public static void main(String[] args) throws IOException {
        IncomeStorage incomeStorage = new IncomeStorage();
        ExpenseStorage expenseStorage = new ExpenseStorage();
        List list = new List();

        boolean isRunning = true;
        while (isRunning) {          // Sålänge isRunning är true så kommer programmet börja om
            try {                   // Använder try så om användaren skriver något tokigt så ska programmet inte kracha
                boolean isRunning1 = true;
            while (isRunning1) {        // Samma sak här sålänge isRunning1 är true så kommer progammet att börja om
                Scanner scanner = new Scanner(System.in);
                System.out.println("Hej och välkommen till BudgetTracker");
                System.out.println("Välj ett av följande");
                System.out.println("1: Lista över inkomster och utgifter");
                System.out.println("2: Inkomst");
                System.out.println("3: Utgifter");
                System.out.println("4: Se hur mycket pengar du har kvar i kontot");
                System.out.println("Ange 1,2,3 eller 4");
                int choise = scanner.nextInt();

                switch (choise) {
                    case 1:
                        list.listaFÖrInkomstOchUtgift();    // Ropar på metoden
                        isRunning = false; // Här ska programmet stanna
                        isRunning1 = false; // Här ska programmet stanna
                        break;
                    case 2:
                        System.out.println("Vilka av följande alternativ du vill göra?");
                        System.out.println("1: Lista över bara inkomster");
                        System.out.println("2: Lägg till inkomst");
                        System.out.println("3: Uppdatera inkomst");
                        System.out.println("4: Ta bort inkomst");
                        int incomeChoise = scanner.nextInt();

                        if (incomeChoise == 1) {
                            incomeStorage.inkomstLista();  // Ropar på metoden
                        } else if (incomeChoise == 2) {
                            incomeStorage.läggTillInkomst();  // Ropar på metoden
                        } else if (incomeChoise == 3) {
                            incomeStorage.uppdateraInkomst();  // Ropar på metoden
                        } else if (incomeChoise == 4) {
                            incomeStorage.taBortInkomst();  // Ropar på metoden
                        } else {
                            System.out.println("Välj endast 1,2,3 eller 4");
                        }
                        isRunning = false;  // Här ska programmet stanna
                        isRunning1 = false;  // Här ska programmet stanna
                        break;
                    case 3:
                        System.out.println("Vilket av följande alternativ du vill göra?");
                        System.out.println("1: Lista över bara utgifter");
                        System.out.println("2: Lägg till utgift");
                        System.out.println("3: Uppdatera utgift");
                        System.out.println("4: Ta bort utgift");
                        int expenseChoise = scanner.nextInt();

                        if (expenseChoise == 1) {
                            expenseStorage.listaFörUtgifter();  // Ropar på metoden
                        } else if (expenseChoise == 2) {
                            expenseStorage.läggTillUtgift();  // Ropar på metoden
                        } else if (expenseChoise == 3) {
                            expenseStorage.uppdateraUtgift();  // Ropar på metoden
                        } else if (expenseChoise == 4) {
                            expenseStorage.taBortUtgift();  // Ropar på metoden
                        } else {
                            System.out.println("Välj endast 1,2,3 eller 4");
                        }
                        isRunning = false;  // Här ska programmet stanna
                        isRunning1 = false;  // Här ska programmet stanna
                        break;
                    case 4:
                        incomeStorage.moneyLeft(); // Ropar på metoden
                        isRunning = false;  // Här ska programmet stanna
                        isRunning1 = false;  // Här ska programmet stanna
                        break;
                    default:
                        System.out.println("Välj endast 1,2,3 eller 4");
                }
            }
            } catch (Exception e) {
                System.out.println("Du kan bara skriva siffror, försök igen");
            }
        }
    }
}




