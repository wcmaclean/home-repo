package com.robotoctopus.framework.util;

import java.io.IOException;

import com.robotoctopus.eyepopping.R;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
	
public class MultipleMediaPlayer extends Activity implements MediaPlayer.OnCompletionListener {
 int [] songs;
MediaPlayer mediaPlayer;
int current_index = 0; 

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);

		//songs= new int[] {R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4};
		mediaPlayer = MediaPlayer.create(this, songs[0]);
		mediaPlayer.setOnCompletionListener(this);
		mediaPlayer.start();
	}

	@Override
    public void onCompletion(MediaPlayer mp) {
        play();
    }

 private void play(){
        current_index = (current_index +1)% 4;
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(songs[current_index]);
        try
        {   
            mediaPlayer.reset();
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
            afd.close();
        }
        catch (IllegalArgumentException e)
        {
            //Log.e("Music", "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
        catch (IllegalStateException e)
        {
            //Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
        catch (IOException e)
        {
            //Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
    }
}

