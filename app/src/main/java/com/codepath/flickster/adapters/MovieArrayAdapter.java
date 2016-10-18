package com.codepath.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
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

import static com.codepath.flickster.R.id.tvOverview;
import static com.codepath.flickster.R.id.tvTitle;

/**
 * Created by michaelsova on 10/13/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    // View lookup cache
    private static class ViewHolder {
        ImageView ivMovieImage;
        TextView tvTitle;
        TextView tvOverview;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get data item for position
        Movie movie = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(tvOverview);
            viewHolder.ivMovieImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //clear out image from convert view
        viewHolder.ivMovieImage.setImageResource(0);

        //populate the data
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        String imagePath;
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            imagePath = movie.getPosterPath();
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imagePath = movie.getBackdropPathPath();
        } else {
            imagePath = movie.getPosterPath();
        }

        Picasso.with(getContext()).load(imagePath).into(viewHolder.ivMovieImage);
        return convertView;
    }
}
