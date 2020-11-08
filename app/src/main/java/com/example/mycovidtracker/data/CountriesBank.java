package com.example.mycovidtracker.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mycovidtracker.controller.AppController;
import com.example.mycovidtracker.model.Countries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesBank {
    private List<Countries> countriesList = new ArrayList<>();
    String url  = "https://corona.lmao.ninja/v2/countries/";


    private  Countries countries;
    public List<Countries> getCountries(final CountryListAsyncResponse callback){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            Log.d("AZER", "onResponse: "+jsonArray.length());
                            for (int i = 0; i <jsonArray.length() ; i++) {
                                countries = new Countries();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                countries.setName(jsonObject.getString("country"));
                                countries.setCases(jsonObject.getInt("cases"));
                                countries.setTodayCases(jsonObject.getInt("todayCases"));
                                countries.setRecovered(jsonObject.getInt("recovered"));
                                countries.setTodayRecovered(jsonObject.getInt("todayRecovered"));
                                countries.setActive(jsonObject.getInt("active"));
                                countries.setCritical(jsonObject.getInt("critical"));
                                countries.setDeaths(jsonObject.getInt("deaths"));
                                countries.setTodayDeaths(jsonObject.getInt("todayDeaths"));

                                 JSONObject object = jsonObject.getJSONObject("countryInfo");
                                 countries.setFlag(object.getString("flag"));


                                countriesList.add(countries);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(callback != null )
                            callback.processFinished(countriesList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest);
        return countriesList;
    }


}
