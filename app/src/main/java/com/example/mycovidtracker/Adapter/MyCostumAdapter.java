package com.example.mycovidtracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.mycovidtracker.AffectedCountries;
import com.example.mycovidtracker.R;
import com.example.mycovidtracker.model.Countries;

import java.util.ArrayList;
import java.util.List;

public class MyCostumAdapter extends ArrayAdapter<Countries> {

    private Context context;
    private List<Countries> countriesList;
    private List<Countries> countryListFiltered;
    public MyCostumAdapter(@NonNull Context context, @NonNull List<Countries> countriesList) {
        super(context, R.layout.countries_row, countriesList);
        this.context = context;
        this.countriesList = countriesList;
        this.countryListFiltered = countriesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.countries_row,null,true);
        TextView textView = view.findViewById(R.id.countryText);
        ImageView imageView = view.findViewById(R.id.flagImage);

        textView.setText(countryListFiltered.get(position).getName());
        Glide.with(context).load(countryListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryListFiltered.size();
    }

    @Nullable
    @Override
    public Countries getItem(int position) {
        return countryListFiltered.get(position);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = countriesList.size();
                    filterResults.values = countriesList;

                }else{
                    List<Countries> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(Countries itemsModel:countriesList){
                        if(itemsModel.getName().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryListFiltered = (List<Countries>) results.values;
                AffectedCountries.countriesList = (List<Countries>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }

}
