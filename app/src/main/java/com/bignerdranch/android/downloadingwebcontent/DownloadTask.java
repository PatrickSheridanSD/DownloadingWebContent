package com.bignerdranch.android.downloadingwebcontent;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by patrick on 16/07/2016.
 */
public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(strings[0]);

            urlConnection =(HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while (data != -1){

                char current = (char) data;

                result += current;

                data = reader.read();

            }

            return result;

        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
    }
}
