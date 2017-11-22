package main;

import gui.Mainframe;
import model.MediaPlayerModel;
import model.Props;

import java.io.IOException;

public class Main
{
	private static Mainframe mf;
	private static Props props;
    private static MediaPlayerModel mediaPlayerModel;


	public static void main(String[] args) throws IOException
	{
        mediaPlayerModel = new MediaPlayerModel();
		mf = new Mainframe();
		props = new Props();
		mf.initGui();
		props.propertiesIn();
	}
	
// ---------------------------------------------------
	public static Mainframe getMf()
	{
		return mf;
	}
	
// ---------------------------------------------------
	public static Props getProps()
	{
		return props;
	}

// ---------------------------------------------------
    public static MediaPlayerModel getMediaPlayerModel(){ return mediaPlayerModel;}

// ---------------------------------------------------

}
