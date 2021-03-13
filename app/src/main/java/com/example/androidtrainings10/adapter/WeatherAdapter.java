package com.example.androidtrainings10.adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtrainings10.R;
import com.example.androidtrainings10.model.Weather;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    private ImageView img;
    private TextView weather_c,weather_date;

    public WeatherAdapter(@NonNull Context context,  @NonNull ArrayList<Weather> objects) {
        super(context, R.layout.weather_model_list, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.weather_model_list,parent,false);

        weather_c = convertView.findViewById(R.id.weather_c);
        weather_date = convertView.findViewById(R.id.weather_date);
        img= convertView.findViewById(R.id.weather_image);

        Weather weather = getItem(position);

//        date
//        image
//        temp
//        Date date = new Date(weather.getDt()*1000);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd",Locale.ENGLISH);
//        dateFormat.setTimeZone(TimeZone.getTimeZone(weather.getTimezone()));
//        dateFormat.format(date);
//        weather_date.setText(dateFormat.toString());

        String dateString = DateFormat.format("dd-MM-yyyy", new Date(weather.getDt()*1000L)).toString();
        weather_date.setText(dateString.toString());


        weather_c.setText(weather.getTemp().toString()+" C°");


        String image_url = "http://openweathermap.org/img/wn/"+weather.getIcon()+".png";
        Ion.with(getContext())
                .load(image_url)
                .withBitmap()
                .intoImageView(img);

        return convertView;
    }
}
