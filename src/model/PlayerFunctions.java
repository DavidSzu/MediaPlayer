package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayerFunctions
{
	private FileInputStream FIS;
	private BufferedInputStream BIS;
	private Player player;

	private static Mixer mixer;
	private static Clip clip;

	private long pauseLocation;
	private long totalLength;
	public String fileLocation;

	public boolean isplaying = false;

	// ---------------------------------------------------
	public void playAudio(URL url)
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
			URL audioURL = url;
			// URL soundURL = PlayerFunctions.class.getResource("Testaudio/EarTrainingAudio-03D.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioURL); // uses an URL to get the audio file

			clip.open(audioStream);
		}

		catch (LineUnavailableException lue)
		{
			lue.printStackTrace();
		}
		catch (UnsupportedAudioFileException uafe)
		{
			uafe.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		clip.start();
		// Media song = new Media(path);
		// MediaPlayer player = new MediaPlayer(song);
		//
		// new Thread()
		// {
		// public void run()
		// {
		// player.play();
		// setIsplaying(true);
		// }
		// }.start();

		// try
		// {
		//// fileLocation = file.toString();
		//
		// FIS = new FileInputStream(path);
		// BIS = new BufferedInputStream(FIS);
		//
		// player = new Player(BIS);
		//
		// totalLength = FIS.available();
		// }
		// catch (FileNotFoundException e)
		// {
		// e.printStackTrace();
		// }
		// catch (JavaLayerException e)
		// {
		// e.printStackTrace();
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		//
		// new Thread()
		// {
		// @Override
		// public void run()
		// {
		// try
		// {
		// player.play();
		// setIsplaying(true);
		// }
		// catch (JavaLayerException e)
		// {
		// e.printStackTrace();
		// }
		// }
		// }.start();
	}

	// ---------------------------------------------------
	public void stopAudio()
	{
		if (player != null)
		{
			player.close();

			pauseLocation = 0;
			totalLength = 0;
		}
	}

	public void pauseAudio()
	{
		if (player != null)
		{
			try
			{
				pauseLocation = FIS.available();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			player.close();
		}
	}

	// ---------------------------------------------------
	public void resumeAudio()
	{
		try
		{
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			FIS.skip(totalLength - pauseLocation);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (JavaLayerException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					player.play();
					setIsplaying(true);
				}
				catch (JavaLayerException e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}

	public boolean getIsplaying()
	{
		return isplaying;
	}

	public void setIsplaying(boolean isplaying)
	{
		this.isplaying = isplaying;
	}
}
