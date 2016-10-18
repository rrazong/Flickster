package com.example.richellerazon.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.richellerazon.flickster.R;
import com.example.richellerazon.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by richellerazon on 10/16/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        //super(context, android.R.layout.simple_list_item_1, movies);
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Movie movie = getItem(position);
        int orientation = getContext().getResources().getConfiguration().orientation;
        String imageUrl;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.tvTitle   = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.ivImage.setImageResource(0);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageUrl = movie.getPosterUrl();

        } else {
            imageUrl = movie.getBackdropUrl();

        }
        Picasso.with(getContext()).load(imageUrl).into(viewHolder.ivImage);

        viewHolder.tvTitle.setText(movie.getOriginTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        return convertView;
    }

    private static class ViewHolder {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvOverview;
    }
}
