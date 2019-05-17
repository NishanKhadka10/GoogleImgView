package com.googleimgview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView imgFile;
    Bitmap b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgFile = findViewById(R.id.imgFile);

        information info = new information();
        info.execute("");


    }

    public class information extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("https://s26552.pcdn.co/wp-content/uploads/2018/03/dc_neighborhood_news-13.jpg");
                InputStream inputStream = new BufferedInputStream(url.openStream());
                b = BitmapFactory.decodeStream(inputStream);


            } catch (Exception e) {
                return null;

            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            imgFile.setImageBitmap(b);
        }
    }

}
