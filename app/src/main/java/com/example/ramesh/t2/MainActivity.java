package com.example.ramesh.t2;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout mainLayout=new RelativeLayout(this);
        mainLayout.setId(R.id.mainpage);
        mainLayout.setLayoutParams(getRparams());

        Toolbar toolbar=new Toolbar(this);
        toolbar.setTitle("Restaurant");
        toolbar.setId(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#00C5E5"));
        toolbar.setLogo(R.drawable.ic_action_name);
        Toolbar.LayoutParams toolBarParams=new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,Toolbar.LayoutParams.WRAP_CONTENT);
        toolbar.setLayoutParams(toolBarParams);
        setSupportActionBar(toolbar);

        GridView gridView   =   new GridView(getApplicationContext());
        gridView.setId(R.id.gridView);
        RelativeLayout.LayoutParams p   =   new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        p.addRule(RelativeLayout.BELOW,R.id.toolbar);
        p.setMargins(30,30,30,30);
        gridView.setLayoutParams(p);
        gridView.setColumnWidth(90);
        gridView.setGravity(Gravity.CENTER);
        gridView.setVerticalSpacing(20);
        gridView.setHorizontalSpacing(20);
        gridView.setNumColumns(4);
        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gridView.setAdapter(new ImageAdapter(this));
        mainLayout.addView(toolbar);
        mainLayout.addView(gridView);
        setContentView(mainLayout);
    }

//    public RelativeLayout.LayoutParams getRparams_WithId(int ch,int id){
//
//        switch (ch){
//            case 101:
//            RelativeLayout.LayoutParams Params  =   new RelativeLayout.LayoutParams
//                                                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                Params.addRule(RelativeLayout.BELOW,id);
//                return Params;
//
//            case 102:
//                RelativeLayout.LayoutParams p   =   new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
//                p.addRule(RelativeLayout.BELOW,id);
//                return p;
//        }
//        return null;
//    }
    public RelativeLayout.LayoutParams getRparams(){
            RelativeLayout.LayoutParams params  =   new RelativeLayout.LayoutParams
                                                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
               return  params;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.sub_menu,menu);
        return true;
    }

}
