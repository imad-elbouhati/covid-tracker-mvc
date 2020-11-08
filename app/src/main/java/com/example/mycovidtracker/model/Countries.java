package com.example.mycovidtracker.model;

public class Countries {
    private  String flag,name;
    private int cases,todayCases,Recovered,deaths,todayDeaths,active,critical,todayRecovered;

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getName() {
        return name;
    }

    public Countries(String flag, String name, int cases, int todayCases, int recovered, int deaths, int todayDeaths, int active, int critical) {
        this.flag = flag;
        this.name = name;
        this.cases = cases;
        this.todayCases = todayCases;
        Recovered = recovered;

        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.active = active;
        this.critical = critical;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countries(){}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getRecovered() {
        return Recovered;
    }

    public void setRecovered(int recovered) {
        Recovered = recovered;
    }





    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "flag='" + flag + '\'' +
                ", name='" + name + '\'' +
                ", cases=" + cases +
                ",todayRecovered="+todayRecovered+
                ", todayCases=" + todayCases +
                ", Recovered=" + Recovered +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", active=" + active +
                ", critical=" + critical +
                '}';
    }
}
