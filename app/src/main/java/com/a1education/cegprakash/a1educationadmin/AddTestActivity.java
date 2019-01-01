package com.a1education.cegprakash.a1educationadmin;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class AddTestActivity extends AppCompatActivity {

    TableLayout tableLayout;
    Random rand = new Random();
    Button addTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        Context mContext = getApplicationContext();
        ScrollView scroll = new ScrollView(mContext);
        scroll.setBackgroundColor(Color.TRANSPARENT);
        tableLayout = new TableLayout(mContext);
        tableLayout.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        scroll.addView(tableLayout);

        addContentView(scroll, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));

        addTestButton = new Button(mContext);
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        addContentView(addTestButton, new ActionBar.LayoutParams(getPixels(71),getPixels(71)));
        addTestButton.setBackgroundResource(R.drawable.round_button2);
        addTestButton.setText("+");
        addTestButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        addTestButton.setX(size.x - getPixels(71) - getPixels(20));
        addTestButton.setY(size.y - getPixels(71) - getPixels(20));

    }

    @Override
    protected void onStart() {
        super.onStart();

        final Context mContext = getApplicationContext();


        addTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TableRow row = new TableRow(mContext);
                tableLayout.addView(row);
                row.setBackgroundResource(R.drawable.row_border);
                row.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

                row.setMinimumHeight(getPixels(75));
                row.setOrientation(LinearLayout.HORIZONTAL);

                TextView tv = new TextView(mContext);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setPadding(getPixels(30),0, 0,0);
                tv.setTextSize(22f);
                final int testId = 100000000+rand.nextInt(9999999);
                tv.setText("Test #" + Integer.toString(testId));
                tv.setTextColor(Color.BLACK);
                row.addView(tv);

                row.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    Intent switchActivityIntent = new Intent(AddTestActivity.this, TestMenuActivity.class);
                    switchActivityIntent.putExtra("testId", testId);
                    startActivity(switchActivityIntent);
                    }
                });
            }
        });
    }

    protected int getPixels(float dps){
        return (int)(dps * getResources().getDisplayMetrics().density);
    }
}
