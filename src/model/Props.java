package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import gui.Mainframe;
import main.Main;

public class Props
{
	File propsFile = new File("/Users/DSzustkowski/Documents/Code/Java/MediaPlayer/MediaPlayer/resources/properties.cfg");
	List<String> trackNameList;
	Mainframe mf = Main.getMf();

	// ---------------------------------------------------
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public void propertiesIn()
	{
		if (propsFile.exists())
		{
			try
			{
				Properties filesPropsIn = new Properties();
				filesPropsIn.loadFromXML(new FileInputStream(propsFile));
				
				int size = filesPropsIn.size();
				for(int i = 0; i< size; i++)
				{
					trackNameList.add(filesPropsIn.getProperty("ListEntry" + i));
				}
//
//				DefaultListModel<String> listModel = mf.getListModel();
//				mf.setMediaList(new JList(listModel));
//				for (int i = 0; i < filesPropsIn.size(); i++)
//				{
//					listModel.addElement(filesPropsIn.getProperty("ListEntry" + i));
//				}
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
