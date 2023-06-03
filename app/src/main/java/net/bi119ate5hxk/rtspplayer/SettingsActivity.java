package net.bi119ate5hxk.rtspplayer;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class SettingsActivity extends AppCompatActivity{
    private static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPref = getSharedPreferences("appPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        TextView urlTextF1 = findViewById(R.id.urlField1);
        TextView urlTextF2 = findViewById(R.id.urlField2);
        TextView urlTextF3 = findViewById(R.id.urlField3);
        TextView urlTextF4 = findViewById(R.id.urlField4);
        TextView urlTextF5 = findViewById(R.id.urlField5);
        TextView urlTextF6 = findViewById(R.id.urlField6);
        TextView urlTextF7 = findViewById(R.id.urlField7);
        TextView urlTextF8 = findViewById(R.id.urlField8);
        TextView urlTextF9 = findViewById(R.id.urlField9);
        TextView urlTextF10 = findViewById(R.id.urlField10);
        TextView urlTextF11 = findViewById(R.id.urlField11);
        TextView urlTextF12 = findViewById(R.id.urlField12);
        TextView urlTextF13 = findViewById(R.id.urlField13);
        TextView urlTextF14 = findViewById(R.id.urlField14);
        TextView urlTextF15 = findViewById(R.id.urlField15);
        TextView urlTextF16 = findViewById(R.id.urlField16);

        Set<String> urlArrSetR = sharedPref.getStringSet("urlArrSet",new HashSet<String>());
        List<String> list = new ArrayList<String>(urlArrSetR);

        int i=0;
        String[] urlStrArr = new String[16];
        for (String str: list) {
            urlStrArr[i] = str;
            i++;
        }

        urlTextF1.setText(urlStrArr[0]);
        urlTextF2.setText(urlStrArr[1]);
        urlTextF3.setText(urlStrArr[2]);
        urlTextF4.setText(urlStrArr[3]);
        urlTextF5.setText(urlStrArr[4]);
        urlTextF6.setText(urlStrArr[5]);
        urlTextF7.setText(urlStrArr[6]);
        urlTextF8.setText(urlStrArr[7]);
        urlTextF9.setText(urlStrArr[8]);
        urlTextF10.setText(urlStrArr[9]);
        urlTextF11.setText(urlStrArr[10]);
        urlTextF12.setText(urlStrArr[11]);
        urlTextF13.setText(urlStrArr[12]);
        urlTextF14.setText(urlStrArr[13]);
        urlTextF15.setText(urlStrArr[14]);
        urlTextF16.setText(urlStrArr[15]);


        Button button = (Button) findViewById(R.id.doneBTN);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "BTN pressed");

                TreeSet<String> urlArrSet = new TreeSet<String>();

                urlArrSet.add(urlTextF1.getText().toString().trim());
                urlArrSet.add(urlTextF2.getText().toString().trim());
                urlArrSet.add(urlTextF3.getText().toString().trim());
                urlArrSet.add(urlTextF4.getText().toString().trim());
                urlArrSet.add(urlTextF5.getText().toString().trim());
                urlArrSet.add(urlTextF6.getText().toString().trim());
                urlArrSet.add(urlTextF7.getText().toString().trim());
                urlArrSet.add(urlTextF8.getText().toString().trim());
                urlArrSet.add(urlTextF9.getText().toString().trim());
                urlArrSet.add(urlTextF10.getText().toString().trim());
                urlArrSet.add(urlTextF11.getText().toString().trim());
                urlArrSet.add(urlTextF12.getText().toString().trim());
                urlArrSet.add(urlTextF13.getText().toString().trim());
                urlArrSet.add(urlTextF14.getText().toString().trim());
                urlArrSet.add(urlTextF15.getText().toString().trim());
                urlArrSet.add(urlTextF16.getText().toString().trim());
                if (urlArrSet.contains("")){
                    urlArrSet.remove("");
                }
                Log.d("urlArrSet", urlArrSet.toString());
                Log.d("urlArrSet.size", String.valueOf(urlArrSet.size()));
                editor.putStringSet("urlArrSet",urlArrSet);
                editor.apply();
                editor.commit();

                if (urlArrSet.size() <= 0){
                    Toast.makeText(SettingsActivity.this, "At least 1 URL is required!",
                            Toast.LENGTH_LONG).show();
                }else if (urlArrSet.size() == 1){
                    Intent i = new Intent(SettingsActivity.this, RTSP1Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", urlArrSet.first());
                    i.putExtras(bundle);
                    startActivity(i);

                }else if (urlArrSet.size() <= 4){
                    Intent i = new Intent(SettingsActivity.this, RTSP4Activity.class);
                    Bundle bundle = new Bundle();
                    ArrayList<String> urlList = new ArrayList<String>(urlArrSet);
                    bundle.putStringArrayList("urls",urlList);
                    i.putExtras(bundle);
                    startActivity(i);

                }else if (urlArrSet.size() <= 9){
                    Intent i = new Intent(SettingsActivity.this, RTSP9Activity.class);
                    Bundle bundle = new Bundle();
                    ArrayList<String> urlList = new ArrayList<String>(urlArrSet);
                    bundle.putStringArrayList("urls",urlList);
                    i.putExtras(bundle);
                    startActivity(i);

                }else if (urlArrSet.size() <= 16){
                    Intent i = new Intent(SettingsActivity.this, RTSP16Activity.class);
                    Bundle bundle = new Bundle();
                    ArrayList<String> urlList = new ArrayList<String>(urlArrSet);
                    bundle.putStringArrayList("urls",urlList);
                    i.putExtras(bundle);
                    startActivity(i);
                }


            }
        });
    }

}
