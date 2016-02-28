package org.wrsu.marshal.officialwrsu;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.content.Context;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.IOException;

import static android.media.AudioManager.STREAM_MUSIC;

import org.wrsu.marshal.officialwrsu.AudioHandler;

public  class PlayerActivity extends AppCompatActivity  {

    private static MediaPlayer mp;
    private Button playButton, wrsuB1, wrsuB2, wrsuB3;
    private static String wrsuStreamPath;
    AudioHandler ah;
    private static boolean streamPlaying = false;
    File streamFile;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wrsuStreamPath = getResources().getString(R.string.wrsu_stream_1);
        ah = new AudioHandler(wrsuStreamPath,this);
        
        // play button
        this.playButton = (Button) this.findViewById(R.id.playButton);
        this.playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               System.out.println("YOU CLICKED THE BUTTON");
                if (!streamPlaying) {
                    ah.startPlaying(wrsuStreamPath);
                    streamPlaying = true;
                } else {
                    ah.stopPlaying();
                    streamPlaying = false;
                }
            }
        });

        // WRSU 1 Button
        this.wrsuB1 = (Button) this.findViewById(R.id.wrsuB1);
        this.wrsuB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Station changed to WRSU 1 Stream");
                wrsuStreamPath = getResources().getString(R.string.wrsu_stream_1);
            }
        });

        // WRSU 2 Button
        this.wrsuB2 = (Button) this.findViewById(R.id.wrsuB2);
        this.wrsuB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Station changed to WRSU 2 Stream");
                wrsuStreamPath = getResources().getString(R.string.wrsu_stream_2);

            }
        });

        // WRSU 3 Button
        this.wrsuB3 = (Button) this.findViewById(R.id.wrsuB3);
        this.wrsuB3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Station changed to WRSU 3 Stream");
                wrsuStreamPath = getResources().getString(R.string.wrsu_stream_3);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Player Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://org.wrsu.marshal.officialwrsu/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Player Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://org.wrsu.marshal.officialwrsu/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
