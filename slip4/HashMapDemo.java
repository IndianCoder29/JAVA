// import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Create a HashMap to store city names and their STD codes
        Map<String, String> cityCodes = new HashMap<String, String>();

        // Add a new city and its code
        cityCodes.put("Pune", "4123");
        cityCodes.put("New York", "212");
        cityCodes.put("Los Angeles", "213");
        cityCodes.put("Chicago", "312");
        System.out.println("After adding cities: " + cityCodes);
        // Remove a city from the collection
        cityCodes.remove("Chicago");
        System.out.println("After removing Chicago: " + cityCodes);
        // Search for a city name and display the code
        String cityName = "New York";
        String code = cityCodes.get(cityName);
        if (code != null) {
            System.out.println("The STD code for " + cityName + " is " + code +
                    ".");
        } else {
            System.out.println("No STD code found for " + cityName + ".");
        }
    }
}
