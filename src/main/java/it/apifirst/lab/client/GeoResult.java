package it.apifirst.lab.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GeoResult {

    @JsonProperty
    int countries;

    @JsonProperty List<String> names;

    public GeoResult(int countries, List<String> names) {
        this.countries = countries;
        this.names = names;
    }

    public int getCountries() {
        return countries;
    }

    public List<String> getNames() {
        return names;
    }
}
