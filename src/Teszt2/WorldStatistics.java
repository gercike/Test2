package Teszt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {
    String countriesFile = "/home/progmatic/Letöltések/orszagok.txt";
    String citiesFile = "/home/progmatic/Letöltések/varosok.txt";
    List<Country> countries = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        WorldStatistics main = new WorldStatistics();
        main.readFile(main.countriesFile, main.citiesFile);
//        System.out.println(main.countries);
//        System.out.println(main.countries.get(15));
//        System.out.println(main.countries.get(15).getRuralPopulation());
//        System.out.println(main.findCountryByISoCode("AUT")); //4. feladat
//        System.out.println(main.getCountriesOfContinent("Europe"));//5. feladat
//        System.out.println(main.getCitiesOfCountry("HUN"));//6. feladat
//        System.out.println(main.getAhmedCount());//7.feladat
//        System.out.println(main.getPopularFirstLetter());//8. feladat
//        System.out.println(main.lastIndependentCountry());//9. feladat
//        City testCity = new City("Subotica","YUG",100386);//10. feladat
//        System.out.println(testCity.getPopulationPercentage());//10. feladat
    }

    public String lastIndependentCountry() {
        int latestDate = 0;
        String latest = null;
        for (Country country : countries) {
            if (country.getDateOfIndependency() > latestDate) {
                latestDate = country.getDateOfIndependency();
                latest = country.getIsoCode();
            }
        }
        return latest;
    }

    public String getPopularFirstLetter() {
        HashMap<String, Integer> firstLetters = new HashMap<>();
        for (Country country : countries) {
            firstLetters.putIfAbsent(country.getIsoCode().substring(0, 1), 0);
            firstLetters.put(country.getIsoCode().substring(0, 1), firstLetters.get(country.getIsoCode().substring(0, 1)) + 1);
        }
        String mostPopular = null;
        int most = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : firstLetters.entrySet()) {
            if (stringIntegerEntry.getValue() > most) {
                most = stringIntegerEntry.getValue();
                mostPopular = stringIntegerEntry.getKey();
            }
        }
        return mostPopular;
    }

    public int getAhmedCount() {
        int counter = 0;
        for (Country country : countries) {
            if (country.getPresident().contains("Hamad") || country.getPresident().contains("Ahmed") || country.getPresident().contains("Ahmad")) {
                counter++;
            }
        }
        return counter;
    }

    public HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> cities = new HashSet<>();
        for (Country country : countries) {
            if (country.getIsoCode().equals(countryCode)) {
                for (City city : country.getCities()) {
                    cities.add(city.getCityName());
                }
            }
        }
        return cities;
    }

    public ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> countryCodes = new ArrayList<>();
        for (Country country : countries) {
            if (country.getContinent().equals(continentName)) {
                countryCodes.add(country.getIsoCode());
            }
        }
        return countryCodes;
    }

    public Country findCountryByISoCode(String isoCode) {
        Country result = countries.get(0);
        for (Country country : countries) {
            if (country.getIsoCode().equals(isoCode)) {
                result = country;
            }
        }
        return result;
    }

    public void readFile(String countriesFile, String citiesFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(countriesFile));
        while (s.hasNextLine()) {
            String[] row = s.nextLine().split(",", 8);
            countries.add(new Country(row[0], row[1], row[2], row[3], Double.parseDouble(row[4]), row[5], Integer.parseInt(row[6]), row[7], new ArrayList<>()));
        }
        ArrayList<City> cities = new ArrayList<>();
        Scanner sc = new Scanner(new File(citiesFile));
        while (sc.hasNextLine()) {
            String[] row = sc.nextLine().split(",");
            cities.add(new City(row[0], row[1], Integer.parseInt(row[2])));
        }
        for (City city : cities) {
            for (Country country : countries) {
                if (city.getIsoCode().equals(country.getIsoCode())) {
                    country.getCities().add(city);
                }
            }
        }
    }
}
