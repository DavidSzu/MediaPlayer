package gui;

import controller.Listener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Mainframe extends JFrame
{
	// ---------------------------------------------------
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel panelControlButtons;

	private JButton btnBackward;
	private JButton btnStartPause;
	private JButton btnForward;
	private JButton btnStop;
	private JButton btnShuffle;
	private JButton btnRepeatLoop;

	private JMenuBar menuBar;
	private JMenu mnFileMenu;
	private JMenuItem menuItemOpen;
	private JMenu mnTitelMenu;

	private JLabel lblTrackProgress;
	private JLabel lblTrackDuration;

	private JList<File> mediaList;

	private JPanel panelSouth;
	private JProgressBar progressBar;

// ---------------------------------------------------

	public void initGui() throws IOException
	{
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 740);
		setTitle("Media Player");
		setResizable(false);
		Listener listener = new Listener();

		// ---------------------------------------------------
		// Panels:
		initGUIPanels();

		// ---------------------------------------------------
		// Buttons:
		initGUIButtons(listener);

		// ---------------------------------------------------
		// Miscellaneous:
		initGUIProgressbar();

		// ---------------------------------------------------
		// Menus:
		initGUIMenus(listener);

		// ---------------------------------------------------
		// End of constructor
		setVisible(true);
	}
// ---------------------------------------------------
	private void initGUIPanels()
	{
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 21, 984, 697);
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		panelSouth = new JPanel();
		panelSouth.setBounds(0, 649, 984, 49);
		mainPanel.add(panelSouth);
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setLayout(null);
		// mainPanel.setLayout();

		panelControlButtons = new JPanel();
		panelSouth.add(panelControlButtons);
		panelControlButtons.setBounds(0, 5, 984, 39);
		panelControlButtons.setForeground(Color.LIGHT_GRAY);
		panelControlButtons.setBackground(Color.LIGHT_GRAY);
		panelControlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

// ---------------------------------------------------
	private void initGUIButtons(Listener listener)
	{
		setBtnBackward(new JButton("Backward"));
		getBtnBackward().addActionListener(listener);

		setBtnShuffle(new JButton("Enable Shuffle"));
		getBtnShuffle().addActionListener(listener);
		panelControlButtons.add(getBtnShuffle());
		panelControlButtons.add(getBtnBackward());

		setBtnForward(new JButton("Forward"));
		getBtnForward().addActionListener(listener);

		setBtnStartPause(new JButton("Start"));
		getBtnStartPause().addActionListener(listener);
		panelControlButtons.add(getBtnStartPause());
		panelControlButtons.add(getBtnForward());

		setBtnStop(new JButton("Stop"));
		getBtnStop().addActionListener(listener);
		panelControlButtons.add(getBtnStop());

		setBtnRepeatloop(new JButton("Loop off"));
		getBtnRepeatloop().addActionListener(listener);
		panelControlButtons.add(btnRepeatLoop);
	}

// ---------------------------------------------------
	private void initGUIMenus(Listener listener)
	{
		menuBar = new JMenuBar();
		getJMenuBar().setBounds(0, 0, 985, 21);
		contentPane.add(menuBar);

		setMnFileMenu(new JMenu("File"));
		getJMenuBar().add(getMenuFileMenu());

		setMntmOpen(new JMenuItem("Open"));
		getMenuFileMenu().add(getMenuItemOpen());
		getMenuItemOpen().addActionListener(listener);

		setMnTitelMenu(new JMenu("Titel"));
		getJMenuBar().add(getMenuTitelMenu());
		getJMenuBar().setVisible(true);
	}

// ---------------------------------------------------
	private void initGUIProgressbar()
	{
		setLblTrackProgress(new JLabel("--:--"));

		progressBar = new JProgressBar();
		panelControlButtons.add(progressBar);

		setLblTrackDuration(new JLabel("--:--"));
	}

// ---------------------------------------------------
	@SuppressWarnings(
			{ "unchecked", "rawtypes" })
	public void addMediaList(ArrayList<File> filesListed)
	{
		setMediaList(new JList(filesListed.toArray()));
		getMediaList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(getMediaList());
		scrollPane.setBounds(0, 0, 984, 500);
		getMainPanel().add(scrollPane);
		scrollPane.setViewportView(getMediaList());
	}


// ---------------------------------------------------
	// Getters and Setters:

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	// ---------------------------------------------------
	public JButton getBtnShuffle()
	{
		return btnShuffle;
	}

	public void setBtnShuffle(JButton btnShuffle)
	{
		this.btnShuffle = btnShuffle;
	}

	// ---------------------------------------------------
	public JButton getBtnStop()
	{
		return btnStop;
	}

	public void setBtnStop(JButton btnStop)
	{
		this.btnStop = btnStop;
	}

	// ---------------------------------------------------
	public JButton getBtnBackward()
	{
		return btnBackward;
	}

	public void setBtnBackward(JButton btnBackward)
	{
		this.btnBackward = btnBackward;
	}

	// ---------------------------------------------------
	public JButton getBtnStartPause()
	{
		return btnStartPause;
	}

	public void setBtnStartPause(JButton btnStartPause)
	{
		this.btnStartPause = btnStartPause;
	}

	// ---------------------------------------------------
	public JButton getBtnForward()
	{
		return btnForward;
	}

	public void setBtnForward(JButton btnForward) { this.btnForward = btnForward; }

	// ---------------------------------------------------
	public JButton getBtnRepeatloop()
	{
		return btnRepeatLoop;
	}

	public void setBtnRepeatloop(JButton btnRepeatloop)
	{
		this.btnRepeatLoop = btnRepeatloop;
	}

	// ---------------------------------------------------
	public JMenuBar getJMenuBar()
	{
		return menuBar;
	}

	public void setJMenuBar(JMenuBar menuBar)
	{
		this.menuBar = menuBar;
	}

	// ---------------------------------------------------
	public JMenu getMenuFileMenu()
	{
		return mnFileMenu;
	}

	public void setMnFileMenu(JMenu mnFileMenu)
	{
		this.mnFileMenu = mnFileMenu;
	}

	// ---------------------------------------------------
	public JMenuItem getMenuItemOpen()
	{
		return menuItemOpen;
	}

	public void setMntmOpen(JMenuItem mntmOpen)
	{
		this.menuItemOpen = mntmOpen;
	}

	// ---------------------------------------------------
	public JMenu getMenuTitelMenu()
	{
		return mnTitelMenu;
	}

	public void setMnTitelMenu(JMenu mnTitelMenu)
	{
		this.mnTitelMenu = mnTitelMenu;
	}

	// ---------------------------------------------------
	public JLabel getLblTrackProgress()
	{
		return lblTrackProgress;
	}

	public void setLblTrackProgress(JLabel lblTrackProgress)
	{
		this.lblTrackProgress = lblTrackProgress;
		panelControlButtons.add(lblTrackProgress);
	}

	// ---------------------------------------------------
	public JLabel getLblTrackDuration()
	{
		return lblTrackDuration;
	}

	public void setLblTrackDuration(JLabel lblTrackDuration)
	{
		this.lblTrackDuration = lblTrackDuration;
		panelControlButtons.add(lblTrackDuration);
	}

	// ---------------------------------------------------
	public JList<File> getMediaList()
	{
		return mediaList;
	}

	public void setMediaList(JList<File> mediaList)
	{
		this.mediaList = mediaList;
	}

	// ---------------------------------------------------
}
