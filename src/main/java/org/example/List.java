package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

public class List {  // Detta är en klass som jag gjorde för att kunna
                    // få fram inkomst och utgift lista samtidigt
    private Map<String, User> list;
    private String filNamn = "src/main/java/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void läsaFil() throws IOException { // Denna metoden läser in filen
          Type type = new TypeToken<Map<String, User>>(){}.getType();
          Reader reader = new FileReader(new File(filNamn));
          list = gson.fromJson(reader, type);
          reader.close();
      }
      public void listaFÖrInkomstOchUtgift() throws IOException { // Denna metoden hämtar lista
        läsaFil();                                                // för både income och expense
        System.out.println("Lista för din inkomst och utgift");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange ditt förnamn:");
        String förNamn = scanner.next();

        if (list.containsKey(förNamn)) {
            User user = list.get(förNamn);
            System.out.println("Inkomstlista och Utgiftlista för " + user.getFörNamn() + " " + user.getEfterNamn());
            System.out.println();
            System.out.println("Inkomst: " + user.getInkomst());
            System.out.println();
            System.out.println("Utgift: " + user.getUtgifter());
        } else {
            System.out.println("Användaren finns inte i listan.");
        }
    }
}

