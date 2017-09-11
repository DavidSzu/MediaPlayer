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

public class PlayerFunctions
{
	FileInputStream FIS;
	BufferedInputStream BIS;
	Mixer mixer;
	Clip clip;
	
	public boolean isplaying = false;
	

	
	public void playAudio(String path)
	{
		Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfo[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try
		{
			clip = (Clip)mixer.getLine(dataInfo);
		}
		catch (LineUnavailableException lue)
		{
			lue.printStackTrace();
		}
		
		try
		{
			URL fileURL = PlayerFunctions.class.getResource(path);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileURL);
			clip.open(audioStream);
		}
		catch(LineUnavailableException lue)
		{
			lue.printStackTrace();
		}
		catch(UnsupportedAudioFileException uafe)
		{
			uafe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		clip.start();
		isplaying = true;
	}



	public boolean isIsplaying()
	{
		return isplaying;
	}

	public void setIsplaying(boolean isplaying)
	{
		this.isplaying = isplaying;
	}
}



