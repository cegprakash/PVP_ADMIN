package com.a1education.cegprakash.a1educationadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);
        final int testId = getIntent().getIntExtra("testId", 1);
        TextView textView = findViewById(R.id.test_view);
        textView.setText("Test #"+testId);

       final Button studentsButton = findViewById(R.id.students_button);

        studentsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent switchActivityIntent = new Intent(TestMenuActivity.this, StudentsActivity.class);
            switchActivityIntent.putExtra("testId", testId);
            startActivity(switchActivityIntent);
            }
        });

        final Button keyButton = findViewById(R.id.key_edit_button);
        keyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(TestMenuActivity.this, KeyActivity.class);
                switchActivityIntent.putExtra("testId", testId);
                startActivity(switchActivityIntent);
            }
        });

    }
}
