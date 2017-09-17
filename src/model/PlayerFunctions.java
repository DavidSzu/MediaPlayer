package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayerFunctions
{
	private FileInputStream FIS;
	private BufferedInputStream BIS;
	private Player player;
	
	private long pauseLocation;
	private long totalLength;
	public String fileLocation;


	public boolean isplaying = false;
	
//---------------------------------------------------			
	public void playAudio(String path)
	{
		try
		{
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);
			
			player = new Player(BIS);
			
			totalLength = FIS.available();
			
			fileLocation = path + "";
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

//---------------------------------------------------			
	public void stopAudio()
	{
		if(player != null)
		{
			player.close();
			
			pauseLocation = 0;
			totalLength = 0;
		}
	}
	
	public void pauseAudio()
	{
		if(player != null)
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
	
//---------------------------------------------------		
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



