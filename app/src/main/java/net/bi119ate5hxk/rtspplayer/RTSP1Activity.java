package net.bi119ate5hxk.rtspplayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;


public class RTSP1Activity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtsp1);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        String url = "";
        if (extras == null) {
            Log.d("NO Extras","extras is null");
            super.onBackPressed();
            return;
        }
        url = extras.getString("url");

        if (url.isEmpty()) {
            Log.d("NO URL","URL is empty");
            super.onBackPressed();
            return;
        }
        Log.d("URL",url);
        LibVLC libVlc = new LibVLC(this);
        MediaPlayer mediaPlayer = new MediaPlayer(libVlc);
        VLCVideoLayout videoLayout = findViewById(R.id.videoLayout);

        mediaPlayer.attachViews(videoLayout, null, false, false);

        Media media = new Media(libVlc, Uri.parse(url));
        media.setHWDecoderEnabled(true, false);
        media.addOption(":network-caching=600");

        mediaPlayer.setMedia(media);
        media.release();
        mediaPlayer.play();
    }


}
