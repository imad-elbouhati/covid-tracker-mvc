package com.example.mycovidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycovidtracker.data.AnswerListAsyncResponse;
import com.example.mycovidtracker.data.WorldWide;
import com.example.mycovidtracker.model.WorldStatistics;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView cases,todayCases,recovered,todayRecovered,deaths,todayDeaths,active,critical,affectedCountries;
    Button button;
    List<WorldStatistics>worldList;
    PieChart mPieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         cases = findViewById(R.id.cases);

         recovered = findViewById(R.id.recovered);

         deaths = findViewById(R.id.deaths);

         active = findViewById(R.id.active);



         worldList = new ArrayList<>();

         mPieChart = findViewById(R.id.piechart);

         button = findViewById(R.id.trackCountries);


        new WorldWide().getWorldStatistics(new AnswerListAsyncResponse<WorldStatistics>() {
            @Override
            public void processFinished(List<WorldStatistics> worldStatisticsArrayList) {
                cases.setText(Integer.toString(worldStatisticsArrayList.get(0).getCases()));

                deaths.setText(Integer.toString(worldStatisticsArrayList.get(0).getDeaths()));

                recovered.setText(Integer.toString(worldStatisticsArrayList.get(0).getRecovered()));

                active.setText(Integer.toString(worldStatisticsArrayList.get(0).getActive()));


                mPieChart.addPieSlice(new PieModel("Cases", worldStatisticsArrayList.get(0).getCases(), Color.parseColor("#F9A825")));
                mPieChart.addPieSlice(new PieModel("Recovered", worldStatisticsArrayList.get(0).getRecovered(), Color.parseColor("#26C6DA")));
                mPieChart.addPieSlice(new PieModel("Death", worldStatisticsArrayList.get(0).getDeaths(), Color.parseColor("#E57373")));
                mPieChart.addPieSlice(new PieModel("Active", worldStatisticsArrayList.get(0).getActive(), Color.parseColor("#81C784")));

                mPieChart.startAnimation();
            }



        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AffectedCountries.class));
            }
        });
    }

}