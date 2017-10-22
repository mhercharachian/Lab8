package com.example.andreea.listviewapp;


import java.util.ArrayList;

import android.app.SearchManager;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.Intent;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.images,R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4};
    public static int [] prgmNameList={R.string.dinoName1, R.string.dinoName2,R.string.dinoName3, R.string.dinoName4, R.string.dinoName5};
    public static int [] prgmDesList={R.string.dinoDes1, R.string.dinoDes2, R.string.dinoDes3, R.string.dinoDes4, R.string.dinoDes5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages, prgmDesList));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        //menu.findItem(R.id.item2).setIntent(this, About.class);
        return true;
    }

    public void searchWeb() {
        String q = "http://www.sciencekids.co.nz/pictures/dinosaurs.html";
        googleSearch(q);
    }

    /**
     * Makes a google search of a string.
     * @param query
     */
    public void googleSearch(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.DialogMessage)
                .setTitle(R.string.DialogTitle);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                searchWeb();
                return true;
            case R.id.item2:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
