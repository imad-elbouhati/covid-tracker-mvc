package com.example.mycovidtracker.data;

import com.example.mycovidtracker.model.Countries;
import com.example.mycovidtracker.model.WorldStatistics;

import java.util.ArrayList;
import java.util.List;

public interface AnswerListAsyncResponse<T> {
    void processFinished(List<T> worldStatisticsArrayList);
}
