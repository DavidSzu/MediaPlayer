package model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by DSzustkowski on 06.11.17.
 */
public class MediaPlayerModel
{
    private AACPlayer aacPlayer;
    private ArrayList<File> fileList = new ArrayList<File>();
    private ArrayList<URL> urlList = new ArrayList<URL>();
    private ArrayList<String> nameList = new ArrayList<String>();
    private int trackNumber;
    private URL audioURL;


// ---------------------------------------------------
    public enum PlayState
    {
        PLAYING,
        PAUSED,
        STOPPED,
        RESUMED
    }
    private PlayState playState = PlayState.STOPPED;

// ---------------------------------------------------
    public enum RepeatState
    {
        LISTLOOPON,
        REPEATTRACK,
        REPEATLOOPOFF
    }
    private RepeatState repeatState = RepeatState.REPEATLOOPOFF;

// ---------------------------------------------------
    public enum ShuffleOnOff
    {
        SHUFFLEON,
        SHUFFLEOFF
    }
    private ShuffleOnOff shuffleState = ShuffleOnOff.SHUFFLEOFF;

// ---------------------------------------------------
    private void updatePlayState()
    {    	
        switch (playState)
        {
            case PLAYING:   aacPlayer.play(trackNumber);
            break;
            case PAUSED:    aacPlayer.pause();
            break;
            case STOPPED:   aacPlayer.stop();
            break;
            case RESUMED:   aacPlayer.resume();
            break;
            default: aacPlayer.stop();
        }
    }

    private void updateRepeatState()
    {
        switch (repeatState)
        {
            case LISTLOOPON:    aacPlayer.enableLoop();
            break;
            case REPEATTRACK:   aacPlayer.enableRepeat();
            break;
            case REPEATLOOPOFF: aacPlayer.disableLoop();    aacPlayer.disableRepeat();
            break;
        }
    }

    private void updateShuffleState()
    {
        switch (shuffleState)
        {
            case SHUFFLEON:     aacPlayer.isShuffleOn(true);
            break;
            case SHUFFLEOFF:    aacPlayer.isShuffleOn(false);
            break;
        }
    }

// ---------------------------------------------------
// ---------------------------------------------------
    public void addPlayer ()
    {
        aacPlayer = new AACPlayer(fileList);
    }

// ---------------------------------------------------
    public ArrayList<File> getFileList()
    {
        return fileList;
    }
    
// ---------------------------------------------------
    public ArrayList<URL> getUrlList()
	{
		return urlList;
	}

// ---------------------------------------------------
    public ArrayList<String> getNameList()
    {
        return nameList;
    }

// ---------------------------------------------------
    public AACPlayer getAacPlayer()
    {
        return aacPlayer;
    }

// ---------------------------------------------------
    public PlayState getPlayState()
    {
        return playState;
    }
    public void setPlayState(PlayState playState)
    {
        this.playState = playState;
        updatePlayState();
    }

// ---------------------------------------------------
    public RepeatState getRepeatState()
    {
        return repeatState;
    }
    public void setRepeatState(RepeatState repeatState)
    {
        this.repeatState = repeatState;
        updateRepeatState();
    }

// ---------------------------------------------------
    public ShuffleOnOff getShuffleState()
    {
        return shuffleState;
    }

    public void setShuffleState(ShuffleOnOff shuffleState)
    {
        this.shuffleState = shuffleState;
        updateShuffleState();
    }

// ---------------------------------------------------
    public void setTrackNumber(int trackNumber)
    {
        this.trackNumber = trackNumber;
    }

// ---------------------------------------------------
    public URL getAudioURL()
    {
        return audioURL;
    }

    public void setAudioURL(int index)
    {
        this.audioURL = urlList.get(index);
    }

}
