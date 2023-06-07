package net.bi119ate5hxk.rtspplayer;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.exoplayer2.ui.StyledPlayerView;
import org.videolan.libvlc.util.VLCVideoLayout;


public class RTSP16Activity extends AppCompatActivity {

    ArrayList<Player> pList =new ArrayList<>();
    ArrayList<String> urlList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtsp16);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.d("NO Extras","extras is null");
            super.onBackPressed();
            return;
        }
        urlList = extras.getStringArrayList("urls");
        if (urlList.size() == 0){
            Log.d("NO URLs","url list is empty");
            super.onBackPressed();
            return;
        }


        ArrayList<VLCVideoLayout> viewsList =new ArrayList<>();
        viewsList.add(findViewById(R.id.videoLayout1));
        viewsList.add(findViewById(R.id.videoLayout2));
        viewsList.add(findViewById(R.id.videoLayout3));
        viewsList.add(findViewById(R.id.videoLayout4));
        viewsList.add(findViewById(R.id.videoLayout5));
        viewsList.add(findViewById(R.id.videoLayout6));
        viewsList.add(findViewById(R.id.videoLayout7));
        viewsList.add(findViewById(R.id.videoLayout8));
        viewsList.add(findViewById(R.id.videoLayout9));
        viewsList.add(findViewById(R.id.videoLayout10));
        viewsList.add(findViewById(R.id.videoLayout11));
        viewsList.add(findViewById(R.id.videoLayout12));
        viewsList.add(findViewById(R.id.videoLayout13));
        viewsList.add(findViewById(R.id.videoLayout14));
        viewsList.add(findViewById(R.id.videoLayout15));
        viewsList.add(findViewById(R.id.videoLayout16));

        for (int i = 0; i < urlList.size(); i++) {
            pList.add(new Player(urlList.get(i), viewsList.get(i), this));
        }

    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
    @Override
    public void onStop() {
        super.onStop();
        for (Player p : pList) {
            p.stopPlayer();
        }
    }


}
