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
    private static ArrayList<TextView> tfViewsList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPref = getSharedPreferences("appPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        tfViewsList.add(findViewById(R.id.urlField1));
        tfViewsList.add(findViewById(R.id.urlField2));
        tfViewsList.add(findViewById(R.id.urlField3));
        tfViewsList.add(findViewById(R.id.urlField4));
        tfViewsList.add(findViewById(R.id.urlField5));
        tfViewsList.add(findViewById(R.id.urlField6));
        tfViewsList.add(findViewById(R.id.urlField7));
        tfViewsList.add(findViewById(R.id.urlField8));
        tfViewsList.add(findViewById(R.id.urlField9));
        tfViewsList.add(findViewById(R.id.urlField10));
        tfViewsList.add(findViewById(R.id.urlField11));
        tfViewsList.add(findViewById(R.id.urlField12));
        tfViewsList.add(findViewById(R.id.urlField13));
        tfViewsList.add(findViewById(R.id.urlField14));
        tfViewsList.add(findViewById(R.id.urlField15));
        tfViewsList.add(findViewById(R.id.urlField16));


        Set<String> urlArrSetR = sharedPref.getStringSet("urlArrSet",new HashSet<String>());
        List<String> list = new ArrayList<String>(urlArrSetR);

        int i=0;
        String[] urlStrArr = new String[16];
        for (String str: list) {
            urlStrArr[i] = str;
            i++;
        }
        for (int j = 0; j < urlStrArr.length; j++) {
            tfViewsList.get(j).setText(urlStrArr[j]);
        }



        Button button = (Button) findViewById(R.id.doneBTN);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "BTN pressed");

                TreeSet<String> urlArrSet = new TreeSet<String>();

                for (int j = 0; j < urlStrArr.length; j++) {
                    urlArrSet.add(tfViewsList.get(j).getText().toString().trim());
                }

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
