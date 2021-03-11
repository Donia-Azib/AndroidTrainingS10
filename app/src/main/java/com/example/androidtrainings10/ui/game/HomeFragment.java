package com.example.androidtrainings10.ui.game;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidtrainings10.R;
import com.example.androidtrainings10.adapter.GameAdapter;
import com.example.androidtrainings10.model.Game;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private ListView list_game;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        list_game = root.findViewById(R.id.game_list);

        setGameList();

        return root;
    }

    private void setGameList(){
//        context = getActivity() => fragment
//        context = ActivityName.this => Activity
        String api_url = "https://rawg-video-games-database.p.rapidapi.com/games";
        Ion.with(getActivity())
                .load(api_url)
                .setHeader("x-rapidapi-key","1eca79ea2fmshb41dd269e4b7f29p16c9b3jsnc398cc5272a7")
                .setHeader("x-rapidapi-host","rawg-video-games-database.p.rapidapi.com")
                .setHeader("useQueryString","true")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if( e != null)
                        {
                            Log.e("TAG", "onCompleted: "+e.getMessage());
                            Toast.makeText(getActivity(), "Something wrong ... !", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            JsonArray results = result.get("results").getAsJsonArray();
                            Gson gson = new Gson();
                            Game[] game_tab = gson.fromJson(results.toString(),Game[].class);
//                            [
//                            {id,back_img,rate_review,name}, {id,back_img,rate,name}, {id,back_img,rate,name}, {id,back_img,rate,name},{},{}....
//                            ...
//                            ...
//                            ]
                            GameAdapter adapter = new GameAdapter(getActivity(),game_tab);
                            list_game.setAdapter(adapter);


                        }
                    }
                });
    }
}