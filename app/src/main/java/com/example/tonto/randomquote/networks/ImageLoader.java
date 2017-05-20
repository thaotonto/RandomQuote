package com.example.tonto.randomquote.networks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;


import com.example.tonto.randomquote.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * Created by tonto on 5/17/2017.
 */

public class ImageLoader extends AsyncTask<Void, Void, Bitmap> {
    private final String IMAGE_URL = "https://source.unsplash.com/random/300x300";
    private ImageView imageView;

    public ImageLoader(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageView.setImageResource(R.drawable.progress_animation);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL url = new URL(IMAGE_URL);
            InputStream inputStream = url.openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(bitmap);
        }
    }
}
