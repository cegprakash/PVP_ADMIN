package com.a1education.cegprakash.a1educationadmin;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class KeyActivity extends AppCompatActivity {

    private static RadioGroup radioGroup[] = new RadioGroup[180];

    private static int checkedId[] = new int[180];
    TableLayout tableLayout;

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reset();
        setContentView(R.layout.activity_key);
        Context mContext = getApplicationContext();
        ScrollView scroll = new ScrollView(mContext);
        scroll.setBackgroundColor(Color.TRANSPARENT);
        tableLayout = new TableLayout(mContext);
        tableLayout.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        scroll.addView(tableLayout);

        addContentView(scroll, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));

    }

    protected int getPixels(float dps){
        return (int)(dps * getResources().getDisplayMetrics().density);
    }


    @Override
    protected void onStart() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        final String TOKENS_DIRECTORY_PATH = getFilesDir().getAbsolutePath();
        ;

        super.onStart();
        final Context mContext = getApplicationContext();

        tableLayout.removeAllViews();

        for (int i = 0; i < 180; i++) {

            TableRow row = new TableRow(mContext);
            row.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
            row.setMinimumHeight(getPixels(50));
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);
            if (i % 2 == 0) {
                row.setBackgroundColor(Color.parseColor("#a0a0a0"));
            }

            TextView tv = new TextView(mContext);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setPadding(getPixels(30), 0, 0, 0);

            tv.setText("#" + Integer.toString(i + 1));
            tv.setTextColor(Color.BLACK);
            row.addView(tv);

            radioGroup[i] = new RadioGroup(mContext);
            radioGroup[i].setOrientation(LinearLayout.HORIZONTAL);
            radioGroup[i].setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            radioGroup[i].setMinimumWidth(row.getMeasuredWidth() - tv.getMeasuredWidth());
            radioGroup[i].setPadding(getPixels(50), 0, 0, 0);

            for (int j = 0; j < 4; j++) {

                RadioButton rb = new RadioButton(mContext);
                rb.setTextSize(getPixels(30));
                rb.setScaleX(1.2f);
                rb.setScaleY(1.2f);
                rb.setPadding(0, 0, getPixels(30), 0);
                rb.setId(j);
                radioGroup[i].addView(rb);
            }

            row.addView(radioGroup[i]);


            tableLayout.addView(row);

        }

        Button submitButton = new Button(mContext);
        submitButton.setText("Submit");
        tableLayout.addView(submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isNetworkConnected()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(KeyActivity.this);
                    alert.setTitle("No connectivity");
                    alert.setMessage("Check your internet connectivity and try again later.");
                    alert.show();
                    alert.setPositiveButton("Ok", null);
                    return;
                }
                List<List<Object>> data = new ArrayList<>();
                for (int i = 0; i < 180; i++) {
                    int selectedId = radioGroup[i].getCheckedRadioButtonId();
                    List<Object> arr = new ArrayList<Object>();
                    arr.add((Object) Integer.toString(selectedId));
                    data.add(arr);
                }

                try {

//                    System.out.println("here1");
//                    final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();
//                    final String spreadsheetId = "1Z0ZkvwJtmA4F7vrRBsAULZ1RK5Ib159281aUC58zJ9k";
//                    final String range = "Sheet1!A:B";
//                    System.out.println("here2");
//
//                    GoogleAuthorizationCodeFlow flow = GoogleSheets.getFlow(HTTP_TRANSPORT, getResources(), TOKENS_DIRECTORY_PATH);
//
//                    AuthorizationCodeInstalledApp ab = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()) {
//                        public Intent browserIntent;
//
//                        protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) {
//                            String url = (authorizationUrl.build());
//                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//
//                            startActivity(browserIntent);
//                        }
//
//
//                    };
//
//                    Credential credential = ab.authorize("user");
////                    Credential credential = new Credential.Builder().setT
////                    credential.setAccessToken("ya29.Glt7BpSCNjRe4hN4NqEIIRGM84f8jiAa3mWoikCEYCqb_c-dy1n9rrn1FTmvG1PT5zv-cqmfbQWygYXGDZuQvwYWvxqzt4CpGxLMfrJuMFfOOLVOqwpyJQSDLxs9");
//
//                    System.out.println("here21");
//                    Sheets.Builder builder = new Sheets.Builder(HTTP_TRANSPORT, GoogleSheets.JSON_FACTORY, credential);
//                    System.out.println("here22");
//                    builder.setApplicationName(GoogleSheets.APPLICATION_NAME);
//                    System.out.println("here3");
//
//                    Sheets service = builder.build();
//                    System.out.println("here4");
//                    ValueRange content = new ValueRange();
//                    content.setValues(data);
//                    System.out.println("here5");
//                    service.spreadsheets().values().update(spreadsheetId, range, content).setValueInputOption("USER_ENTERED").execute();
//                    System.out.println("here6");
//                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//                    alert.setTitle("Submitted");
//                    alert.setMessage("Your response has been submitted successfully");
//                    alert.setPositiveButton("Ok", null);
//                    alert.show();

                } catch (Exception e) {
//                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//                    alert.setTitle("Something went wrong. Check your internet connectivity and try again later.");
//                    alert.setMessage(e.toString());
//                    alert.show();
//                    alert.setPositiveButton("Ok", null);
//                    System.out.println(e);
                }


            }
        });
    }

    private void reset(){
        for(int i=0;i<180;i++) {
            checkedId[i] = -1;
        }
    }
}
