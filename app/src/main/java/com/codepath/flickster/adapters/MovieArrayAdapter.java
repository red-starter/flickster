package com.codepath.flickster.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.codepath.flickster.models.Movie;

import java.util.List;

/**
 * Created by michaelsova on 10/13/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }
}
