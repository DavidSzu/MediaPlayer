package controller;

import gui.Mainframe;
import main.Main;
import model.AACPlayer;
import model.FileHandler;
import model.MediaPlayerModel;
import model.Setup;
import model.Setup.Repeatstate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class Listener implements ActionListener
{
	MediaPlayerModel mediaPlayerModel = Main.getMediaPlayerModel();

	private Setup setup = new Setup();
	private Mainframe mf = Main.getMf();
	private AACPlayer aacPlayer = mediaPlayerModel.getAacPlayer();
	


// ---------------------------------------------------
	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();


		if (source == mf.getMenuItemOpen())
		{
			manageMenuItemOpen();
		}

		if (source == mf.getBtnStartPause())
		{
			manageButtonStartPause();
		}

		if (source == mf.getBtnStop())
		{
			manageButtonStop();
		}

		if (source == mf.getBtnShuffle())
		{
			manageButtonShuffle();
		}
		
		if (source == mf.getBtnRepeatloop())
		{
			manageButtonRepeatLoop();
		}
	}
// ---------------------------------------------------
// ---------------------------------------------------
	private void manageMenuItemOpen()
	{
		FileHandler fileHandler = new FileHandler();
		Path directoryName = fileHandler.chooseDirectory();
		fileHandler.listf(directoryName.toString());
		mf.addMediaList(mediaPlayerModel.getFileList());
		mediaPlayerModel.addPlayer();
	}

// ---------------------------------------------------
	private void manageButtonStartPause()
	{
		if(aacPlayer == null)
		{
			System.out.println("aacPlay == null");
		}
		if(!mf.getMediaList().isSelectionEmpty())
		{
			if (!mediaPlayerModel.getPlayState().PLAYING && (mf.getBtnStartPause().getText() == "Start"))
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.PLAYING);
//				aacPlayer.play(mf.getMediaList().getSelectedIndex());
				mf.getBtnStartPause().setText("Pause");
			}
			else if (mediaPlayerModel.getPlayState().PLAYING)
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.PAUSED);
				mf.getBtnStartPause().setText("Resume");
			}
			else if (!mediaPlayerModel.getPlayState().PLAYING  && (mf.getBtnStartPause().getText() == "Resume"))
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.RESUMED);
//				aacPlayer.resume();
				mf.getBtnStartPause().setText("Pause");
			}
		}
		else
		{
			if (!mediaPlayerModel.getPlayState().PLAYING && (mf.getBtnStartPause().getText() == "Start"))
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.PLAYING);
//				aacPlayer.play(0);
				mf.getBtnStartPause().setText("Pause");
			}
			else if (mediaPlayerModel.getPlayState().PLAYING)
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.PAUSED);
//				aacPlayer.pause();
				mf.getBtnStartPause().setText("Resume");
			}
			else if (!aacPlayer.isPlaying() && (mf.getBtnStartPause().getText() == "Resume"))
			{
				aacPlayer.resume();
				mf.getBtnStartPause().setText("Pause");
			}
		}
	}

// ---------------------------------------------------
	private void manageButtonRepeatLoop()
	{
		setup.getRepstate();
		if (setup.getRepstate() == Repeatstate.REPEATLOOPOFF)
		{
			setup.setRepstate(Repeatstate.LISTLOOPON);
			mf.getBtnRepeatloop().setText("Loop on");
			aacPlayer.enableLoop();
		}
		else if (setup.getRepstate() == Repeatstate.LISTLOOPON)
		{
			setup.setRepstate(Repeatstate.REPEATTRACK);
			mf.getBtnRepeatloop().setText("Repeat on");
			aacPlayer.disableLoop();
			aacPlayer.enableRepeat();
		}
		else
		{
			setup.setRepstate(Repeatstate.REPEATLOOPOFF);
			mf.getBtnRepeatloop().setText("Loop off");
			aacPlayer.disableLoop();
			aacPlayer.disableRepeat();
		}
	}

// ---------------------------------------------------
	private void manageButtonStop()
	{
		if (aacPlayer.isPlaying())
		{
			aacPlayer.stop();
			mf.getBtnStartPause().setText("Start");
		}
	}

// ---------------------------------------------------
	private void manageButtonShuffle()
	{
		if (mf.getBtnShuffle().getText() == "Enable Shuffle")
		{
		}
	}
}