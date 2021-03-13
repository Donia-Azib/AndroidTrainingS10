package com.example.androidtrainings10.model;

public class Weather {
    private long dt;
    private String timezone,icon;
    private Double temp;

    public Weather(long dt, String timezone, String icon, Double temp) {
        this.dt = dt;
        this.timezone = timezone;
        this.icon = icon;
        this.temp = temp;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
