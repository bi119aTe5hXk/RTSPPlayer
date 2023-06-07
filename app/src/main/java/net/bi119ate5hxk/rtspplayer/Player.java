package net.bi119ate5hxk.rtspplayer;
import android.content.Context;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.IdRes;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;
//import android.media.MediaPlayer;
//import com.google.android.exoplayer2.ExoPlayer;
//import com.google.android.exoplayer2.MediaItem;
//import com.google.android.exoplayer2.source.MediaSource;
//import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
//import com.google.android.exoplayer2.ui.StyledPlayerView;


public class Player {

    //ExoPlayer player;
    Media media;
    MediaPlayer mediaPlayer;
    LibVLC libVlc;

    public Player(String url, VLCVideoLayout playerView, Context context) {
        if (url.isEmpty()) {
            Log.d("NO URL", "URL is empty");
            return;
        }
        Log.d("URL", url);
        libVlc = new LibVLC(context);
        mediaPlayer = new MediaPlayer(libVlc);
        mediaPlayer.attachViews(playerView, null, false, false);

        media = new Media(libVlc, Uri.parse(url));
        media.setHWDecoderEnabled(true, false);
        //media.addOption(":network-caching=600");
        media.addOption(":no-audio");
        media.addOption(":quiet");
        mediaPlayer.setMedia(media);
        media.release();
        mediaPlayer.play();

//        MediaSource mediaSource =
//                new RtspMediaSource.Factory()
//                        .createMediaSource(MediaItem.fromUri(url));
//        player = new ExoPlayer.Builder(context)
//                .setMediaSourceFactory(new RtspMediaSource.Factory().setDebugLoggingEnabled(true))
//                .build();
//        playerView.setPlayer(player);
//        player.setMediaSource(mediaSource);
//        player.prepare();
//        player.play();


//        Thread t = new Thread() {
//            public void run() {
//
//            }
//        };
//        t.start();
    }


    public void stopPlayer(){
        mediaPlayer.stop();
        mediaPlayer.getVLCVout().detachViews();
        mediaPlayer.release();
        libVlc.release();
        Log.i("INFO","Play stopped");
    }


}
