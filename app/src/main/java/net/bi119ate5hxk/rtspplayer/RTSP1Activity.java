package net.bi119ate5hxk.rtspplayer;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.exoplayer2.ui.StyledPlayerView;



public class RTSP1Activity extends AppCompatActivity{

    Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtsp1);

        Bundle extras = getIntent().getExtras();
        String url = "";
        if (extras == null) {
            Log.d("NO Extras","extras is null");
            super.onBackPressed();
            return;
        }
        url = extras.getString("url");

        p = new Player(url,findViewById(R.id.videoLayout),this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
        p.stopPlayer();
    }

}
