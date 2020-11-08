package com.example.mycovidtracker.data;

import com.example.mycovidtracker.model.Countries;
import com.example.mycovidtracker.model.WorldStatistics;

import java.util.List;

public interface CountryListAsyncResponse {

    void processFinished(List<Countries> countriesArrayList);

}
