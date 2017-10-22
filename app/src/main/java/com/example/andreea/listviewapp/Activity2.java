package com.example.andreea.listviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.logging.Logger;

public class Activity2 extends AppCompatActivity {
    private static String TAG = "Activity2App";
    TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv = (TextView) findViewById(R.id.description);
        iv = (ImageView) findViewById(R.id.imageView);
        if ( getIntent().hasExtra("DES1") ) {
            Log.i(TAG, "yes");
            tv.setText(getIntent().getExtras().getString("DES1") + " ");
        } else {
            Log.i(TAG, "no");
            tv.setText("No description ");
        }
        if ( getIntent().hasExtra("DES1") ) {
            Log.i(TAG, "yes");
            tv.setText(getIntent().getExtras().getString("DES1") + " ");
        } else {
            Log.i(TAG, "no");
            tv.setText("No description ");
        }

        if ( getIntent().hasExtra("IMG1") ) {
            Log.i(TAG, "yes");
            iv.setImageResource(getIntent().getExtras().getInt("IMG1"));
        } else {
            Log.i(TAG, "no");
            iv.setImageResource(R.drawable.images);

        }
    }
}
