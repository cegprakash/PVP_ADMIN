package com.a1education.cegprakash.a1educationadmin;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.drawable.GradientDrawable.*;

public class StudentsActivity extends AppCompatActivity {
    TableLayout tableLayout;
    Button addStudentsButton;
    Random rand = new Random();
    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        Context mContext = getApplicationContext();
        ScrollView scroll = new ScrollView(mContext);
        scroll.setBackgroundColor(Color.TRANSPARENT);
        tableLayout = new TableLayout(mContext);
        tableLayout.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        scroll.addView(tableLayout);

        addContentView(scroll, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));

        addStudentsButton = new Button(mContext);
        getWindowManager().getDefaultDisplay().getSize(size);
        addContentView(addStudentsButton, new ActionBar.LayoutParams(getPixels(71),getPixels(71)));
        addStudentsButton.setBackgroundResource(R.drawable.round_button2);
        addStudentsButton.setText("+");
        addStudentsButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        addStudentsButton.setX(size.x - getPixels(71) - getPixels(20));
        addStudentsButton.setY(size.y - getPixels(71) - getPixels(20));
    }


    @Override
    protected void onStart() {
        super.onStart();

        final Context mContext = getApplicationContext();


        addStudentsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TableRow row = new TableRow(mContext);
                row.setMinimumHeight(getPixels(75));
                row.setBackgroundResource(R.drawable.row_border);
                row.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

                LinearLayout linearLayout = new LinearLayout(mContext);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout emptySpace = new LinearLayout(mContext);
                emptySpace.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT));
                emptySpace.setMinimumWidth(getPixels(10));
                linearLayout.addView(emptySpace);

                TextView serialNoView = new TextView(mContext);
                serialNoView.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT));
                serialNoView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                serialNoView.setTextSize(16f);
                serialNoView.setText(Integer.toString(tableLayout.getChildCount()+1));
                linearLayout.addView(serialNoView);

                LinearLayout emptySpace2 = new LinearLayout(mContext);
                emptySpace2.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT));
                emptySpace2.setMinimumWidth(getPixels(30));
                linearLayout.addView(emptySpace2);

                LinearLayout innerLayout = new LinearLayout(mContext);
                innerLayout.setOrientation(LinearLayout.VERTICAL);
                innerLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                TextView tv = new TextView(mContext);
                //tv.setWidth(size.x);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(22f);
                final int userId = 100000000+rand.nextInt(9999999);
                final int password = 100000000+rand.nextInt(9999999);
                tv.setText("User ID : " + Integer.toString(userId)+"\n"+"Password : " + Integer.toString(password));
                tv.setTextColor(Color.BLACK);
                innerLayout.addView(tv);
                linearLayout.addView(innerLayout);
                row.addView(linearLayout);

                tableLayout.addView(row);

            }
        });
    }

    protected int getPixels(float dps){
        return (int)(dps * getResources().getDisplayMetrics().density);
    }
}
