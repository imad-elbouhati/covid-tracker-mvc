package com.example.mycovidtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mycovidtracker.AffectedCountries.countriesList;

public class CountryDetails extends AppCompatActivity {
    TextView name,cases,todayCases,recovered,todayRecovered,deaths,todayDeaths,active;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        name = findViewById(R.id.countryName);
        cases = findViewById(R.id.cases);
        todayCases = findViewById(R.id.todayCases);
        recovered = findViewById(R.id.recovered);
        todayRecovered = findViewById(R.id.todayRecovered);

        deaths = findViewById(R.id.deaths);
        todayDeaths= findViewById(R.id.todayDeaths);
        active = findViewById(R.id.active);


        int position = getIntent().getIntExtra("position",0);

        name.setText(countriesList.get(position).getName());
        cases.setText(Integer.toString(countriesList.get(position).getCases()));
        todayCases.setText(Integer.toString(countriesList.get(position).getTodayCases()));
        recovered.setText(Integer.toString(countriesList.get(position).getRecovered()));
        todayRecovered.setText(Integer.toString(countriesList.get(position).getTodayRecovered()));
        deaths.setText(Integer.toString(countriesList.get(position).getDeaths()));
        todayDeaths.setText(Integer.toString(countriesList.get(position).getTodayDeaths()));
        active.setText(Integer.toString(countriesList.get(position).getActive()));







    }
}