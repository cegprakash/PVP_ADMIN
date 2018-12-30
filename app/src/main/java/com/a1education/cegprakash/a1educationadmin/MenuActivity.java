package com.a1education.cegprakash.a1educationadmin;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



    }

    @Override
    protected void onStart() {
        super.onStart();

        final Button button = findViewById(R.id.manage_test_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(MenuActivity.this, AddTestActivity.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}
