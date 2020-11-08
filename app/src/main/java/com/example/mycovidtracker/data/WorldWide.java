package com.example.mycovidtracker.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mycovidtracker.controller.AppController;
import com.example.mycovidtracker.model.WorldStatistics;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorldWide {


    private List<WorldStatistics> worldStatisticsList = new ArrayList<>();
    String url = "https://corona.lmao.ninja/v2/all";

    public List<WorldStatistics> getWorldStatistics(final AnswerListAsyncResponse callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        WorldStatistics worldStatistics = new WorldStatistics();

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            worldStatistics.setCases(jsonObject.getInt("cases"));
                            worldStatistics.setTodayCases(jsonObject.getInt("todayCases"));
                            worldStatistics.setDeaths(jsonObject.getInt("deaths"));
                            worldStatistics.setTodayDeaths(jsonObject.getInt("todayDeaths"));
                            worldStatistics.setRecovered(jsonObject.getInt("recovered"));
                            worldStatistics.setTodayRecovered(jsonObject.getInt("todayRecovered"));
                            worldStatistics.setActive(jsonObject.getInt("active"));
                            worldStatistics.setCritical(jsonObject.getInt("critical"));
                            worldStatistics.setAffectedCountries(jsonObject.getInt("affectedCountries"));

                            worldStatisticsList.add(worldStatistics);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (callback != null)
                            callback.processFinished(worldStatisticsList);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest);
        return worldStatisticsList;
    }


}

