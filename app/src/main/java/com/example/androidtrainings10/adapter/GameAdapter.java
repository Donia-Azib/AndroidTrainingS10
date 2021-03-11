package com.example.androidtrainings10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtrainings10.R;
import com.example.androidtrainings10.model.Game;
import com.koushikdutta.ion.Ion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GameAdapter extends ArrayAdapter<Game> {
    ImageView image;
    TextView title,review_rating;

    public GameAdapter(@NonNull Context context,  @NonNull Game[] objects) {
        super(context, R.layout.model_game, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.model_game,parent,false);

        image = convertView.findViewById(R.id.game_img);
        title = convertView.findViewById(R.id.game_title);
        review_rating = convertView.findViewById(R.id.game_rate_review);

        Game game = getItem(position);
        title.setText(game.getName());
        review_rating.setText("rate : "+game.getRating()+" | review : "+game.getReviews_count());

        Ion.with(getContext())
                .load(game.getBackground_image())
                .withBitmap()
                .intoImageView(image);

        return convertView;
    }
}
