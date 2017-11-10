package model;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by DSzustkowski on 06.11.17.
 */
public class MediaPlayerModel
{

    public enum PlayState
    {
        PLAYING,
        PAUSED,
        STOPPED,
        RESUMED
    }

    private PlayState playState = PlayState.STOPPED;

    AACPlayer aacPlayer;
    ArrayList<File> fileList = new ArrayList<File>();
    ArrayList<String> nameList = new ArrayList<String>();

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



}
