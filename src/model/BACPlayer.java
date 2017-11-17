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

	public void playAudio()
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

		try
		{
			URL soundURL = mediaPlayerModel.getAudioURL();
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
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
}
