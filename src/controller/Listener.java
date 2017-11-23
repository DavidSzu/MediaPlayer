package controller;

import gui.Mainframe;
import main.Main;
import model.FileHandler;
import model.MediaPlayerModel;
import model.MediaPlayerModel.PlayState;
import model.MediaPlayerModel.RepeatState;
import model.MediaPlayerModel.ShuffleOnOff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class Listener implements ActionListener
{
	private MediaPlayerModel mediaPlayerModel = Main.getMediaPlayerModel();
	private Mainframe mf = Main.getMf();

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
		System.out.println(mediaPlayerModel.getFileList());
		mf.addMediaList(mediaPlayerModel.getFileList());
<<<<<<< HEAD
//		mediaPlayerModel.addBACPlayer();
		mediaPlayerModel.addAACPlayer();
=======
//		mf.setMediaList(new JList(mediaPlayerModel.getFileList().toArray()));
//		mf.getMediaList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		JScrollPane scrollPane = new JScrollPane(mf.getMediaList());
//		scrollPane.setBounds(0, 0, 984, 500);
//		mf.getMainPanel().add(scrollPane);
//		scrollPane.setViewportView(mf.getMediaList());
		mediaPlayerModel.addPlayer();
>>>>>>> 639d6baa503ab192f24719130aae8d2d4c6fa771
	}

// ---------------------------------------------------
	private void manageButtonStartPause()
	{
		if(!mf.getMediaList().isSelectionEmpty())
		{
			if (mediaPlayerModel.getPlayState() != PlayState.PLAYING)
			{
				mediaPlayerModel.setTrackNumber(mf.getMediaList().getSelectedIndex());
				mediaPlayerModel.setAudioURL(mf.getMediaList().getSelectedIndex());
				mediaPlayerModel.setPlayState(PlayState.PLAYING);
				mf.getBtnStartPause().setText("Pause");
			}
			else if (mediaPlayerModel.getPlayState() == PlayState.PLAYING)
			{
				mediaPlayerModel.setPlayState(PlayState.PAUSED);
				mf.getBtnStartPause().setText("Resume");
			}
			else if (mediaPlayerModel.getPlayState() != PlayState.PLAYING)
			{
				mediaPlayerModel.setPlayState(PlayState.RESUMED);
				mf.getBtnStartPause().setText("Pause");
			}
		}
		else
		{
			if (mediaPlayerModel.getPlayState() != PlayState.PLAYING )
			{
				mediaPlayerModel.setPlayState(PlayState.PLAYING);
				mf.getBtnStartPause().setText("Pause");
			}
			else if (mediaPlayerModel.getPlayState() == PlayState.PLAYING)
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.PAUSED);
				mf.getBtnStartPause().setText("Resume");
			}
			else if (mediaPlayerModel.getPlayState() != PlayState.PLAYING)
			{
				mediaPlayerModel.setPlayState(MediaPlayerModel.PlayState.RESUMED);
				mf.getBtnStartPause().setText("Pause");
			}
		}
	}

// ---------------------------------------------------
	private void manageButtonRepeatLoop()
	{

		if (mediaPlayerModel.getRepeatState() == RepeatState.REPEATLOOPOFF)
		{
			mediaPlayerModel.setRepeatState(RepeatState.LISTLOOPON);
			mf.getBtnRepeatloop().setText("Loop on");
		}
		else if (mediaPlayerModel.getRepeatState() == RepeatState.LISTLOOPON)
		{
			mediaPlayerModel.setRepeatState(RepeatState.REPEATTRACK);
			mf.getBtnRepeatloop().setText("Repeat on");
		}
		else
		{
			mediaPlayerModel.setRepeatState(RepeatState.REPEATLOOPOFF);
			mf.getBtnRepeatloop().setText("Loop off");
		}
	}

// ---------------------------------------------------
	private void manageButtonStop()
	{
		if (mediaPlayerModel.getPlayState() == PlayState.PLAYING)
		{
			mediaPlayerModel.setPlayState(PlayState.STOPPED);
			mf.getBtnStartPause().setText("Start");
		}
	}

// ---------------------------------------------------
	private void manageButtonShuffle()
	{
		if (mediaPlayerModel.getShuffleState() == ShuffleOnOff.SHUFFLEOFF && mf.getBtnShuffle().getText() == "Enable Shuffle")
		{
			mediaPlayerModel.setShuffleState(ShuffleOnOff.SHUFFLEON);
		}
		else
		{
			mediaPlayerModel.setShuffleState(ShuffleOnOff.SHUFFLEOFF);
		}
	}
}