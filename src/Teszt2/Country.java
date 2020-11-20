package Teszt2;

import java.util.ArrayList;

public class Country {
    private String isoCode;
    private String countryName;
    private String continent;
    private String region;
    private double area;
    private String dateOfIndependency;
    private int countryPopulation;
    private String president;
    private ArrayList<City> cities;

    public Country(String isoCode, String countryName, String continent, String region, double area, String dateOfIndependency, int countryPopulation, String president, ArrayList<City> cities) {
        this.isoCode = isoCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.area = area;
        this.dateOfIndependency = dateOfIndependency;
        this.countryPopulation = countryPopulation;
        this.president = president;
        this.cities = cities;
    }

    public Integer getDateOfIndependency() {
        if (dateOfIndependency.equals("NULL")) {
            return 0;
        }
        return Integer.parseInt(dateOfIndependency);
    }

    public void setDateOfIndependency(String dateOfIndependency) {
        this.dateOfIndependency = dateOfIndependency;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return countryName + " " + isoCode + " " + continent + " " + region + " " + area + " " + dateOfIndependency + " " + countryPopulation + " " + president + " " + cities + "\n";
    }

    public double getPopulationDensity() {
        if (countryPopulation == 0 || area == 0) {
            return -1;
        } else {
            return countryPopulation / area;
        }
    }

    public double getRuralPopulation() {
        int citiesPopulationSum = 0;
        for (City city : cities) {
            citiesPopulationSum += city.getCityPopulation();
        }
        return countryPopulation - citiesPopulationSum;
    }
}
