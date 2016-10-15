package com.codepath.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by michaelsova on 10/13/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get data item for position
        Movie movie = getItem(position);
        // check the existing view being reused
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_movie, parent, false);
        }
        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear out image from convert view
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate the data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        return convertView;
    }
}
