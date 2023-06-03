package net.bi119ate5hxk.rtspplayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;

import java.util.ArrayList;

public class RTSP4Activity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtsp4);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        ArrayList<String> urlList = new ArrayList<String>();
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
        if (urlList.size() >= 1){
            createVLCPlayer(urlList.get(0),R.id.videoLayout1);
        }
        if (urlList.size() >= 2){
            createVLCPlayer(urlList.get(1),R.id.videoLayout2);
        }
        if (urlList.size() >= 3) {
            createVLCPlayer(urlList.get(2),R.id.videoLayout3);
        }

        if (urlList.size() >= 4) {
            createVLCPlayer(urlList.get(3),R.id.videoLayout4);
        }

    }

    protected void createVLCPlayer(String url, @IdRes int viewId){
        if (url.isEmpty()) {
            Log.d("NO URL","URL is empty");
            return;
        }
        Log.d("URL",url);
        LibVLC libVlc = new LibVLC(this);
        MediaPlayer mediaPlayer = new MediaPlayer(libVlc);
        VLCVideoLayout videoLayout = findViewById(viewId);

        mediaPlayer.attachViews(videoLayout, null, false, false);

        Media media = new Media(libVlc, Uri.parse(url));
        media.setHWDecoderEnabled(true, false);
        media.addOption(":network-caching=600");

        mediaPlayer.setMedia(media);
        media.release();
        mediaPlayer.play();
    }


}
