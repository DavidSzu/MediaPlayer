package main;

import java.io.IOException;

import gui.Mainframe;

public class Main
{
	private static Mainframe mf;

	public static void main(String[] args) throws IOException
	{
		mf = new Mainframe();
		mf.run();
	}

	public static Mainframe getMf()
	{
		return mf;
	}

	public static void setMf(Mainframe newMf)
	{
		mf = newMf;
	}

}
