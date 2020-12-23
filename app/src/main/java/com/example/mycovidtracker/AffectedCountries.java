package com.example.mycovidtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mycovidtracker.Adapter.MyCostumAdapter;
import com.example.mycovidtracker.data.AnswerListAsyncResponse;
import com.example.mycovidtracker.data.CountriesBank;

import com.example.mycovidtracker.model.Countries;
import com.example.mycovidtracker.model.WorldStatistics;

import java.util.ArrayList;
import java.util.List;

public class AffectedCountries extends AppCompatActivity {

    ListView listView;
    EditText editSearch;
     MyCostumAdapter myAdapter;
    public static List<Countries> countriesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);

        listView = findViewById(R.id.listView);
        editSearch = findViewById(R.id.editSearch);


        countriesList = new ArrayList<>();
        countriesList =new CountriesBank().getCountries(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(List worldStatisticsArrayList) {

                myAdapter = new MyCostumAdapter(getApplicationContext(),worldStatisticsArrayList);
                listView.setAdapter(myAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),CountryDetails.class).putExtra("position",position));

            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                myAdapter.getFilter().filter(s);
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



}