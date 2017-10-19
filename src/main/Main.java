package main;

import java.io.IOException;

import gui.Mainframe;
import model.Props;

public class Main
{
	private static Mainframe mf;
	private static Props props;


	public static void main(String[] args) throws IOException
	{
		Thread.currentThread();
		props = new Props();
		mf = new Mainframe();
		mf.run();
//		props.propertiesIn();
	}
	
// ---------------------------------------------------
	public static Mainframe getMf()
	{
		return mf;
	}
	public static void setMf(Mainframe newMf)
	{
		mf = newMf;
	}
	
// ---------------------------------------------------
	public static Props getProps()
	{
		return props;
	}

}
