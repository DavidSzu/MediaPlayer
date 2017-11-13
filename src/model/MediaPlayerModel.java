package model;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by DSzustkowski on 06.11.17.
 */
public class MediaPlayerModel
{
    AACPlayer aacPlayer;
    ArrayList<File> fileList = new ArrayList<File>();
    ArrayList<String> nameList = new ArrayList<String>();

// ---------------------------------------------------
    public enum PlayState
    {
        PLAYING,
        PAUSED,
        STOPPED,
        RESUMED
    }
    private PlayState playState = PlayState.STOPPED;

    private void notifyPlayer()
    {
        playState.notify();
    }

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
    }

// ---------------------------------------------------
    public RepeatState getRepeatState()
    {
        return repeatState;
    }
    public void setRepeatState(RepeatState repeatState)
    {
        this.repeatState = repeatState;
    }

// ---------------------------------------------------
    public ShuffleOnOff getShuffleState()
    {
        return shuffleState;
    }

    public void setShuffleState(ShuffleOnOff shuffleState)
    {
        this.shuffleState = shuffleState;
    }

// ---------------------------------------------------

}
