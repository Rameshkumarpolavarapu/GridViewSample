package com.example.ramesh.t2;
import android.content.Context;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private View gridview1;
    ImageView imageView;
    String name;
    int resorce;


    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 44;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView ==  null){
            gridview1   =   new View(mContext);
            gridview1   =   inflater.inflate(R.layout.actionbar,null);

            ((GradientDrawable)gridview1.getBackground()).setColor(getRandomMaterialColor("400"));
            imageView =  (ImageView) gridview1.findViewById(R.id.img1);
            getImages();
            TextView textView   =  (TextView) gridview1.findViewById(R.id.text_app);
            textView.setText(""+get_letters());
            textView.setGravity(Gravity.CENTER);
        }else {
            gridview1   = convertView;
        }

        return gridview1;
    }

//    public int getColors(){
//        Random random   =   new Random();
//        int color   = Color.argb(255,random.nextInt(255),random.nextInt(256),random.nextInt(256));
//
//        return color;
//    }

    public String get_letters(){
        Random ra = new Random();
        char c = (char) (ra.nextInt(26) + 'a');
        name= String.valueOf(c);
        Log.i("---->",""+mContext.getResources().getIdentifier(name, "drawable", "com.example.ramesh.t2"));
        Log.i("---->",""+name);
        return name;

    }
//    // Keep all Images in array
//    public Integer[] mThumbIds = {
//
//            R.drawable.a,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.d,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.k,
//            R.drawable.l,
//            R.drawable.m,
//            R.drawable.n,
//            R.drawable.o,
//            R.drawable.p,
//            R.drawable.q,
//            R.drawable.r,
//            R.drawable.s,
//            R.drawable.t,
//            R.drawable.u,
//            R.drawable.v,
//            R.drawable.w,
//            R.drawable.x,
//            R.drawable.y,
//            R.drawable.z,
//            R.drawable.a,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.d,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.k,
//            R.drawable.l,
//            R.drawable.m,
//            R.drawable.n,
//            R.drawable.o,
//            R.drawable.p,
//            R.drawable.q,
//            R.drawable.r,
//            R.drawable.s,
//            R.drawable.t,
//            R.drawable.u,
//            R.drawable.v,
//            R.drawable.w,
//            R.drawable.x,
//            R.drawable.y,
//            R.drawable.z
//    };

    /**
     * chooses a random images from array.xml file
     */
        private void getImages()
            {
                TypedArray images = mContext.getResources().obtainTypedArray(R.array.random_imgs);
                int choice = (int) (Math.random() * images.length());
                imageView.setImageResource(images.getResourceId(choice, R.drawable.a));
                Log.i("image-->",""+images.getResourceId(choice,R.drawable.a));
                images.recycle();
            }
/**
     * chooses a random color from array.xml
     */
    private int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId = mContext.getResources().getIdentifier("mdcolor_" + typeColor, "array", mContext.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

}
