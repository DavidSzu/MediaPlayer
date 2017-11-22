package model;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

import main.Main;

/**
 * Created by DSzustkowski on 17.11.17.
 */
public class BACPlayer
{
	private Mixer mixer;
	private Clip clip;
	private MediaPlayerModel mediaPlayerModel = Main.getMediaPlayerModel();
	private long cliptime;

	public BACPlayer()
	{
		Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfo[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try
		{
			clip = (Clip) mixer.getLine(dataInfo);
		}
		catch (LineUnavailableException lue)
		{
			lue.printStackTrace();
		}
	}

	public void play()
	{
		try
		{
			URL soundURL = mediaPlayerModel.getAudioURL();
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
			//clip.start();
		}
		
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void pause()
	{
		cliptime = clip.getMicrosecondPosition();
		clip.stop();
	}

	public void resume()
	{
		clip.setMicrosecondPosition(cliptime);
		clip.start();
	}

	public void stop()
	{
		clip.stop();
	}
}
