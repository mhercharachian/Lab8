package com.example.andreea.listviewapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.logging.Logger;
import android.content.Intent;

public class CustomAdapter extends BaseAdapter{
    private static String TAG = "CustomAdapterApp";
    int [] result;
    Context context;
    int [] imageId;
    int [] des;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, int[] prgmNameList, int[] prgmImages, int[] prgmDesList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        des = prgmDesList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(context.getResources().getString(result[position]));
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Activity2.class);
                Log.i(TAG, des[position] + "");
                i.putExtra("DES1", context.getResources().getString(des[position]));
                i.putExtra("IMG1", imageId[position]);
                context.startActivity(i);
            }
        });
        return rowView;
    }

}