package com.example.androidtrainings10.ui.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtrainings10.R;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import androidx.fragment.app.Fragment;

public class WeatherFragment extends Fragment {
    private Button btn_search;
    private TextView weather_c, weather_city;
    private EditText city_search;
    private ListView weather_list;
    private ImageView weather_img;
    private String user_city;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_weather, container, false);

        btn_search = root.findViewById(R.id.btn_search);
        weather_c = root.findViewById(R.id.weather_c);
        weather_city = root.findViewById(R.id.weather_city);
        city_search = root.findViewById(R.id.edit_city);
        weather_list = root.findViewById(R.id.weather_list);
        weather_img = root.findViewById(R.id.weather_img);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_city = city_search.getText().toString();
                if (user_city.isEmpty())
                    Toast.makeText(getActivity(), "Give me city name .. !", Toast.LENGTH_SHORT).show();
                else
                    SearchCity();

            }
        });

        return root;
    }

    private void SearchCity() {
        String api_url = "http://api.openweathermap.org/data/2.5/weather?q=" + user_city + "&appid=4fac134337f98e2b2a4c1746f80ecc2d&units=metric";
        Ion.with(getActivity())
                .load(api_url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if( e != null)
                        {
                            Log.e("TAG", "onCompleted: ERROR = "+e.getMessage() );
                            Toast.makeText(getActivity(), "Something went wrong... !", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
//                            temp
                            String temp = result.get("main").getAsJsonObject().get("temp").getAsString();
                            weather_c.setText(temp+" C°");

                            String city_name = result.get("name").getAsString();
                            String city_code = result.get("sys").getAsJsonObject().get("country").getAsString();
                            weather_city.setText(city_name+" , "+city_code);

                            String weather_icon = result.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
                            String image_url = "http://openweathermap.org/img/wn/"+weather_icon+".png";
                            Ion.with(getContext())
                                    .load(image_url)
                                    .withBitmap()
                                    .intoImageView(weather_img);

                        }
                    }
                });

    }
}