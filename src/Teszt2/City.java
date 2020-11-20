package Teszt2;

import java.io.FileNotFoundException;

public class City {
    private String cityName;
    private String isoCode;
    private int cityPopulation;

    public City(String cityName, String isoCode, int cityPopulation) {
        this.cityName = cityName;
        this.isoCode = isoCode;
        this.cityPopulation = cityPopulation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    @Override
    public String toString() {
        return cityName + " " + isoCode + " " + cityPopulation;
    }

    public double getPopulationPercentage() throws FileNotFoundException {
        double percentage = -1;
        if (cityPopulation == 0) {
            return percentage;
        }
        WorldStatistics worldStatistics = new WorldStatistics();
        worldStatistics.readFile(worldStatistics.countriesFile, worldStatistics.citiesFile);
        for (Country country : worldStatistics.countries) {
            if (country.getIsoCode().equals(isoCode)) {
                if (country.getCountryPopulation() == 0) {
                    return percentage;
                } else {
                    percentage = 100 / (country.getCountryPopulation() / (double) cityPopulation);
                    break;
                }
            }
        }
        return percentage;
    }
}
