package com.aungrattanakorn.tanakorn.mystudy1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Jinfeek on 1/15/2017.
 */

public class MyAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private String[] nameString, iconString;

    public MyAdapter(Context context, String[] nameString, String[] iconString) {
        this.context = context;
        this.nameString = nameString;
        this.iconString = iconString;
    }

    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(nameString[position]);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);
        Picasso.with(context).load(iconString[position]).into(imageView);



        return view ;
    }
} //Main Class
