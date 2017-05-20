package com.example.tonto.randomquote.networks;

import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tonto on 5/16/2017.
 */

public class QuoteLoader extends AsyncTask<Void, Void, String> {
    private final String QUOTE_URL = "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand";
    private TextView textView;

    public QuoteLoader(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... params) {
        // 1: Open connection
        try {
            URL url = new URL(QUOTE_URL);

            // 2: Open stream
            InputStream inputStream = url.openStream();

            // 3: Get data
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String content = stringBuilder.toString();
            // 4: Decode data
            JSONArray jsonArray = new JSONArray(content);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String quoteContent = jsonObject.getString("content");
            System.out.println(quoteContent);
            return quoteContent;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s != null)
            textView.setText(Html.fromHtml(s));
    }
}
