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
    private BACPlayer bacPlayer;
    private ArrayList<File> fileList = new ArrayList<File>();
    private ArrayList<URL> urlList = new ArrayList<URL>();
    private ArrayList<String> nameList = new ArrayList<String>();
    private int trackNumber;
    private URL audioURL;
    private String fileExtension = null;


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
        switch (fileExtension)
        {
            case "m4a": playAAC();
            break;
            case "mp3": playBAC();
            break;
            case "wav": playBAC();
            break;
            case "aac": playAAC();
            break;
            default: fileExtension = null;
        }

    }

    private void updateRepeatState()
    {
        switch (repeatState)
        {
            case LISTLOOPON:    enableLoop();
            break;
            case REPEATTRACK:   enableRepeat();
            break;
            case REPEATLOOPOFF: setRepeatLoopOff();
            break;
            default: setRepeatLoopOff();
        }
    }

    private void updateShuffleState()
    {
        switch (shuffleState)
        {
            case SHUFFLEON:     setShuffleOn();
            break;
            case SHUFFLEOFF:    setShuffleOff();
            break;
            default: setShuffleOff();
        }
    }

    private void playAAC()
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

    private void playBAC()
    {
        switch (playState)
        {
            case PLAYING:   bacPlayer.play();
                break;
            case PAUSED:    bacPlayer.pause();
                break;
            case STOPPED:   bacPlayer.stop();
                break;
            case RESUMED:   bacPlayer.resume();
                break;
            default: aacPlayer.stop();
        }
    }

    private void setShuffleOn()
    {
        aacPlayer.isShuffleOn(true);
      //bacPlayer.isShuffleOn(true)
    }
    private void setShuffleOff()
    {
        aacPlayer.isShuffleOn(false);
      //bacPlayer.isShuffleOn(false);
    }

    private void enableLoop()
    {
        aacPlayer.enableLoop();
      //bacPlayer.enableLoop();
    }
    private void enableRepeat()
    {
        aacPlayer.enableRepeat();
      //bacPlayer.enableRepeat();
    }
    private void setRepeatLoopOff()
    {
        aacPlayer.disableLoop();
        aacPlayer.disableRepeat();
      //bacPlayer.disableLoop();
      //bacPlayer.disableRepeat();
    }

// ---------------------------------------------------
// ---------------------------------------------------
    public void addAACPlayer()
    {
        aacPlayer = new AACPlayer(fileList);
    }

    public void addBACPlayer()
    {
        bacPlayer = new BACPlayer();
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

// ---------------------------------------------------
    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

}
