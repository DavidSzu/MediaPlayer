package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import gui.Mainframe;
import main.Main;

public class Props
{
	File propsFile = new File("/Users/DSzustkowski/Documents/Code/Java/MediaPlayer/MediaPlayer/resources/properties.cfg");
	List<String> trackNameList = new ArrayList<String>();
	Mainframe mf = Main.getMf();

	// ---------------------------------------------------
	public void propertiesIn()
	{
		if (propsFile.exists())
		{
			try
			{
				Properties filesPropsIn = new Properties();
				filesPropsIn.loadFromXML(new FileInputStream(propsFile));
				
				int size = filesPropsIn.size();
//				for(int i = 1; i< size; i++)
				int i = 0;
				while(i < size)
				{						
					trackNameList.add(filesPropsIn.getProperty("ListEntry" + i));
					i++;
				}
			}
			catch (FileNotFoundException fnfe)
			{
				fnfe.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			return;
		}
	}

	// ---------------------------------------------------
	public void propertiesOut(List<String> filesListed)
	{
		Properties propertiesOut = new Properties();

		int size = filesListed.size();
		System.out.println(size);
		for (int i = 0; i < size; i++)
		{
			propertiesOut.setProperty("ListEntry" + i, filesListed.get(i));
		}

		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(propsFile);
		}
		catch (FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		try
		{
			propertiesOut.storeToXML(fos, "No comment");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

	}
}
