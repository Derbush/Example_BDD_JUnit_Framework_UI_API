package ProjectName.Tests.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TxtReader {

    public static void main(String[] args) {
        readTxt();
    }

  // This methods allows finds how many customers in each country we have
    public static void readTxt(){

        Map<String, List<Map<String,String>>> listOfCustomersInEachCoutry = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/evgeniyaderbush/IdeaProjects/Example_BDD_JUnit_Framework/src/test/resources/example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into name, surname, city, zipCode, SSN, county
                String[] parts = line.split(", ");
                String name = parts[0];
                String surname = parts[1];
                String city = parts[2];
                String zipCode = parts[3];
                String SSN = parts[4];
                String country = parts[5];

                if (!listOfCustomersInEachCoutry.containsKey(country)){
                    Map<String, String> customInfo = new HashMap<>();
                    customInfo.put("name", name);
                    customInfo.put("surname", surname);
                    customInfo.put("city", city);
                    customInfo.put("zipCode", zipCode);
                    customInfo.put("SSN", SSN);
                    List<Map<String,String>> listOfCustomers = new ArrayList<>();
                    listOfCustomers.add(customInfo);
                    listOfCustomersInEachCoutry.put(country, listOfCustomers);
                } else  {
                    List<Map<String,String>> listOfCustomers = listOfCustomersInEachCoutry.get(country);
                    Map<String, String> customInfo = new HashMap<>();
                    customInfo.put("name", name);
                    customInfo.put("surname", surname);
                    customInfo.put("city", city);
                    customInfo.put("zipCode", zipCode);
                    customInfo.put("SSN", SSN);
                    listOfCustomers.add(customInfo);

                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, List<Map<String, String>>> entry : listOfCustomersInEachCoutry.entrySet()) {

            System.out.println(entry +  ": " +entry.getValue().size());
        }

    }
}
