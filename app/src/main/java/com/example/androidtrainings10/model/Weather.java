package com.example.androidtrainings10.model;

public class Weather {
    private String max,icon,dt;

    public Weather(String max, String icon, String dt) {
        this.max = max;
        this.icon = icon;
        this.dt = dt;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}
